# Event-Driven System Design

## System Name: Smart Home Controller

---

## Part 1: Event Sources
Components in the system that can generate events:

1. **Lights Toggle Button (`JToggleButton`)** — Generates an action event when the homeowner toggles living-room lights on or off.
2. **Security Arm/Disarm Toggle (`JToggleButton`)** — Generates an action event when the user arms or disarms the home security system.
3. **Front Door Sensor (`JButton` simulator)** — Generates a sensor trigger event whenever the front door opens.
4. **Thermostat Slider / +/- Buttons (`JButton`)** — Generates change/action events when the target temperature is adjusted up or down.
5. **Alarm Reset Button (`JButton`)** — Generates an action event to silence and clear an active intrusion alarm.

---

## Part 2: Events

| Event Name | Source | Description |
|---|---|---|
| `LightsToggled` (`ActionEvent`) | Lights Toggle Button | Fired when the user switches lights ON or OFF |
| `SecurityModeChanged` (`ActionEvent`) | Security Toggle Button | Fired when the security system transitions between ARMED and OFF |
| `DoorOpened` (`ActionEvent`) | Front Door Sensor | Fired when the front door magnetic sensor detects the door opening |
| `TemperatureAdjusted` (`ActionEvent`) | Thermostat + / − Buttons | Fired when the user raises or lowers the target thermostat temperature |
| `AlarmReset` (`ActionEvent`) | Reset Alarm Button | Fired when the user acknowledges and clears an active alarm state |

---

## Part 3: Event Handlers

| Event | Handler Action |
|---|---|
| `LightsToggled` | Update button label (`Lights: ON`/`OFF`), update status bar, append timestamped entry to event log |
| `SecurityModeChanged` | Update security state (`ARMED`/`OFF`), clear alarm highlight if disarmed, log state change |
| `DoorOpened` | Log door event; if security is ARMED, trigger `ALARM ACTIVE!` state, highlight panel red, and enable Reset button; otherwise log normal door entry |
| `TemperatureAdjusted` | Increment or decrement `targetTemp` within safe bounds (16°C–30°C), update thermostat label, and log the new setpoint |
| `AlarmReset` | Restore normal panel background color, update status label to `"Alarm cleared"`, and log acknowledgment |

---

## Part 4: Event Flow Diagram

```text
User / Sensor Action (e.g., Door Sensor Clicked)
        │
        ▼
  Event Source (doorButton)
        │  creates ActionEvent
        ▼
   Event Queue (AWT EventQueue)
        │  FIFO dispatch
        ▼
   Event Loop (Event Dispatch Thread - EDT)
        │  invokes registered ActionListener
        ▼
  Event Handler (actionPerformed / lambda)
        │  checks securityToggle.isSelected()
        ▼
   GUI Update (statusLabel, background color, eventLog)
```

---

## Part 5: Potential Issues & Prevention

1. **Blocking the EDT during hardware/network calls** — Real smart-home hubs communicate over Wi-Fi/Zigbee/HTTP. Running network I/O on the EDT would freeze the dashboard. **Prevention:** Run device communication on a background thread and update Swing UI components via `SwingUtilities.invokeLater()`.
2. **Thread-safety violations from sensor callbacks** — Background sensor polling threads updating `JLabel` or `JTextArea` directly can corrupt Swing state. **Prevention:** Route all UI updates through `SwingUtilities.invokeLater()`.
3. **Unbounded event log growth / memory bloat** — Continuous sensor events over weeks can cause `JTextArea` memory usage to grow endlessly. **Prevention:** Cap the log buffer (e.g., keep only the most recent 500 lines) or rotate logs to disk.
