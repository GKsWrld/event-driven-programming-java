# Bug Fix Documentation

## Bug 1: Blocking the EDT
- **Symptom:** UI freezes for 5 seconds when the "Process" button is clicked; window cannot be moved, resized, or clicked.
- **Cause:** `Thread.sleep(5000)` runs directly inside the `ActionListener` on the Event Dispatch Thread (EDT).
- **Fix:** Run the long operation in a background `Thread`, disable the button while processing, and update `statusLabel` and re-enable the button on the EDT using `SwingUtilities.invokeLater()`.
- **Code Change:** Wrapped `Thread.sleep(5000)` in `new Thread(() -> { ... SwingUtilities.invokeLater(() -> { statusLabel.setText("Done!"); processButton.setEnabled(true); }); }).start();`.

## Bug 2: Missing Listener
- **Symptom:** Clicking the "Increment" button does nothing; the count stays at `Count: 0`.
- **Cause:** No `ActionListener` was registered on `incrementButton`.
- **Fix:** Added an `ActionListener` to `incrementButton` that increments `count` and updates `countLabel`.
- **Code Change:** Added `incrementButton.addActionListener(e -> { count++; countLabel.setText("Count: " + count); });`.

## Bug 3: Wrong Thread
- **Symptom:** Erratic Swing behavior, potential visual glitches or race conditions when updating the clock label.
- **Cause:** `timeLabel.setText(...)` was called directly from inside a background `Thread` instead of the EDT.
- **Fix:** Wrapped the `timeLabel.setText(...)` call inside `SwingUtilities.invokeLater()`, made `running` `volatile`, and prevented duplicate clock threads when already running.
- **Code Change:** Computed `String currentTime = "Time: " + new Date();` on the background thread and updated the UI via `SwingUtilities.invokeLater(() -> timeLabel.setText(currentTime));`.

## Bug 4: Memory Leak
- **Symptom:** Memory usage grows over time even after clicking "Remove All" because old `JButton` instances are never garbage-collected.
- **Cause:** `buttonPanel.removeAll()` removed the buttons from the UI container, but `createdButtons` still held strong references to every button ever created.
- **Fix:** Clear the `createdButtons` list whenever all buttons are removed from `buttonPanel`.
- **Code Change:** Added `createdButtons.clear();` inside `removeButton`'s `ActionListener` alongside `buttonPanel.removeAll()`.
