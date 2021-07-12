package exam;

import java.util.Map;
import java.util.Objects;

public class ExamScoringService {

    public ExamResult countPoints(Map<Integer, Answer> userAnswers, Map<Integer, Answer> correctAnswers, PointsCountingPolicy policy) {

        int sum = 0;
        boolean passed = false;
        for (Map.Entry<Integer,Answer> entry : correctAnswers.entrySet()) {
            Answer userAnswer = userAnswers.get(entry.getKey());
            Answer correctAnswer = correctAnswers.get(entry.getKey());

            sum += getScoreForAnswer(policy, userAnswer, correctAnswer);
        }

        if (sum <= 0) {
            sum = 0;
        }

        double percentage = ((double) sum / correctAnswers.size()) * 100;

        if (percentage >= policy.getMinimumPassPercentage()) {
            passed = true;
        }

        return new ExamResult(sum, passed);
    }


    private int getScoreForAnswer(PointsCountingPolicy policy, Answer userAnswer, Answer correctAnswer) {
        if (Objects.isNull(userAnswer)) {
            return policy.getPointsForMissingAnswer();
        } else {
            if (userAnswer.equals(correctAnswer)) {
                return policy.getPointsForCorrectAnswer();
            } else {
                return policy.getPointsForWrongAnswer();
            }
        }
    }
}
