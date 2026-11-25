# Week 3: Final Self-Assessment

## Learning Outcome 1: Create a functional Swing application with a main window
- **Self-Rating:** 5 / 5
- **Minimal JFrame code from memory:**
  ```java
  SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("My Window");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 400);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  });
  ```

## Learning Outcome 2: Add, customize, and arrange components using layouts
- **Self-Rating:** 5 / 5
- **Four layout managers and use cases:**
  1. `FlowLayout` — Toolbars or button rows that wrap naturally when the window resizes.
  2. `BorderLayout` — Main application shell with header (`NORTH`), sidebar (`WEST`), main view (`CENTER`), and status bar (`SOUTH`).
  3. `GridLayout` — Uniform button grids (e.g., calculators) or equal-width stat cards.
  4. `BoxLayout` — Vertical or horizontal stacking of sections with spacers (`Box.createVerticalStrut`).

## Learning Outcome 3: Ensure GUI code runs on the EDT
- **Self-Rating:** 5 / 5
- **Two golden rules of Swing threading:**
  1. All Swing GUI creation and component updates must execute on the Event Dispatch Thread (`SwingUtilities.invokeLater(...)`).
  2. Never perform slow/blocking operations on the EDT; run them in a background thread and post UI updates back to the EDT.

## Learning Outcome 4: Build a static, non-interactive UI layout
- **Self-Rating:** 5 / 5
- **StudentPortal.java status:** Completed and customized for Riara University Student Portal.
