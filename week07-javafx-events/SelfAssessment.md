# Week 7: Self-Check Notes & Final Self-Assessment

## Activity 1: Event Filters vs. Event Handlers
1. **Which phase of event propagation does an Event Filter belong to?**
   The **Capturing Phase** (travels top-down from `Stage`/`Scene`/root node toward the target node).
2. **What does `e.consume()` do?**
   It stops the event from propagating any further. When called inside an event filter, the event never reaches the target node or bubbling handlers.
3. **How do you register an Event Handler (Bubbling phase)?**
   Using `node.addEventHandler(EventType, handler)` or convenience setters like `setOnMouseClicked(...)` and `setOnAction(...)`.

## Activity 2: Mouse and Key Events
1. **Which method tracks mouse movement without clicking?**
   `setOnMouseMoved(...)`.
2. **Why might a `KeyEvent` not fire when you press a key?**
   Because the target node does not have keyboard **focus**. Ensure the node is focus-traversable (`setFocusTraversable(true)`) and request focus (`requestFocus()`).
3. **How do you check which physical key was pressed?**
   Using `e.getCode()` (e.g., `e.getCode() == KeyCode.UP`).

## Activity 3: Drag and Drop
1. **Which handler initiates a drag operation on the source?**
   `setOnDragDetected(...)` calling `startDragAndDrop(TransferMode.MOVE)`.
2. **What does `event.acceptTransferModes(TransferMode.MOVE)` do in `setOnDragOver`?**
   It signals to JavaFX that the target node accepts the dragged payload; without it, drops are rejected.
3. **How do you extract dragged data on drop?**
   Call `event.getDragboard()` inside `setOnDragDropped` and inspect/read it (e.g., `db.hasString()` / `db.getString()`).

## Activity 4: Custom Events
1. **Why use a Custom Event instead of calling a method directly?**
   For **loose coupling**: the event producer fires the event without needing references to downstream listeners.
2. **Which class must a custom JavaFX event extend?**
   `javafx.event.Event`.
3. **How do you define the type of a custom event?**
   Declare a `public static final EventType<MyEvent>` (e.g., `new EventType<>(Event.ANY, "LOGIN_SUCCESS")`).

---

## Final Self-Assessment Checklist
- **Outcome 1:** Handled mouse movement, keyboard navigation (`KeyCode`), and action events in `MouseKeyDemo`.
- **Outcome 2:** Demonstrated capturing filters vs. bubbling handlers in `EventPropagationDemo`.
- **Outcome 3:** Implemented drag-and-drop with `Dragboard` and `ClipboardContent` in `DragDropDemo`.
- **Outcome 4:** Created `LoginSuccessEvent` extending `Event`, fired via `.fireEvent()`, and consumed via `.addEventHandler()`.
