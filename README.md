# 🧪 String Calculator - TDD Kata (Incubyte Assignment)

This is a simple String Calculator implemented using **Java** and **JUnit 5**, following **Test-Driven Development (TDD)** principles.  
It's part of a coding assessment (TDD Kata) from **Incubyte Careers**, where the idea is to build the logic step by step with clean code, readable tests, and frequent commits to show evolution.

---

## 📌 Problem Statement (in brief)

Implement a method:

```java
int add(String numbers)
```

That:
* Returns `0` for an empty string
* Returns a single number when one is passed
* Returns the sum of comma- or newline-separated numbers
* Supports custom delimiters like `//;\n1;2`
* Throws exception for negative numbers with a clear message
* Ignores numbers greater than 1000
* Supports **multi-character** and **multiple** delimiters like:
    * `//[***]\n1***2***3` → `6`
    * `//[*][%]\n1*2%3` → `6`

## 🧠 Approach

I followed a true TDD cycle:
1. ✅ Wrote the **simplest test** (empty string → 0)
2. ✅ Wrote failing tests before writing any logic
3. 🔁 **Refactored** after each passing test to keep code readable
4. 🚀 Gradually added edge cases (newlines, custom delimiters, negatives, etc.)
5. 🧪 Wrote focused JUnit tests for each case, with readable naming and no duplication

I also handled:
* Multiple delimiter extraction using regex
* Validation logic with a **custom exception class** for negatives
* Tests for all critical paths

## ▶️ How to Run This Project

Using Maven:
1. Clone the repo:

```bash
git clone https://github.com/sm-xd/Incubyte-String-Calculator-Test.git
cd Incubyte-String-Calculator-Test
```

2. Run the tests:

```bash
mvn test
```

You should see something like:

```
Tests run: 18, Failures: 0, Errors: 0, Skipped: 0
```

✅ All tests pass!

## 🧪 Sample Output

Here are some visual test results captured from IntelliJ IDEA:

- Initial setup:

![initial setup test](/screenshots/StartTest.png)

- All tests passing:

![All tests passing](/screenshots/AllTests.png)

- All test with verbose output:

![All tests passing](/screenshots/AllTestVerbose1.png)
![All tests passing](/screenshots/AllTestVerbose2.png)

*(You can find more screenshots in the `/screenshots` folder)*

## 🖥️ Manual Input Mode (Interactive Testing)

You can also test the String Calculator manually via the terminal!

This is useful if:
- You want to try custom inputs quickly
- A recruiter or reviewer wants to interact with the app directly
- You like verifying things on the fly 😄

### 🚀 How to Run the CLI

Make sure the project is built:

```bash
mvn compile
```

Then run the interactive CLI:

```bash
mvn exec:java -Dexec.mainClass="com.sm.Main"
```

> ✅ The CLI uses `Scanner` and prints real-time results.

---

### ✍️ Input Examples

Try inputs like:

```text
👉 Input: 1,2,3
✅ Result: 6

👉 Input: //;\n1;2
✅ Result: 3

👉 Input: //[***]\n1***2***3
✅ Result: 6

👉 Input: //[*][%]\n1*2%3
✅ Result: 6

👉 Input: 2,1001
✅ Result: 2

👉 Input: 1,-2,-3
❌ Error: negative numbers not allowed: -2, -3
```

> 💡 If you're typing input in the terminal, and using custom delimiters:
>
> Use `\\n` instead of pressing Enter.  
> The program will automatically convert `\\n` into a real newline (`\n`) internally.

---

### 🛑 Exit

Type:

```
exit
```

to quit the CLI.

---


## 📁 Project Structure

```
src/
├── main/java/com/sm/
│   ├── Main.java
│   ├── StringCalculator.java
│   └── NegativeNumberException.java
└── test/java/com/sm/
    └── StringCalculatorTest.java
```

## 🚀 Running the Project with Maven

To run this project using `mvn` directly:

### ✅ Prerequisites

- Java JDK 22
- Maven installed (`mvn -v`)
- `JAVA_HOME` environment variable **must be set**

---

### ⚙️ Set Up `JAVA_HOME` (Windows)

1. Find your JDK path, e.g.:

    ```
    C:\Program Files\Java\jdk-22
    ```

2. Open **Environment Variables**:
  - Press `Win + S` → Search for *"Environment Variables"*
  - Click **Environment Variables…**
  - Under **System Variables**, click **New**:
    - **Variable Name**: `JAVA_HOME`
    - **Variable Value**: your JDK path

3. Edit `Path` variable:
  - Add:
    ```
    %JAVA_HOME%\bin
    ```

4. Restart your terminal and verify:

    ```bash
    java -version
    javac -version
    mvn -version
    ```

---

### ▶️ Run the Project

Once `JAVA_HOME` is set:

- To run tests
```bash
mvn test
```
- To run in cli mode
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.sm.Main"
```
---

### 📸 Screenshots

<details>
<summary>📷 JAVA_HOME Setup</summary>

**After setting up environment variable**

![Set JAVA_HOME](/screenshots/setup.png)
</details>

<details>
<summary>📷 mvn test output</summary>

![Maven test output](/screenshots/mvnTest1.png)
![Maven test output](/screenshots/mvnTest2.png)
![Maven test output](/screenshots/mvnTest3.png)
</details>

<details>
<summary>📷 mvn cli mode</summary>

![Maven cli mode output](/screenshots/mvnCli1.png)
![Maven cli mode output](/screenshots/mvnCli2.png)
</details>


## ✅ Final Thoughts

This was a fun exercise in writing maintainable, testable Java code. I really tried to think like a developer who cares about quality and not just correctness. Every test is intentional, and every refactor has a reason. Hope this shows!

Thanks for reviewing 😊 – *Sumit*