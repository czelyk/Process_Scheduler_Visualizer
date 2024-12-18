import javax.swing.*;
import java.awt.*;

public class SchedulerGUI {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("CPU Scheduling Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Burst Time:"));
        JTextField burstTimeField = new JTextField();
        inputPanel.add(burstTimeField);

        inputPanel.add(new JLabel("Arrival Time:"));
        JTextField arrivalTimeField = new JTextField();
        inputPanel.add(arrivalTimeField);

        inputPanel.add(new JLabel("Priority:"));
        JTextField priorityField = new JTextField();
        inputPanel.add(priorityField);

        inputPanel.add(new JLabel("Algorithm:"));
        JComboBox<String> algorithmBox = new JComboBox<>(new String[] { "FCFS", "SJF", "Round Robin", "Priority" });
        inputPanel.add(algorithmBox);

        JButton startButton = new JButton("Start Simulation");
        inputPanel.add(startButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Output Panel
        JTextArea outputArea = new JTextArea();
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchedulerGUI::createAndShowGUI);
    }
}
