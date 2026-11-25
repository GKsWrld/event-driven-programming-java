# Event-Driven Programming in Java

Coursework and self-paced practical activities for Event-Driven Programming (Weeks 1–7), built with Java, Swing, and JavaFX in VS Code.

## Repository Structure

- `week01-edp-basics/` — Fundamental EDP components, event loop simulation, procedural vs. event-driven calculators, debugging EDT/listener/memory bugs, Smart Home Controller prototype, and self-assessment.
- `week02-observer-pattern/` — Custom Observer pattern (Weather Station), legacy `java.util.Observer`/`Observable` analysis, refactoring tightly-coupled code, `PropertyChangeListener` comparison, and self-assessment.
- `week03-swing-gui/` — Swing `JFrame`, basic components showcase, layout managers (`FlowLayout`, `BorderLayout`, `GridLayout`, combined app shell), EDT rule demos, and Riara University Student Portal UI mockup.
- `week04-event-handling/` — `ActionListener` basics, listener styles and `getSource()`, `ItemListener` & `DocumentListener` demos, Counter app with keyboard shortcuts, interactive Registration Form, and Mouse/Key listeners.
- `week05-advanced-swing/` — `JList` custom renderer, `JTable` with custom GPA rendering, `JTree` + `JTabbedPane` explorer, `MiniEditor` with menus/toolbar/`JFileChooser`, and Capstone `FileManager`.
- `week06-javafx/` — Maven JavaFX project: programmatic `App`, `LayoutDemo` (`HBox`, `VBox`, `GridPane`, `BorderPane`), FXML `login.fxml` + `LoginController` + `FXMLApp`, and Capstone `DashboardApp`.
- `week07-javafx-events/` — Maven JavaFX project: `EventPropagationDemo` (filters vs. handlers), `MouseKeyDemo`, `DragDropDemo`, and custom `LoginSuccessEvent` + `CustomEventDemo`.

## Running the Activities (Requires JDK 17+)

### Swing / Plain Java (Weeks 1–5)
Navigate into an activity folder and compile/run with `javac` and `java`, for example:

```powershell
cd week05-advanced-swing\activity5-capstone-file-manager
javac FileManager.java
java FileManager
```

### JavaFX with Maven (Weeks 6–7, Requires Maven + JDK 17+)
Navigate into `week06-javafx` or `week07-javafx-events` and run with `mvn javafx:run`:

```powershell
cd week06-javafx
mvn clean javafx:run
mvn clean javafx:run -Djavafx.mainClass=com.example.DashboardApp
```
