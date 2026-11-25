# Event-Driven Programming in Java

Coursework and self-paced practical activities for Event-Driven Programming (Weeks 1–4), built with Java and Swing in VS Code.

## Repository Structure

- `week01-edp-basics/` — Fundamental EDP components, event loop simulation, procedural vs. event-driven calculators, debugging EDT/listener/memory bugs, Smart Home Controller prototype, and self-assessment.
- `week02-observer-pattern/` — Custom Observer pattern (Weather Station), legacy `java.util.Observer`/`Observable` analysis, refactoring tightly-coupled code, `PropertyChangeListener` comparison, and self-assessment.
- `week03-swing-gui/` — Swing `JFrame`, basic components showcase, layout managers (`FlowLayout`, `BorderLayout`, `GridLayout`, combined app shell), EDT rule demos, and University Student Portal UI mockup.
- `week04-event-handling/` — `ActionListener` basics, listener styles and `getSource()`, `ItemListener` & `DocumentListener` demos, Counter app with keyboard shortcuts, interactive Registration Form, and Mouse/Key listeners.

## Running Any Activity (Requires JDK 17+)

Navigate into the specific activity folder and compile/run with `javac` and `java`, for example:

```powershell
cd week01-edp-basics\activity3-procedural-vs-edp\eventdriven
javac EventDrivenCalculator.java
java EventDrivenCalculator
```
