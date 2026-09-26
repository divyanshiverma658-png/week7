import java.util.Objects;

/**
 * Problem 3: The Nickname Tag
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz (Category C)
 * 
 * Demonstrates Immutability & String Processing:
 * - Accepts a full name in constructor and splits into first name and last name.
 * - Stores parts in private final fields to guarantee immutability.
 * - Once instantiated, state cannot be changed (no setters).
 * - Builds and returns a nickname in format: "<FirstName> <LastInitial>."
 */
public final class NameTag {
    // Immutable final fields
    private final String firstName;
    private final String lastName;

    /**
     * Constructs an immutable NameTag from a full name.
     * Assumes the full name consists of a first name and a last name separated by a space.
     * 
     * @param fullName the full name string (e.g., "Maria Gomez")
     */
    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }

        String trimmed = fullName.trim();
        int spaceIndex = trimmed.indexOf(' ');

        if (spaceIndex != -1) {
            this.firstName = trimmed.substring(0, spaceIndex);
            this.lastName = trimmed.substring(spaceIndex + 1).trim();
        } else {
            // Fallback if only single name provided
            this.firstName = trimmed;
            this.lastName = "";
        }
    }

    /**
     * Constructs a NameTag directly with first name and last name.
     * 
     * @param firstName the first name
     * @param lastName the last name
     */
    public NameTag(String firstName, String lastName) {
        this.firstName = (firstName != null) ? firstName.trim() : "";
        this.lastName = (lastName != null) ? lastName.trim() : "";
    }

    /**
     * Generates and returns the nickname consisting of the first name
     * followed by the last name's initial and a period (e.g., "Maria G.").
     * 
     * @return the formatted nickname
     */
    public String getNickname() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName.charAt(0) + ".";
    }

    /**
     * Returns the stored first name.
     * 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the stored last name.
     * 
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameTag nameTag = (NameTag) o;
        return Objects.equals(firstName, nameTag.firstName) &&
               Objects.equals(lastName, nameTag.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "NameTag{nickname='" + getNickname() + "'}";
    }
}
