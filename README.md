# STEP SEM-3 · CodInClub | Powered by BridgeLabz (Category C)

This repository contains clean, modular, and thoroughly tested Java implementations for the **STEP SEM-3 Category C** assignment.

---

## 📌 Table of Contents
1. [Overview](#overview)
2. [Problems & Implementations](#problems--implementations)
   - [Problem 1: The Piggy Bank (Encapsulation)](#problem-1-the-piggy-bank)
   - [Problem 2: The Quiz Scorecard (Information Hiding)](#problem-2-the-quiz-scorecard)
   - [Problem 3: The Nickname Tag (Immutability)](#problem-3-the-nickname-tag)
3. [Project Structure](#project-structure)
4. [How to Compile and Run](#how-to-compile-and-run)
5. [Automated Test Suite](#automated-test-suite)

---

## 📖 Overview

The assignment focuses on core Object-Oriented Programming (OOP) concepts in Java:
- **Encapsulation & Data Hiding:** Ensuring internal state is shielded from direct external modification.
- **Information Hiding & Abstraction:** Concealing internal data structures (arrays) and exposing only calculated results.
- **Immutability:** Designing objects whose state cannot be changed once instantiated.

---

## 💡 Problems & Implementations

### Problem 1: The Piggy Bank
- **Scenario:** A savings app tracks how much money a kid has put away.
- **Key Concepts:** Encapsulation, State Validation, Immutability of Identifier.
- **Requirements:**
  - The `savings` amount is `private` and starts at `0`.
  - Money can only be changed via `deposit(amount)` and `withdraw(amount)`.
  - There is no setter method anywhere to set `savings` directly.
  - A withdrawal larger than the current savings is rejected, leaving the balance unchanged.
  - The `id` is marked `final` and locked the moment the object is created.
  - Includes `getSavings()` to check the balance.

**Sample Walkthrough:**
```java
PiggyBank pb = new PiggyBank("PB-1");
pb.deposit(100); // savings = 100
pb.withdraw(30);  // savings = 70
pb.withdraw(500); // rejected: insufficient savings, savings remains 70
System.out.println(pb.getSavings()); // 70
```

---

### Problem 2: The Quiz Scorecard
- **Scenario:** A quiz app records whether each answer you gave was right or wrong.
- **Key Concepts:** Information Hiding, Array Encapsulation, Capacity Constraints.
- **Requirements:**
  - Stores answer results (`true` for correct, `false` for incorrect) in a `private boolean[]` array.
  - The total number of questions is fixed in the constructor (`new Scorecard(totalQuestions)`).
  - Answers are recorded one at a time via `recordAnswer(boolean isCorrect)`.
  - Exposes **only** the total score (count of correct answers) via `getScore()`.
  - **Never** exposes the internal array in any form.
  - Attempts to record more answers than the fixed question count are safely ignored or rejected.

**Sample Walkthrough:**
```java
Scorecard sc = new Scorecard(4);
sc.recordAnswer(true);
sc.recordAnswer(true);
sc.recordAnswer(false);
sc.recordAnswer(true);
System.out.println(sc.getScore()); // 3
```

---

### Problem 3: The Nickname Tag
- **Scenario:** A chat app shows a friendly short nickname instead of your full name.
- **Key Concepts:** Immutability, String Processing.
- **Requirements:**
  - Constructor accepts a single full name string (e.g. `"Maria Gomez"`).
  - Splits the input into first name and last name.
  - Stored fields are declared `final` (no modification allowed after creation).
  - `getNickname()` returns `"<FirstName> <LastInitial>."` (e.g. `"Maria G."`).
  - Two `NameTag` objects with the same full name evaluate to equal values (`equals()`), while remaining separate heap instances.

**Sample Walkthrough:**
```java
NameTag tag = new NameTag("Maria Gomez");
System.out.println(tag.getNickname()); // "Maria G."
```

---

## 📂 Project Structure

```text
step-sem3-category-c/
├── src/
│   ├── PiggyBank.java        # Problem 1: Piggy Bank class
│   ├── Scorecard.java        # Problem 2: Scorecard class
│   ├── NameTag.java          # Problem 3: NameTag class
│   └── Main.java             # Interactive demonstration runner
├── tests/
│   └── AssignmentTest.java   # Automated unit test suite with 22 assertions
├── .gitignore
└── README.md
```

---

## 🚀 How to Compile and Run

### 1. Compile the Source Code
```bash
javac -d out src/*.java tests/*.java
```

### 2. Run the Main Demonstration
```bash
java -cp out Main
```

### 3. Run the Automated Test Suite
```bash
java -cp out AssignmentTest
```

---

## ✅ Automated Test Suite

The test suite in [`tests/AssignmentTest.java`](tests/AssignmentTest.java) verifies 22 test cases covering:
- Correct initial values and final field assignments
- Valid deposits and balance updates
- Negative/zero deposit rejection
- Valid withdrawals
- Overdrawing rejection and state preservation
- Negative withdrawal rejection
- Scorecard answer tracking and score computation
- Scorecard capacity limits and overflow rejection
- NameTag nickname generation (`"Maria Gomez"` -> `"Maria G."`)
- NameTag object value equality vs instance reference identity
