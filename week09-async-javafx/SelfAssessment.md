# Week 9: Self-Check Notes & Answers

## Activity 1: The Freeze
**Q1: Why did the window freeze for 5 seconds?**
Because `Thread.sleep(5000)` ran directly on the `JavaFX Application Thread`, preventing the UI thread from processing window moves, resizes, repaints, or clicks until the 5 seconds elapsed.

## Activity 2: The Fix (`Task` & `Platform.runLater()`)
**Q1: Why did we use `Platform.runLater()` inside `setOnSucceeded`?**
UI mutations must always execute on the `JavaFX Application Thread` (`Platform.runLater()` dispatches the lambda onto the UI thread; note that `Task.setOnSucceeded` itself is also dispatched on the FX Application Thread by JavaFX, making `Platform.runLater()` safe as well).

## Activity 3: Live Progress
**Q1: What is the difference between `updateProgress()` and `Platform.runLater()`?**
`updateProgress()` is a built-in `Task` method that safely throttles/batches progress updates onto `progressProperty()`, whereas `Platform.runLater()` queues arbitrary UI lambdas directly onto the FX Application Thread.
**Q2: Why did we call `statusLabel.textProperty().unbind()` at the end?**
Because `statusLabel.textProperty()` was bound to `downloadTask.messageProperty()`. Setting text manually while bound throws a `RuntimeException`, so `.unbind()` must be called first.

## Activity 4: The `Service` Class
**Q1: What is the main difference between `Task` and `Service`?**
A `Task` is single-use (it cannot be restarted once run), whereas a `Service` acts as a reusable factory/manager around `Task` that can be started, cancelled, and `restart()`ed multiple times.
**Q2: How do you check inside `call()` if the user clicked "Cancel"?**
Check `isCancelled()` inside the work loop and exit early when `true`.
