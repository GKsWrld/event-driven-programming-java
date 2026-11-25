# Comparison of Event Notification Mechanisms in Java

| Feature | Custom Observer | `java.util.Observer` | `PropertyChangeListener` | JavaFX Bindings |
|---|---|---|---|---|
| **Push or Pull?** | Both possible | Pull by default | Push (carries old + new) | Push / Reactive |
| **Is it deprecated?** | No | Yes (Java 9+) | No | No |
| **Requires inheritance?** | No (interface) | Yes (`extends Observable`) | No (composition via `PropertyChangeSupport`) | No |
| **Thread-safe?** | Depends on implementation | No | Yes (`PropertyChangeSupport` is thread-safe for listener management) | FX Application Thread |
| **Auto-generates boilerplate?** | No | Partial (`Observable`) | Yes (via `PropertyChangeSupport`) | Yes (Properties & Bindings) |
| **Best for...** | Plain/custom Java systems | Legacy code only | JavaBeans / Swing models | Modern JavaFX apps |
| **Can have multiple listeners?** | Yes | Yes | Yes | Yes |
| **Can be typed to send any data?** | Yes (strongly typed params) | No (`Object` arg) | Untyped (`Object` old/new values) | Yes (`ObservableValue<T>`) |
| **Recommended today?** | Yes | No | When integrating with Swing/JavaBeans | Yes |

---

## Which One Should You Use?
- **Plain Java project with custom needs** -> **Custom Observer**
- **JavaFX application** -> **JavaFX Bindings**
- **Swing / JavaBeans property change propagation** -> **`PropertyChangeListener`**
- **Never for new code** -> **`java.util.Observer` / `Observable`**

---

## Step 4: Self-Check Answers
1. **Which mechanism carries both the old and new value of a property?**
   `PropertyChangeListener` (via `PropertyChangeEvent.getOldValue()` and `getNewValue()`).
2. **Which mechanism requires a helper class to manage the listener list?**
   `PropertyChangeListener` (uses `PropertyChangeSupport` to register, remove, and notify listeners).
3. **Which two mechanisms are recommended for modern Java?**
   Custom Observer interfaces and JavaFX Properties/Bindings.
4. **Which mechanism is deprecated and should be avoided?**
   `java.util.Observer` and `java.util.Observable` (deprecated since Java 9).
