import java.util.List;

public interface SchedulingAlgorithm {
    void schedule(List<Process> processes); // Executes the scheduling
    List<GanttChartSlot> getGanttChart();   // Returns the Gantt chart
}
