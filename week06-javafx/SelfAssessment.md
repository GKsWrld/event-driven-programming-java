# Week 6: Self-Check Notes & Final Self-Assessment

## Activity 1 & 4 Self-Check Answers

1. **What is the difference between a `Stage` and a `Scene`?**
   `Stage` is the top-level OS window (title bar, minimize/maximize/close controls). `Scene` holds the scene graph of UI `Node`s displayed inside the window; a `Stage` shows one `Scene` at a time and can swap scenes.
2. **What is the name of the JavaFX main thread?**
   `JavaFX Application Thread` — the JavaFX equivalent of Swing's EDT, where all UI creation and updates must run.
3. **What does `@FXML` do?**
   It allows `FXMLLoader` to inject FXML-declared components (matched by `fx:id`) into fields of the controller class and bind event handler methods (referenced via `onAction="#..."`).
4. **Why do we use FXML instead of writing everything in Java?**
   Separation of concerns (MVC): UI markup (`login.fxml`) stays separate from application/controller logic (`LoginController.java`), making layouts editable in Scene Builder and keeping code cleaner.

---

## Final Self-Assessment Checklist

- **Outcome 1 (Basic JavaFX app):** Can create `Stage`, `Scene`, and root `Node`, and run via `mvn clean javafx:run`.
- **Outcome 2 (Programmatic & FXML layouts):** Implemented `VBox`, `HBox`, `GridPane`, `BorderPane`, and Scene Builder-compatible `login.fxml`.
- **Outcome 3 (Architecture & threading):** Understand `JavaFX Application Thread` and why blocking operations must stay off it.
- **Outcome 4 (Functional app):** Wired `login.fxml` to `LoginController` with `onAction="#handleLoginButtonAction"` and built the Capstone `DashboardApp`.
