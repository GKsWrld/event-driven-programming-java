# Activity 1: "Spot the Components" — Real-World EDP Scavenger Hunt

## Completed EDP Components Table (8 Systems)

| System | Event Source | Event | Listener | Handler / Action |
|---|---|---|---|---|
| ATM Machine Operation | Keypad button | Button pressed | ATM input controller | Verify PIN or append digit to input |
| ATM Machine Operation | Card slot | Card inserted | Card reader sensor | Read card chip/magnetic stripe data |
| ATM Machine Operation | Cash dispenser | Cash taken | Dispenser optical sensor | Close shutter and end transaction |
| Microwave Oven Use | Door latch / Start button | Door closed / Start pressed | Microcontroller firmware | Engage magnetron and start countdown timer |
| Traffic Light System | Countdown timer / Road inductive loop | Timer expired / Vehicle detected | Traffic signal controller | Transition light state (Green -> Yellow -> Red) |
| Video Game Gameplay | Keyboard / Game controller | Key pressed / Stick moved | Game engine input listener | Move player character or trigger action |
| Elevator Operation | Floor call button | Call button pressed | Elevator control system | Add floor to request queue and dispatch cab |
| Smartphone Touchscreen | Capacitive touch digitizer | Finger tap / Swipe gesture | OS touch event dispatcher | Open app icon or scroll active view |
| Online Shopping Website | "Add to Cart" button | Mouse click (`onclick`) | Browser JavaScript event listener | Add item to cart state and update badge count |
| Smart TV Remote | Infrared / Bluetooth remote button | Volume Up button pressed | TV IR/BT receiver daemon | Increase audio output level and display volume bar |

---

## Step 4: Self-Check Questions

1. **What is the difference between an event source and an event listener?**
   An **event source** is the object or component where an event originates (such as a `JButton`, keypad, or timer) and that fires an event object when triggered. An **event listener** is the object registered to watch for that event and react when it arrives by invoking its event handler method.

2. **Can one event source have multiple listeners? Give an example.**
   Yes. One event source can notify multiple registered listeners when an event occurs. For example, clicking a **"Checkout"** button on an e-commerce page can trigger one listener to update the order database, a second listener to send a confirmation email, and a third listener to log analytics.

3. **Can one listener handle events from multiple sources? Give an example.**
   Yes. A single listener instance can be attached to several event sources and inspect `e.getSource()` (or `e.getActionCommand()`) to decide what to do. For example, in a Swing calculator, one shared `ActionListener` can handle all digit buttons (`0`–`9`) by reading the clicked button's text and appending it to the display.
