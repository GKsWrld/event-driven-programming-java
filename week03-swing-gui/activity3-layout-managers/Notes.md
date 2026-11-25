# Activity 3: Layout Managers Self-Check Notes

1. **When would you choose `GridLayout` over `FlowLayout`?**
   Use `GridLayout` when you need uniform, equal-sized cells in a fixed row-by-column grid (e.g., calculator keypad, dashboard cards). Use `FlowLayout` when components should keep their natural preferred sizes and wrap onto the next line (e.g., toolbars).

2. **Why do we often nest layout managers?**
   No single layout manager handles every section of a real application UI. Nesting `JPanel` containers—each with its own layout—lets you combine a `BorderLayout` shell with a `FlowLayout` toolbar, a vertical `GridLayout` sidebar, and a grid/box content area.

3. **What does `BorderLayout.CENTER` do differently from the other regions?**
   `CENTER` expands both horizontally and vertically to fill all remaining space left over by `NORTH`, `SOUTH`, `EAST`, and `WEST`, which only take their preferred height or width.
