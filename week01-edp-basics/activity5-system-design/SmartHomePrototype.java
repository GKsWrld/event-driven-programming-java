import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SmartHomePrototype extends JFrame {
    private JLabel statusLabel;
    private JLabel tempLabel;
    private JTextArea eventLog;
    private JToggleButton lightsToggle;
    private JToggleButton securityToggle;
    private JButton doorButton;
    private JButton resetAlarmButton;
    private JPanel mainPanel;
    private int targetTemp = 22;

    public SmartHomePrototype() {
        setTitle("Smart Home Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Status Panel (NORTH)
        JPanel topPanel = new JPanel(new BorderLayout(10, 5));
        topPanel.setOpaque(false);
        statusLabel = new JLabel("System Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        tempLabel = new JLabel("Thermostat: " + targetTemp + "°C", SwingConstants.RIGHT);
        tempLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(statusLabel, BorderLayout.WEST);
        topPanel.add(tempLabel, BorderLayout.EAST);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Event Log (CENTER)
        eventLog = new JTextArea(12, 35);
        eventLog.setEditable(false);
        mainPanel.add(new JScrollPane(eventLog), BorderLayout.CENTER);

        // Control Panel (SOUTH)
        JPanel controlPanel = new JPanel(new GridLayout(5, 1, 5, 5));

        // Lights Toggle
        lightsToggle = new JToggleButton("Lights: OFF");
        lightsToggle.addActionListener(e -> {
            if (lightsToggle.isSelected()) {
                lightsToggle.setText("Lights: ON");
                logEvent("Lights turned ON");
                statusLabel.setText("Lights are on");
            } else {
                lightsToggle.setText("Lights: OFF");
                logEvent("Lights turned OFF");
                statusLabel.setText("Lights are off");
            }
        });

        // Security Toggle
        securityToggle = new JToggleButton("Security: OFF");
        securityToggle.addActionListener(e -> {
            if (securityToggle.isSelected()) {
                securityToggle.setText("Security: ARMED");
                logEvent("Security system ARMED");
                statusLabel.setText("Security armed");
            } else {
                securityToggle.setText("Security: OFF");
                mainPanel.setBackground(null);
                logEvent("Security system DISARMED");
                statusLabel.setText("Security disarmed");
            }
        });

        // Door Sensor Button
        doorButton = new JButton("Simulate Door Open");
        doorButton.addActionListener(e -> {
            logEvent("Door sensor triggered");
            if (securityToggle.isSelected()) {
                logEvent("ALARM! Intruder detected!");
                statusLabel.setText("ALARM ACTIVE!");
                mainPanel.setBackground(new Color(255, 180, 180));
                resetAlarmButton.setEnabled(true);
            } else {
                logEvent("Door opened (no alarm)");
                statusLabel.setText("Door opened");
            }
        });

        // Thermostat Controls
        JPanel thermostatPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        thermostatPanel.setOpaque(false);
        JButton tempDownBtn = new JButton("Temp -1°C");
        JButton tempUpBtn = new JButton("Temp +1°C");

        tempDownBtn.addActionListener(e -> adjustTemperature(-1));
        tempUpBtn.addActionListener(e -> adjustTemperature(1));

        thermostatPanel.add(tempDownBtn);
        thermostatPanel.add(tempUpBtn);

        // Reset Alarm Button
        resetAlarmButton = new JButton("Reset Alarm");
        resetAlarmButton.setEnabled(false);
        resetAlarmButton.addActionListener(e -> {
            mainPanel.setBackground(null);
            resetAlarmButton.setEnabled(false);
            logEvent("Alarm reset by user");
            statusLabel.setText("Alarm cleared");
        });

        controlPanel.add(lightsToggle);
        controlPanel.add(securityToggle);
        controlPanel.add(doorButton);
        controlPanel.add(thermostatPanel);
        controlPanel.add(resetAlarmButton);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setSize(480, 480);
        setLocationRelativeTo(null);
        logEvent("Smart Home Controller initialized on EDT");
    }

    private void adjustTemperature(int delta) {
        int nextTemp = targetTemp + delta;
        if (nextTemp < 16 || nextTemp > 30) {
            statusLabel.setText("Thermostat limit reached (16°C–30°C)");
            return;
        }
        targetTemp = nextTemp;
        tempLabel.setText("Thermostat: " + targetTemp + "°C");
        logEvent("Thermostat set to " + targetTemp + "°C");
        statusLabel.setText("Thermostat updated to " + targetTemp + "°C");
    }

    private void logEvent(String event) {
        String timestamp = new Date().toString();
        eventLog.append("[" + timestamp + "] " + event + "\n");
        eventLog.setCaretPosition(eventLog.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SmartHomePrototype().setVisible(true);
        });
    }
}
