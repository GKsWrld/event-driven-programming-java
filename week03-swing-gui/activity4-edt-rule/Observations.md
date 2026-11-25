# Activity 4: EDT Rule — Observations & Self-Check

## Observations

- **`FreezeDemo.java` (BAD Practice):**
  Clicking **"Freeze the UI"** invokes `Thread.sleep(5000)` directly inside the `ActionListener` on the Event Dispatch Thread (`AWT-EventQueue-0`). Because the EDT cannot process any other queued events during those 5 seconds, the window cannot be moved, resized, repainted, or clicked, and `"Working..."` does not even repaint properly until after the sleep finishes and `"Done!"` appears.

- **`FixedDemo.java` (GOOD Practice):**
  Clicking **"Do Long Operation"** immediately sets `"Working..."`, disables the button on the EDT, and spawns a separate background `Thread` to run `Thread.sleep(5000)`. While the background thread sleeps, the EDT remains completely free so the user can move and resize the window smoothly. Once finished, `SwingUtilities.invokeLater()` safely updates the label back to `"Done!"` and re-enables the button on the EDT.

---

## Self-Check Answers

1. **Why does `Thread.sleep()` on the EDT freeze the UI?**
   The EDT executes Swing's event loop, handling every paint, click, resize, and key event sequentially. Sleeping on the EDT stalls the entire event loop so no UI events can be processed until the sleep ends.

2. **What is the safe way to update a label from a background thread?**
   Schedule the update on the EDT with `SwingUtilities.invokeLater(() -> label.setText("..."))`.

3. **What happens if you violate the EDT rule?**
   Blocking the EDT freezes the application; mutating Swing components from a non-EDT thread causes race conditions, visual glitches, stale renders, or intermittent exceptions because Swing is not thread-safe.
