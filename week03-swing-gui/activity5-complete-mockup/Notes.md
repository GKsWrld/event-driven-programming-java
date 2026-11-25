# Activity 5: Student Portal Mockup Self-Check Notes

1. **How many different layout managers did you use in this mockup?**
   Four layout managers: `BorderLayout` (main frame, header, stat cards, status bar), `GridLayout` (sidebar 6×1 navigation buttons and 1×3 stat cards row), `BoxLayout` (`Y_AXIS` in the main content area), and `FlowLayout` implicitly inside default panels.

2. **Why do we use `Box.createVerticalStrut(20)` between components?**
   It inserts a clean, fixed-height invisible vertical spacer (20 pixels) inside a `BoxLayout` container without needing dummy panels or extra borders.

3. **What is the purpose of `setPreferredSize()` on the sidebar?**
   It fixes the sidebar width to 180 pixels so `BorderLayout.WEST` keeps a consistent navigation column rather than shrinking it to the minimum width of the button labels.
