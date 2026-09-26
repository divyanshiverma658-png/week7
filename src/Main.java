/**
 * Main Demonstration Runner for CodInClub STEP SEM-3 (Category C)
 * Covers:
 *  - Problem 1: The Piggy Bank (Encapsulation)
 *  - Problem 2: The Quiz Scorecard (Information Hiding)
 *  - Problem 3: The Nickname Tag (Immutability)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" STEP SEM-3 · CodInClub | Powered by BridgeLabz ");
        System.out.println(" Category C Assignment Demonstrations            ");
        System.out.println("=================================================\n");

        runProblem1Demo();
        System.out.println();
        runProblem2Demo();
        System.out.println();
        runProblem3Demo();
    }

    private static void runProblem1Demo() {
        System.out.println("--- Problem 1: The Piggy Bank ---");
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Created PiggyBank with ID: " + pb.getId());
        System.out.println("Initial savings: " + pb.getSavings());

        System.out.println("\nAction: pb.deposit(100)");
        pb.deposit(100);
        System.out.println("Current savings: " + pb.getSavings());

        System.out.println("\nAction: pb.withdraw(30)");
        pb.withdraw(30);
        System.out.println("Current savings: " + pb.getSavings());

        System.out.println("\nAction: pb.withdraw(500)");
        pb.withdraw(500);
        System.out.println("Savings after failed withdrawal: " + pb.getSavings());

        System.out.println("\nVerification: Final savings = " + pb.getSavings() + " (Expected: 70)");
    }

    private static void runProblem2Demo() {
        System.out.println("--- Problem 2: The Quiz Scorecard ---");
        Scorecard sc = new Scorecard(4);
        System.out.println("Created Scorecard for " + sc.getTotalQuestions() + " questions.");

        System.out.println("Recording: true (Correct)");
        sc.recordAnswer(true);

        System.out.println("Recording: true (Correct)");
        sc.recordAnswer(true);

        System.out.println("Recording: false (Wrong)");
        sc.recordAnswer(false);

        System.out.println("Recording: true (Correct)");
        sc.recordAnswer(true);

        System.out.println("\nCalculating total score via getScore(): " + sc.getScore());
        System.out.println("Verification: Score = " + sc.getScore() + " (Expected: 3)");

        System.out.println("\nAttempting to record a 5th answer (beyond limit of 4):");
        sc.recordAnswer(true);
        System.out.println("Score remains: " + sc.getScore());
    }

    private static void runProblem3Demo() {
        System.out.println("--- Problem 3: The Nickname Tag ---");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Full Name provided: Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());
        System.out.println("Verification: Nickname = \"" + tag.getNickname() + "\" (Expected: \"Maria G.\")");

        // Test equality & immutability
        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println("\nComparing two NameTag objects with identical names:");
        System.out.println("tag.equals(tag2) : " + tag.equals(tag2) + " (Equal contents)");
        System.out.println("tag == tag2       : " + (tag == tag2) + " (Distinct object references)");

        NameTag tag3 = new NameTag("Alan Turing");
        System.out.println("tag3.getNickname() -> " + tag3.getNickname());
    }
}
