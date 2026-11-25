# Limitations of `java.util.Observer` and `java.util.Observable`

## Limitation 1: Single Inheritance
**Explain:** Why is it a problem that `Observable` is a CLASS, not an INTERFACE?

**Answer:** Java only supports single class inheritance. Because a subject must `extends Observable`, it cannot extend any other domain or framework base class (such as `JPanel`, `Thread`, or an application model base class), severely limiting design flexibility and violating composition over inheritance.

---

## Limitation 2: Cannot Change the Notification Order
**Explain:** In what order are observers notified? Can you control this?

**Answer:** `Observable` stores observers internally and notifies them in an unspecified order (historically reverse registration order in the JDK implementation, though not guaranteed by contract). Developers cannot customize, prioritize, or override notification ordering because `notifyObservers()` and the internal collection are not designed for subclass extension (`setChanged()` is `protected`, and the observer vector is `private`).

---

## Limitation 3: `setChanged()` is Confusing
**Explain:** Why must you call `setChanged()` before `notifyObservers()`?

**Answer:** `Observable` requires `setChanged()` to flip an internal `changed` boolean flag before `notifyObservers()` will actually notify listeners. While intended to allow throttling or filtering minor changes, in practice it is easy to forget—causing `notifyObservers()` to fail silently without notifying any observers—and since `setChanged()` is `protected`, external helper classes cannot trigger notifications on an `Observable` via composition.

---

## Limitation 4: Pull Model by Default
**Explain:** How does the observer get the data? Is this efficient?

**Answer:** When `notifyObservers()` is called without arguments, observers receive `(Observable o, Object arg)` where `arg` is `null` and must cast `o` to the concrete class and call getter methods (`getTemperature()`, `getHumidity()`). Even when passing `arg`, it is typed only as `Object` (no generics/type safety), requiring unsafe casts and extra method calls.

---

## Limitation 5: Deprecated Since Java 9
**Explain:** Why did Java deprecate these classes?

**Answer:** Java 9 deprecated `Observer` and `Observable` because the event model is overly simplistic, not serializable/extensible, lacks type safety (pre-generics `Object arg`), forces class inheritance on the subject, and does not provide rich event details (like old vs. new values) compared to `java.beans.PropertyChangeListener` or modern reactive/custom observer APIs.

---

## Step 4: Self-Check Answers
1. **Why can't you extend another class if you already extend `Observable`?**
   Java allows a class to extend at most one superclass (`single inheritance`), so extending `Observable` uses up that single inheritance slot.
2. **What is the difference between the push model and the pull model?**
   In the **push model**, the subject sends the updated data directly as parameters to `update(...)` (e.g., `update(temp, humidity, pressure)`). In the **pull model**, the subject merely signals that a change occurred and the observer must query/call getters on the subject to pull the fields it needs.
3. **Why did Java deprecate these classes?**
   Because `Observable` is a concrete class rather than an interface, lacks type-safe event objects, has awkward `protected setChanged()` semantics, offers no control over notification order, and is superseded by `PropertyChangeListener`, `java.util.concurrent.Flow`, or custom Observer interfaces.
