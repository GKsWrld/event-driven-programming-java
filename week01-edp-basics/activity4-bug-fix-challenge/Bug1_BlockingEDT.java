import javax.swing.*;
import java.awt.*;

public class Bug1_BlockingEDT extends JFrame {
    private JLabel statusLabel;
    private JButton processButton;

    public Bug1_BlockingEDT() {
        setTitle("Bug 1 - Fixed EDT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        statusLabel = new JLabel("Ready");
        processButton = new JButton("Process");

        processButton.addActionListener(e -> {
            statusLabel.setText("Processing...");
            processButton.setEnabled(false);

            // FIX: Run the long operation in a background thread so the EDT stays responsive
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                // Update GUI components back on the EDT
                SwingUtilities.invokeLater(() -> {
                    statusLabel.setText("Done!");
                    processButton.setEnabled(true);
                });
            }).start();
        });

        add(statusLabel);
        add(processButton);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bug1_BlockingEDT().setVisible(true);
        });
    }
}
