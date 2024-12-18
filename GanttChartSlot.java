public class GanttChartSlot {
    private int processId;
    private int startTime;
    private int endTime;

    // Constructor
    public GanttChartSlot(int processId, int startTime, int endTime) {
        this.processId = processId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters
    public int getProcessId() { return processId; }
    public int getStartTime() { return startTime; }
    public int getEndTime() { return endTime; }
}
