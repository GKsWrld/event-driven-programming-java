# Activity 3: Refactoring Notes — Tight Coupling vs. Observer Pattern

## Step 2: Identifying the Coupling Problem

1. **What happens if we want to add a third display class? Do we have to modify `DataModel`?**
   Yes. In `TightlyCoupledSystem`, `DataModel.setValue()` hardcodes calls to `new LabelDisplay().showValue(value)` and `new BarChartDisplay().drawBar(value)`, so adding a third display requires editing and recompiling `DataModel`.
2. **What happens if `LabelDisplay` is deleted or renamed?**
   `DataModel` immediately fails to compile because it directly depends on the concrete `LabelDisplay` class name and its `showValue()` method.
3. **Can we easily test `DataModel` in isolation?**
   No. Any test of `DataModel.setValue()` forces `LabelDisplay` and `BarChartDisplay` to be instantiated and executed too.

---

## Step 4: Comparison of Approaches

| Aspect | Tightly Coupled | Observer Pattern |
|---|---|---|
| Adding a new display | Modify `DataModel` directly | Create a `DataObserver` and call `addObserver()` |
| Testing `DataModel` in isolation | Hard — depends on concrete display classes | Easy — test `DataModel` with no observers or a mock `DataObserver` |
| Removing a display | Modify `DataModel` source code | Call `removeObserver()` or stop registering it |
| Open/Closed Principle | Violated — must edit `DataModel` for new displays | Satisfied — extend with new observers without editing `DataModel` |
