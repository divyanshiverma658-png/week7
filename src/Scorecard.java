/**
 * Problem 2: The Quiz Scorecard
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz (Category C)
 * 
 * Demonstrates Information Hiding & Array Management:
 * - Stores boolean answers (true=correct, false=incorrect) in a private array.
 * - Total number of questions is fixed at construction time.
 * - Records one answer at a time using a counter.
 * - Ignores or rejects attempts to record beyond the fixed capacity.
 * - Exposes only the computed score (total correct), NEVER the internal array.
 */
public class Scorecard {
    // Private array storing individual question results
    private final boolean[] answers;

    // Counter tracking how many answers have been recorded so far
    private int recordedCount;

    /**
     * Constructs a Scorecard with a fixed question capacity.
     * 
     * @param totalQuestions the total number of questions in the quiz
     */
    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            throw new IllegalArgumentException("Total questions cannot be negative.");
        }
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    /**
     * Records the next answer's result into the private array.
     * If the scorecard is already full, additional answers are safely rejected.
     * 
     * @param isCorrect true if the answer was correct, false otherwise
     */
    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < answers.length) {
            answers[recordedCount] = isCorrect;
            recordedCount++;
        } else {
            System.out.println("Warning: Cannot record answer. Quiz capacity of " + answers.length + " questions reached.");
        }
    }

    /**
     * Calculates and returns the total score (count of correct answers).
     * The internal array is never exposed.
     * 
     * @return the number of correct answers recorded
     */
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    /**
     * Returns the total question capacity fixed at creation time.
     * 
     * @return total question count
     */
    public int getTotalQuestions() {
        return answers.length;
    }

    /**
     * Returns how many answers have been recorded so far.
     * 
     * @return count of recorded answers
     */
    public int getRecordedCount() {
        return recordedCount;
    }

    @Override
    public String toString() {
        return "Scorecard{score=" + getScore() + ", recorded=" + recordedCount + "/" + answers.length + "}";
    }
}
