# Strategy Calculator — Option B

Daniyal Akylbek | SE-2530 | Java 17

A small console demonstration of addition, subtraction and multiplication using
Strategy. The same Calculator switches operations at runtime. No external libraries,
Maven, Gradle or interactive input are required. Main is the client; it explicitly
chooses the strategies. Output labels belong to the client, not the Context.

## Structure

- `src/calculator/`: interface, three strategies, Calculator and Main.
- `test/calculator/CalculatorTest.java`: executable checks, no test framework required.
- `examples/calculator/`: optional division strategy and a separate extension client.
- `REPORT.md`: six-section Moodle reflection with UML and annotated excerpts.

## Build and run (Windows PowerShell, CMD, Linux or macOS)

Install a JDK 17 or newer (a JRE alone cannot compile). Open a terminal in this
project folder. Confirm both `java -version` and `javac -version` work.

```sh
mkdir out
javac --release 17 -d out src/calculator/*.java
java -cp out calculator.Main
```

If `out` already exists, skip the mkdir command. In IntelliJ, open the folder,
select JDK 17+, mark `src` as Sources Root, and run `calculator.Main`.

Expected output:

```text
Same Calculator object, different strategies:
12 + 4 = 16.0
12 - 4 = 8.0
12 * 4 = 48.0
```

Run checks:

```sh
javac --release 17 -cp out -d out test/calculator/*.java
java -cp out calculator.CalculatorTest
```

## Add a new strategy without editing existing classes

1. Add a class implementing OperationStrategy.
2. Implement `execute(double firstNumber, double secondNumber)`.
3. Inject its instance into Calculator from a new client, or configure an existing client.

The supplied extension demonstrates this using **two new files only**; no original
class changes. Compile it after compiling the main source:

```sh
javac --release 17 -cp out -d out examples/calculator/*.java
java -cp out calculator.ExtensionDemo
```

It prints `12 / 4 = 3.0`, switches back to addition (`16.0`), and confirms division
by zero is rejected. The division guard validates an operand; it does not choose a
strategy. Calculator has no if/switch, instanceof or concrete strategy reference.
Java double arithmetic has rounding limitations; this is an educational calculator,
not a decimal financial calculator.