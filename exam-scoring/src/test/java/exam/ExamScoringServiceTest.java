package exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ExamScoringServiceTest {

    @Test
    public void testStandardPolicy() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.A,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                3, Answer.B,
                4, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new StandardPointsCountingPolicy());

        System.out.println(result.toString());
    }

    @Test
    public void testGetScore() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.A,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                3, Answer.B,
                4, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new StandardPointsCountingPolicy());

        Assertions.assertEquals(2, result.getScore());
    }

    @Test
    public void testResultPassed() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.B,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                3, Answer.B,
                4, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new StandardPointsCountingPolicy());

        Assertions.assertTrue(result.getPassed());
    }

    @Test
    public void testResultNotPassed() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.A,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                3, Answer.B,
                4, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new StandardPointsCountingPolicy());

        Assertions.assertFalse(result.getPassed());
    }

    @Test
    public void testMissingAnswer() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.A,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                4, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new StandardPointsCountingPolicy());

        Assertions.assertEquals(1, result.getScore());
    }

    @Test
    public void testMinusPointsCountingPolicy() {
        Map<Integer, Answer> correctAnswers = Map.of(
                1, Answer.A,
                2, Answer.C,
                3, Answer.B,
                4, Answer.A,
                5, Answer.D
        );

        Map<Integer, Answer> userAnswers = Map.of(
                1, Answer.B,
                2, Answer.A,
                3, Answer.C,
                5, Answer.D
        );

        ExamResult result = new ExamScoringService().countPoints(userAnswers, correctAnswers, new MinusPointsCountingPolicy());

        Assertions.assertEquals(0, result.getScore());
    }
}