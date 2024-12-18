import java.util.List;

public class PerformanceMetrics {
    public static double calculateAverageWaitingTime(List<Process> processes) {
        return processes.stream()
                .mapToInt(Process::getWaitingTime)
                .average()
                .orElse(0.0);
    }

    public static double calculateAverageTurnaroundTime(List<Process> processes) {
        return processes.stream()
                .mapToInt(Process::getTurnaroundTime)
                .average()
                .orElse(0.0);
    }

    public static double calculateThroughput(List<Process> processes, int totalTime) {
        return (double) processes.size() / totalTime;
    }
}
