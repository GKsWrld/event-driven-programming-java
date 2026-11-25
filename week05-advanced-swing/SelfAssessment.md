# Week 5: Final Self-Assessment

## Learning Outcome 1: Create and use advanced Swing components
- **Self-Rating:** 5 / 5

| Component | Purpose |
|---|---|
| `JList` | Displays a scrollable list of selectable items (with optional custom row rendering). |
| `JTable` | Displays and edits structured 2D tabular data backed by a `TableModel`. |
| `JTree` | Displays hierarchical tree data (folders and nested items) via `TreeModel` nodes. |
| `JTabbedPane` | Organizes multiple panels into clickable tabs within the same window. |

## Learning Outcome 2: Implement custom renderers
- **Self-Rating:** 5 / 5
- **Customizing `JList` rows:** Call `list.setCellRenderer(...)` with a `DefaultListCellRenderer` subclass overriding `getListCellRendererComponent(...)` to apply icons, colors, fonts, and borders.
- **Customizing `JTable` cells:** Call `table.getColumnModel().getColumn(index).setCellRenderer(...)` with a `DefaultTableCellRenderer` subclass overriding `getTableCellRendererComponent(...)`.

## Learning Outcome 3: Create dialogs, menus, and toolbars
- **Self-Rating:** 5 / 5
- **Four common `JOptionPane` methods:**
  1. `JOptionPane.showMessageDialog(...)` — Information, warning, or error popups.
  2. `JOptionPane.showConfirmDialog(...)` — Yes/No/Cancel confirmation prompts.
  3. `JOptionPane.showInputDialog(...)` — Single-field user input prompts.
  4. `JOptionPane.showOptionDialog(...)` — Custom multi-option button dialogs.

## Learning Outcome 4: Build a multi-pane application
- **Self-Rating:** 5 / 5
- **Capstone `FileManager.java`:** Built with `JMenuBar`, `JToolBar`, `JSplitPane`, `JTree`, `JTable`, double-click navigation, and status bar feedback.
