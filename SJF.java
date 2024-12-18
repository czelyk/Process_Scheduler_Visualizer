import java.util.*;

public class SJF implements SchedulingAlgorithm {
    private List<GanttChartSlot> ganttChart = new ArrayList<>();

    @Override
    public void schedule(List<Process> processes) {
        processes.sort(Comparator.comparingInt(Process::getBurstTime)
                .thenComparingInt(Process::getArrivalTime));
        int currentTime = 0;

        for (Process process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }
            ganttChart.add(new GanttChartSlot(process.getProcessId(), currentTime, currentTime + process.getBurstTime()));
            process.setWaitingTime(currentTime - process.getArrivalTime());
            process.setTurnaroundTime(process.getWaitingTime() + process.getBurstTime());
            currentTime += process.getBurstTime();
        }
    }

    @Override
    public List<GanttChartSlot> getGanttChart() {
        return ganttChart;
    }
}
