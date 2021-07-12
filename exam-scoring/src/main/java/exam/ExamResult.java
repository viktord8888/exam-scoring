package exam;

public class ExamResult {

    private final int score;
    private final boolean passed;

    ExamResult(int score, boolean passed) {
        this.score = score;
        this.passed = passed;
    }

    public int getScore() {
        return score;
    }

    public boolean getPassed() {
        return passed;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "score=" + score +
                ", passed=" + passed +
                '}';
    }
}
