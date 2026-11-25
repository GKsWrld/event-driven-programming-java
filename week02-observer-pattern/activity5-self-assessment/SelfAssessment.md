# Week 2: Final Self-Assessment & Summary

## Self-Assessment Answers

### Learning Outcome 1: Design and Implement the Observer Pattern
1. **UML Diagram of the Observer Pattern:**
   ```text
   +-------------------------------+          +---------------------------+
   |        <<interface>>          |          |       <<interface>>       |
   |           Subject             |<>------->|         Observer          |
   +-------------------------------+ 1      * +---------------------------+
   | + registerObserver(o)         |          | + update(data...)         |
   | + removeObserver(o)           |          +---------------------------+
   | + notifyObservers()           |                        ^
   +-------------------------------+                        | implements
                   ^                                        |
                   | implements               +---------------------------+
                   |                          |     ConcreteObserver      |
   +-------------------------------+          +---------------------------+
   |       ConcreteSubject         |          | - observerState           |
   +-------------------------------+          +---------------------------+
   | - observers: List<Observer>   |          | + update(data...)         |
   | - subjectState                |          +---------------------------+
   +-------------------------------+
   | + registerObserver(o)         |
   | + removeObserver(o)           |
   | + notifyObservers()           |
   +-------------------------------+
   ```
2. **Subject Interface Code (from memory):**
   ```java
   public interface Subject {
       void registerObserver(Observer o);
       void removeObserver(Observer o);
       void notifyObservers();
   }
   ```
3. **Why does the Subject need a list of observers?**
   Because multiple independent observers can subscribe to the same Subject simultaneously, and the Subject needs a collection to track and iterate over all active subscribers whenever its state changes.

### Learning Outcome 2: Evaluate Legacy `java.util.Observer`
4. **Three problems with `java.util.Observable`:**
   - It is a concrete class instead of an interface, forcing single inheritance.
   - `setChanged()` is `protected`, awkward to remember, and blocks pure composition.
   - Notification order cannot be customized and `update(Observable, Object)` lacks generic type safety.
5. **Why was this API deprecated?**
   Deprecated in Java 9 because its event model is inflexible, not type-safe, not serializable, and superseded by `PropertyChangeListener`, `java.util.concurrent.Flow`, and custom observer interfaces.
6. **What is the "pull model" and why is it harder to use?**
   In the pull model, the subject notifies observers without sending the changed fields, forcing each observer to hold a reference to the subject, cast it, and call getters to fetch data—increasing coupling and boilerplate.

### Learning Outcome 3: Create a Custom Event Notification System
7. **What methods must a custom `Subject` interface provide?**
   `registerObserver(Observer o)` (subscribe), `removeObserver(Observer o)` (unsubscribe), and `notifyObservers()` (broadcast state updates).
8. **How does the Subject notify all observers?**
   By iterating over its internal `List<Observer>` and invoking each observer's callback method (e.g., `o.update(...)`).
9. **How do you prevent a memory leak when observers are no longer needed?**
   Always call `removeObserver(o)` when an observer is disposed or closed so the Subject does not keep holding a strong reference that blocks garbage collection.

### Learning Outcome 4: Compare Different Mechanisms
10. **Four event notification mechanisms in Java:**
    Custom Observer, `java.util.Observer`/`Observable`, `PropertyChangeListener` (`java.beans`), and JavaFX Properties/Bindings.
11. **Which one is best for JavaFX?**
    JavaFX Properties and Bindings.
12. **Which one is deprecated?**
    `java.util.Observer` / `java.util.Observable`.

---

## Score
**Score:** 12 / 12 — Excellent! All Week 2 Observer pattern outcomes mastered.

---

## One-Page Summary: The Observer Pattern

The **Observer pattern** defines a one-to-many dependency between objects so that when one object (the **Subject** or publisher) changes state, all of its dependent objects (**Observers** or subscribers) are notified and updated automatically. Rather than hardcoding calls to concrete UI displays inside a data model—which creates tight coupling—the Subject holds a `List<Observer>` and communicates solely through an `Observer` interface. This keeps the Subject completely independent of concrete observer implementations, making it effortless to add, remove, or test observers without modifying the Subject.

In Java, designing custom `Subject` and `Observer` interfaces is clean, type-safe, and avoids the pitfalls of the deprecated `java.util.Observable` class (which wasted single inheritance and lacked type safety). When building Swing or JavaBeans applications, `PropertyChangeSupport` and `PropertyChangeListener` provide built-in listener management along with old and new property values, while JavaFX offers reactive properties and bindings out of the box. Regardless of mechanism, always deregister observers when they are no longer needed to prevent memory leaks.

---

## Final Reflection

The Observer pattern is a foundational behavioral design pattern that decouples event producers from event consumers by letting multiple listeners subscribe to a subject through a shared interface. It directly underpins event-driven programming: Swing's `JButton` acts as a subject, `ActionListener` acts as the observer interface, and calling `addActionListener()` registers an observer to be notified whenever a click occurs. Without this pattern, models and UI components would be tightly coupled, making applications brittle and difficult to extend. For a plain Java or Swing project, I would choose a **Custom Observer** interface when domain-specific typed payloads are needed (or `PropertyChangeListener` when binding JavaBean properties), and **JavaFX Bindings** when building modern JavaFX interfaces.
