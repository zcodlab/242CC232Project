package uni.aed.graphs.drozdek.experimental;

import java.util.*;

public class DeadlockDetection1 {
    private Map<String, List<String>> graph;
    private Set<String> visited;
    private Set<String> cycleNodes;

    public DeadlockDetection1() {
        graph = new HashMap<>();
        visited = new HashSet<>();
        cycleNodes = new HashSet<>();
    }

    public void addDependency(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }

    public boolean hasCycle() {
        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String node) {
        visited.add(node);
        cycleNodes.add(node);

        if (graph.containsKey(node)) {
            for (String neighbor : graph.get(node)) {
                if (cycleNodes.contains(neighbor)) {
                    return true; // Cycle detected
                }
                if (!visited.contains(neighbor) && dfs(neighbor)) {
                    return true; // Cycle detected
                }
            }
        }

        cycleNodes.remove(node);
        return false;
    }

    public static void main(String[] args) {
        DeadlockDetection1 detector = new DeadlockDetection1();

        // Add dependencies
        detector.addDependency("T1", "T2");
        detector.addDependency("T2", "T1");
        detector.addDependency("T3", "T2");

        // Detect deadlock
        if (detector.hasCycle()) {
            System.out.println("Deadlock detected");
        } else {
            System.out.println("No deadlock detected");
        }
    }
}
