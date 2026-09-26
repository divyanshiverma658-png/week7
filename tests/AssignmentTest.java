/**
 * Automated Test Suite for CodInClub STEP SEM-3 (Category C)
 * Runs independent assertions for every single requirement.
 */
public class AssignmentTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        System.out.println("Running Assignment Test Suite...\n");

        testProblem1PiggyBank();
        testProblem2Scorecard();
        testProblem3NameTag();

        System.out.println("\n-------------------------------------------");
        System.out.println("Test Results: " + testsPassed + "/" + totalTests + " tests passed.");
        if (testsPassed == totalTests) {
            System.out.println(">>> ALL TESTS PASSED SUCCESSFULLY! <<<");
        } else {
            System.err.println(">>> SOME TESTS FAILED! <<<");
            System.exit(1);
        }
    }

    private static void assertEquals(Object expected, Object actual, String testName) {
        totalTests++;
        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            System.out.println("[PASS] " + testName);
            testsPassed++;
        } else {
            System.err.println("[FAIL] " + testName + " | Expected: " + expected + ", Got: " + actual);
        }
    }

    private static void assertTrue(boolean condition, String testName) {
        totalTests++;
        if (condition) {
            System.out.println("[PASS] " + testName);
            testsPassed++;
        } else {
            System.err.println("[FAIL] " + testName + " | Expected: true, Got: false");
        }
    }

    private static void testProblem1PiggyBank() {
        System.out.println("Testing Problem 1: PiggyBank");

        // 1. Initial state
        PiggyBank pb = new PiggyBank("PB-1");
        assertEquals("PB-1", pb.getId(), "PiggyBank ID is fixed to PB-1");
        assertEquals(0, pb.getSavings(), "New PiggyBank starts at 0 savings");

        // 2. Deposit adds exact amount
        pb.deposit(100);
        assertEquals(100, pb.getSavings(), "Depositing 100 sets savings to 100");

        // 3. Withdraw valid amount
        pb.withdraw(30);
        assertEquals(70, pb.getSavings(), "Withdrawing 30 leaves savings at 70");

        // 4. Overdrawing is rejected
        pb.withdraw(500);
        assertEquals(70, pb.getSavings(), "Withdrawing 500 is rejected, savings stays 70");

        // 5. Negative/zero deposit is rejected
        pb.deposit(-20);
        assertEquals(70, pb.getSavings(), "Negative deposit is rejected, savings stays 70");
        pb.deposit(0);
        assertEquals(70, pb.getSavings(), "Zero deposit is rejected, savings stays 70");

        // 6. Negative/zero withdrawal is rejected
        pb.withdraw(-10);
        assertEquals(70, pb.getSavings(), "Negative withdrawal is rejected, savings stays 70");

        // 7. Withdraw exact amount down to zero
        pb.withdraw(70);
        assertEquals(0, pb.getSavings(), "Withdrawing exact balance sets savings to 0");
    }

    private static void testProblem2Scorecard() {
        System.out.println("\nTesting Problem 2: Scorecard");

        // 1. Initial creation
        Scorecard sc = new Scorecard(4);
        assertEquals(4, sc.getTotalQuestions(), "Total questions fixed at 4");
        assertEquals(0, sc.getScore(), "Initial score is 0");

        // 2. Record answers: true, true, false, true -> score = 3
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        assertEquals(3, sc.getScore(), "Recording true, true, false, true gives score of 3");

        // 3. Overflow protection (cannot record more than capacity)
        sc.recordAnswer(true);
        assertEquals(4, sc.getTotalQuestions(), "Question capacity remains 4");
        assertEquals(3, sc.getScore(), "Overflow answer does not corrupt score");

        // 4. Scorecard with all correct answers
        Scorecard scAll = new Scorecard(3);
        scAll.recordAnswer(true);
        scAll.recordAnswer(true);
        scAll.recordAnswer(true);
        assertEquals(3, scAll.getScore(), "All correct answers yields perfect score");

        // 5. Scorecard with all incorrect answers
        Scorecard scNone = new Scorecard(3);
        scNone.recordAnswer(false);
        scNone.recordAnswer(false);
        scNone.recordAnswer(false);
        assertEquals(0, scNone.getScore(), "All wrong answers yields score 0");
    }

    private static void testProblem3NameTag() {
        System.out.println("\nTesting Problem 3: NameTag");

        // 1. Sample case
        NameTag tag1 = new NameTag("Maria Gomez");
        assertEquals("Maria G.", tag1.getNickname(), "NameTag 'Maria Gomez' yields 'Maria G.'");
        assertEquals("Maria", tag1.getFirstName(), "First name is Maria");
        assertEquals("Gomez", tag1.getLastName(), "Last name is Gomez");

        // 2. Other names
        NameTag tag2 = new NameTag("John Doe");
        assertEquals("John D.", tag2.getNickname(), "NameTag 'John Doe' yields 'John D.'");

        // 3. Object equality and distinct references
        NameTag tag3 = new NameTag("Maria Gomez");
        assertTrue(tag1.equals(tag3), "Two NameTags with same name are equal by value");
        assertTrue(tag1 != tag3, "Two NameTags remain separate object instances");
    }
}
