/**
 * Problem 1: The Piggy Bank
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz (Category C)
 * 
 * Demonstrates Encapsulation & Data Hiding:
 * - The savings field is private and cannot be set directly.
 * - Modifications happen strictly via deposit and withdraw methods.
 * - Withdrawals exceeding current savings are rejected.
 * - The ID is marked final and fixed upon creation.
 */
public class PiggyBank {
    // Unique identifier fixed upon creation
    private final String id;

    // Savings amount strictly encapsulated (private)
    private int savings;

    /**
     * Constructs a new PiggyBank with a fixed ID and 0 initial savings.
     * 
     * @param id the unique identifier for this piggy bank
     */
    public PiggyBank(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("PiggyBank ID cannot be null or empty.");
        }
        this.id = id;
        this.savings = 0; // Starts at 0 savings
    }

    /**
     * Deposits money into the piggy bank.
     * 
     * @param amount the amount to add (must be positive)
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("[" + id + "] Deposit rejected: Amount must be positive.");
            return;
        }
        this.savings += amount;
    }

    /**
     * Overloaded deposit to handle double values if passed.
     */
    public void deposit(double amount) {
        deposit((int) amount);
    }

    /**
     * Withdraws money from the piggy bank.
     * If the withdrawal amount exceeds the current savings, it is rejected
     * and the savings remain unchanged.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("[" + id + "] Withdrawal rejected: Amount must be positive.");
            return;
        }
        if (amount > this.savings) {
            System.out.println("[" + id + "] Withdrawal of " + amount + " rejected: Insufficient savings (Current: " + this.savings + ").");
            return;
        }
        this.savings -= amount;
    }

    /**
     * Overloaded withdraw to handle double values if passed.
     */
    public void withdraw(double amount) {
        withdraw((int) amount);
    }

    /**
     * Returns the current savings amount.
     * Note: There is NO setter method anywhere in the class.
     * 
     * @return current savings
     */
    public int getSavings() {
        return this.savings;
    }

    /**
     * Convenience alias for getSavings().
     * 
     * @return current savings balance
     */
    public int getBalance() {
        return this.savings;
    }

    /**
     * Returns the fixed ID of the piggy bank.
     * 
     * @return the piggy bank ID
     */
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PiggyBank{id='" + id + "', savings=" + savings + "}";
    }
}
