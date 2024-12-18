import java.util.*;

public class RoundRobin implements SchedulingAlgorithm {
    private List<GanttChartSlot> ganttChart = new ArrayList<>();
    private int timeQuantum = 2; // Default time quantum

    public RoundRobin(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void schedule(List<Process> processes) {
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Process process = queue.poll();
            int remainingTime = process.getBurstTime() - process.getWaitingTime();
            int executionTime = Math.min(timeQuantum, remainingTime);

            ganttChart.add(new GanttChartSlot(process.getProcessId(), currentTime, currentTime + executionTime));
            currentTime += executionTime;
            process.setWaitingTime(process.getWaitingTime() + executionTime);

            if (remainingTime > timeQuantum) {
                queue.add(process); // Re-add the process if not finished
            } else {
                process.setTurnaroundTime(currentTime - process.getArrivalTime());
            }
        }
    }

    @Override
    public List<GanttChartSlot> getGanttChart() {
        return ganttChart;
    }
}
