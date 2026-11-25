# Activity 1: Self-Check Notes

1. **What is the difference between `JFrame` and the content pane?**
   `JFrame` is the top-level window (title bar, minimize/maximize/close controls, border). The content pane is the container inside `JFrame` where components are added (`frame.add(...)` delegates to the content pane in modern Swing).

2. **What does `EXIT_ON_CLOSE` do?**
   It terminates the JVM cleanly when the user closes the window. Alternatives are `DO_NOTHING_ON_CLOSE`, `HIDE_ON_CLOSE`, and `DISPOSE_ON_CLOSE`.

3. **Why did we wrap the code in `SwingUtilities.invokeLater()`?**
   Swing components are not thread-safe; `invokeLater()` schedules GUI creation and updates on the Event Dispatch Thread (`AWT-EventQueue-0`).
