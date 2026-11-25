# Week 8: Self-Check Notes & Final Self-Assessment

## Activity 1: Observable Properties
1. **Why use `StringProperty` instead of `String` in a JavaFX model?**
   A standard `String` cannot notify observers when replaced. `StringProperty` wraps the value and supports listeners and bindings so the UI updates automatically.
2. **What is the purpose of `nameProperty()`?**
   It exposes the `StringProperty` object itself (rather than the unwrapped `String`) so views and expressions can bind or attach listeners to it.

## Activity 2: `ChangeListener` vs. `InvalidationListener`
1. **Main difference:**
   `InvalidationListener` only signals that the property became invalid (something changed), whereas `ChangeListener` provides `(observable, oldValue, newValue)`.
2. **What happens if a property is set to the exact same value it already holds?**
   JavaFX skips notifying listeners because the value did not change.

## Activity 3: Unidirectional Binding
1. **What does "unidirectional" mean?**
   Updates flow one way: changes to the source property automatically update the target property, not vice versa.
2. **What happens if you call `greetingLabel.setText("New Text")` on a bound label?**
   It throws `RuntimeException: A bound value cannot be set.` You must call `.unbind()` first.

## Activity 4: Bidirectional Binding
1. **Difference between `bind()` and `bindBidirectional()`:**
   `bind()` is one-way (source → target); `bindBidirectional()` syncs both properties in either direction.
2. **Why was `NumberStringConverter` needed?**
   To convert between `Slider.valueProperty()` (`Double`) and `TextField.textProperty()` (`String`).

## Activity 5: Reactive Registration Form
1. **Why bind `disableProperty()` instead of validating inside a `KeyListener`?**
   Bindings are declarative, automatically kept in sync across all dependent fields, and eliminate boilerplate listener code.
2. **How does the email `@` check work?**
   A `BooleanBinding` checks `!emailField.getText().contains("@")` and combines with `.isEmpty()` and `.length().greaterThan(150)` via `.or(...)` so the Submit button stays disabled until all rules pass.

---

## Final Self-Assessment Checklist
- **Outcome 1:** Created `Person` with `StringProperty` / `IntegerProperty` and property getters.
- **Outcome 2:** Implemented `InvalidationListener` and `ChangeListener` in `ListenerDemo`.
- **Outcome 3:** Implemented unidirectional (`UnidirectionalDemo`) and bidirectional (`BidirectionalDemo`) bindings.
- **Outcome 4:** Built reactive validation and live preview in `ReactiveFormApp`.
