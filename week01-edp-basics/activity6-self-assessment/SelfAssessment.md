# Week 1 Final Self-Assessment & Summary

## Step 1: Self-Assessment Answers

### Learning Outcome 1: Define EDP Components
1. **What is an event? Give two examples.**
   An event is an object representing a state change or user/system occurrence that the program can react to. Examples: clicking a `JButton` (`ActionEvent`) and pressing a keyboard key (`KeyEvent`).
2. **What is an event source? Give two examples.**
   An event source is the component or object that generates and fires an event. Examples: a `JButton` ("Submit") and a `javax.swing.Timer`.
3. **What is an event listener? Give two examples.**
   An event listener is an object (implementing a listener interface) registered with an event source to wait for specific events. Examples: `ActionListener` and `KeyListener`.
4. **What is an event handler? Give two examples.**
   An event handler is the method or code block inside a listener that executes in response to an event. Examples: `actionPerformed(ActionEvent e)` saving a form, and `keyPressed(KeyEvent e)` moving a game character.
5. **Diagram showing how these four components relate:**
   ```text
   [Event Source (e.g., JButton)]
            │ fires
            ▼
   [Event Object (e.g., ActionEvent)]
            │ dispatched to registered
            ▼
   [Event Listener (e.g., ActionListener)]
            │ invokes
            ▼
   [Event Handler (actionPerformed / lambda)]
   ```

### Learning Outcome 2: Compare Paradigms
6. **How does procedural programming differ from event-driven programming?**
   Procedural programming executes steps in a fixed, predetermined sequence controlled by the program, whereas event-driven programming waits in an event loop and executes handlers in whatever order the user or external sources trigger events.
7. **What is the main advantage of event-driven programming for GUIs?**
   Users can interact with multiple controls in any order, recover easily from mistakes, and get immediate visual feedback without restarting the program.
8. **In which scenario would you choose procedural programming over event-driven?**
   Batch scripts, one-off CLI data-processing pipelines, or mathematical startup routines where inputs and steps follow a strict linear order with no interactive UI.

### Learning Outcome 3: Event Loop and Queue
9. **What is the event loop? What does it do?**
   The event loop is a continuous runtime loop that polls the event queue for incoming events and dispatches each one to its registered listener/handler.
10. **What is the event queue? How does it work?**
    The event queue is a FIFO buffer holding pending events created by user actions, timers, or system updates until the event loop is ready to process them one at a time.
11. **Why should the event loop never be blocked?**
    Because events are processed sequentially on the event loop thread; blocking it freezes repainting, clicking, typing, and window resizing until the blocking work completes.
12. **What is the EDT in Java Swing?**
    The **Event Dispatch Thread (EDT)** (`AWT-EventQueue-0`) is the dedicated single thread that runs Swing's event loop and handles all GUI creation, painting, and event dispatching.

### Learning Outcome 4: Real-World Examples
13. **List five real-world event-driven systems:**
    ATM machine, microwave oven, elevator controller, smartphone touchscreen OS, and online shopping web interface.
14. **For one system, identify all four EDP components (ATM Machine):**
    - **Event Source:** Keypad button
    - **Event:** Button pressed
    - **Event Listener:** ATM input controller listening for keypad signals
    - **Event Handler:** Append digit to PIN buffer and update masked `*` display
15. **Why are most modern applications event-driven?**
    Modern apps run on graphical, networked, and sensor-rich devices where inputs (clicks, touches, messages, timers) arrive asynchronously and unpredictably from users and external services.

---

## Step 2: Self-Score
**Score:** 15 / 15 — Excellent! All Week 1 concepts mastered.

---

## Step 3: Week 1 One-Page Summary

### Key Definitions
- **Event:** Notification object describing something that happened (click, key press, timer tick).
- **Event Source:** Component or sensor that creates and fires the event.
- **Event Listener:** Interface/object subscribed to receive notifications from a source.
- **Event Handler:** Code executed when the listener receives the event.
- **Event Queue & Event Loop:** FIFO queue of pending events processed one-by-one by the EDT.

### Important Architecture Flow
```text
User / Sensor -> Event Source -> Event Object -> Event Queue -> Event Loop (EDT) -> Listener -> Handler -> UI Update
```

### Helpful Code Patterns
```java
// 1. Always launch Swing UI on the EDT
SwingUtilities.invokeLater(() -> new MyFrame().setVisible(true));

// 2. Keep long tasks off the EDT
button.addActionListener(e -> new Thread(() -> {
    doSlowWork();
    SwingUtilities.invokeLater(() -> statusLabel.setText("Done!"));
}).start());
```

### Open Questions / Next Steps
- How to decouple models from multiple UI listeners cleanly without Swing-specific dependencies (covered in Week 2: The Observer Pattern).
