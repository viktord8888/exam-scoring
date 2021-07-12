package exam;

public interface PointsCountingPolicy {

    int getPointsForCorrectAnswer();

    int getPointsForWrongAnswer();

    int getPointsForMissingAnswer();

    int getMinimumPassPercentage();
}
