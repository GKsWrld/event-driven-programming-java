# Week 4: Final Self-Assessment

## Learning Outcome 1: Implement `ActionListener` using multiple techniques
- **Self-Rating:** 5 / 5
- **Three ways to implement an `ActionListener`:**
  1. **Named class** implementing `ActionListener` (best when reused across multiple components or holding state).
  2. **Anonymous inner class** (`new ActionListener() { ... }`) (common in pre-Java 8 codebases).
  3. **Lambda expression** (`e -> { ... }`) or **method reference** (`ClassName::method`) (concise, preferred in modern Java).

## Learning Outcome 2: Handle state changes in checkboxes, radio buttons, and text fields
- **Self-Rating:** 5 / 5
- **Checkbox / RadioButton state changes:** `ItemListener` (`itemStateChanged(ItemEvent e)`).
- **Text field / text area changes:** `DocumentListener` (`insertUpdate`, `removeUpdate`, `changedUpdate` attached via `getDocument().addDocumentListener(...)`).

## Learning Outcome 3: Differentiate between listener interfaces

| Component / Action | Appropriate Listener |
|---|---|
| `JButton` | `ActionListener` |
| `JCheckBox` | `ItemListener` (or `ActionListener`) |
| `JTextField` (live typing) | `DocumentListener` (via `getDocument()`) |
| Mouse hover / click / drag | `MouseListener` / `MouseMotionListener` (`MouseAdapter`) |
| Key press | `KeyListener` (`KeyAdapter`) or Key Bindings (`InputMap` / `ActionMap`) |

## Learning Outcome 4: Build an interactive Swing application
- **Self-Rating:** 5 / 5
- **Interactive Registration Form:** Built in `activity5-interactive-form/RegistrationForm.java` with full input validation, `ButtonGroup` radio selection, interest checkboxes, country dropdown, comments scroll pane, Submit confirmation dialog, Clear reset, and Exit confirmation prompt.
