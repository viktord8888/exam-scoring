package exam;

public class MinusPointsCountingPolicy implements PointsCountingPolicy {

    @Override
    public int getPointsForCorrectAnswer() {
        return 1;
    }

    @Override
    public int getPointsForWrongAnswer() {
        return -1;
    }

    @Override
    public int getPointsForMissingAnswer() {
        return 0;
    }

    @Override
    public int getMinimumPassPercentage() {
        return 50;
    }

}
