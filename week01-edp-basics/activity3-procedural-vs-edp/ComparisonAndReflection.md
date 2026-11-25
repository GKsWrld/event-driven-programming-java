# Activity 3: Procedural vs. Event-Driven Comparison & Reflection

## Step 2: Procedural Calculator Questions

1. **What is the exact order of steps in this program?**
   1. Prompt and read `num1`.
   2. Prompt and read `operator`.
   3. Prompt and read `num2`.
   4. Evaluate `switch (operator)` to compute `result`.
   5. Print the formatted result and close the `Scanner`.
2. **What happens if the user enters the wrong input at step 2?**
   If the user enters an unrecognized operator (e.g., `%`), the `default` branch prints `"Invalid operator"` and immediately exits the program (`return`), losing the numbers already entered. If they enter non-numeric text at step 1 or 3, `nextDouble()` throws an `InputMismatchException` and crashes.
3. **Can the user calculate again without restarting the program?**
   No. Once the calculation finishes (or fails), `main` reaches the end and terminates.
4. **Who controls the flow of this program—the user or the program?**
   The **program** controls the flow strictly from top to bottom.

---

## Step 3: Event-Driven Calculator Questions

1. **Can the user click buttons in any order?**
   Yes. The user can click digits, change their mind, press `C`, select another operator, or press `=` at any time.
2. **What happens if the user makes a mistake?**
   They can simply click the `C` (Clear) button to reset the display and operands without restarting the program.
3. **Can the user calculate again without restarting?**
   Yes. The application stays running in the Swing event loop until the user closes the window.
4. **Who controls the flow—the user or the program?**
   The **user** controls the flow by choosing which buttons to click and when.
5. **How many event handlers are in this program?**
   There are 16 buttons total (10 number buttons, 4 operator buttons, 1 equals button, and 1 clear button), each with an `ActionListener` lambda attached (implemented via 4 helper factory methods: `createNumberButton`, `createOperatorButton`, `createEqualsButton`, `createClearButton`).

---

## Step 4: Comparison Table

| Aspect | Procedural | Event-Driven |
|---|---|---|
| Who controls the flow? | The program (fixed sequential script) | The user (via events and UI actions) |
| Can user make mistakes and recover easily? | No; invalid input ends or crashes the run | Yes; user can click Clear (`C`) and retry immediately |
| Can user interact in any order? | No; must follow Step 1 -> Step 2 -> Step 3 | Yes; user can click any button in any order |
| How many possible execution paths? | Very few (one linear path with minor branches) | Practically infinite (any sequence of button clicks) |
| Code organization | Sequential blocks inside `main()` | Component setup + modular event listener/handler methods |
| User experience | Rigid, text-only, single-use | Flexible, visual, intuitive, continuously interactive |

---

## Step 5: Reflection

Procedural programming executes instructions in a predetermined, linear order where the program dictates exactly when and how input must be provided, whereas event-driven programming waits in an idle loop and reacts dynamically to user actions in any sequence. In the procedural calculator, a single mistake forces the user to restart, while the Swing event-driven calculator lets users clear errors, run multiple calculations, and interact freely with buttons on screen. For interactive applications, the event-driven approach is strongly preferred because users expect immediate visual feedback and control over what they do next. Event-driven programming is far better suited for GUIs because graphical interfaces contain many independent controls—buttons, menus, text fields, and windows—that cannot be forced into a rigid top-to-bottom sequence. By decoupling each control's event handler from a fixed execution path, event-driven GUIs stay responsive, modular, and easy to extend.
