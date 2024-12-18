import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SchedulerGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private List<Process> processes = new ArrayList<>();

    public SchedulerGUI() {
        frame = new JFrame("CPU Scheduling Simulator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JTextField arrivalField = new JTextField();
        JTextField burstField = new JTextField();
        JTextField priorityField = new JTextField();
        JComboBox<String> algorithmBox = new JComboBox<>(new String[] { "FCFS", "SJF", "Round Robin", "Priority" });
        JButton addButton = new JButton("Add Process");
        JButton simulateButton = new JButton("Simulate");

        inputPanel.add(new JLabel("Arrival Time:"));
        inputPanel.add(arrivalField);
        inputPanel.add(new JLabel("Burst Time:"));
        inputPanel.add(burstField);
        inputPanel.add(new JLabel("Priority:"));
        inputPanel.add(priorityField);
        inputPanel.add(new JLabel("Algorithm:"));
        inputPanel.add(algorithmBox);
        inputPanel.add(addButton);
        inputPanel.add(simulateButton);

        // Output Area
        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Event Listeners
        addButton.addActionListener(e -> {
            int arrival = Integer.parseInt(arrivalField.getText());
            int burst = Integer.parseInt(burstField.getText());
            int priority = Integer.parseInt(priorityField.getText());
            processes.add(new Process(processes.size() + 1, arrival, burst, priority));
            outputArea.append("Added Process: " + processes.size() + "\n");
        });

        simulateButton.addActionListener(e -> {
            String selectedAlgorithm = (String) algorithmBox.getSelectedItem();
            SchedulingAlgorithm scheduler = getAlgorithmInstance(selectedAlgorithm);
            scheduler.schedule(processes);
            outputArea.append("\nGantt Chart:\n");
            for (GanttChartSlot slot : scheduler.getGanttChart()) {
                outputArea.append("P" + slot.getProcessId() + " [" + slot.getStartTime() + "-" + slot.getEndTime() + "]\n");
            }
        });

        frame.setVisible(true);
    }

    private SchedulingAlgorithm getAlgorithmInstance(String algorithmName) {
        switch (algorithmName) {
            case "SJF":
                return new SJF();
            case "Round Robin":
                return new RoundRobin(2); // Time quantum = 2
            case "Priority":
                return new PriorityScheduler();
            default:
                return new FCFS();
        }
    }


    public static void main(String[] args) {
        new SchedulerGUI();
    }
}
