package uni.aed.graphs.drozdek.experimental;

import java.util.*;

public class DeadlockDetection2 {
    private Map<String, Set<String>> graph;
    private Set<String> visited;
    private Set<String> cycleNodes;

    public DeadlockDetection2() {
        graph = new HashMap<>();
        visited = new HashSet<>();
        cycleNodes = new HashSet<>();
    }

    public void processOperation(String operation) {
        String[] parts = operation.split(",");
        String transaction = parts[0].trim();
        String type = parts[1].trim();
        String resource = parts[2].trim();

        if (type.equals("read")) {
            processRead(transaction, resource);
        } else if (type.equals("write")) {
            processWrite(transaction, resource);
        } else if (type.equals("end")) {
            processEnd(transaction);
        }
    }

    private void processRead(String transaction, String resource) {
        if (graph.containsKey(transaction)) {
            Set<String> dependencies = graph.get(transaction);
            for (String dependency : dependencies) {
                addEdge(dependency, transaction);
            }
        }
        addNode(transaction);
    }

    private void processWrite(String transaction, String resource) {
        addNode(transaction);
    }

    private void processEnd(String transaction) {
        visited.add(transaction);
        cycleNodes.remove(transaction);
        graph.remove(transaction);
    }

    private void addEdge(String from, String to) {
        if (from.equals(to)) {
            return;
        }
        graph.putIfAbsent(from, new HashSet<>());
        graph.get(from).add(to);
        if (dfs(to, new HashSet<>())) {
            System.out.println("Deadlock detected: Transaction " + from + " is waiting for Transaction " + to);
        }
    }

    private boolean dfs(String node, Set<String> visitedNodes) {
        if (visitedNodes.contains(node)) {
            return true; // Cycle detected
        }

        visitedNodes.add(node);

        if (graph.containsKey(node)) {
            for (String neighbor : graph.get(node)) {
                if (dfs(neighbor, visitedNodes)) {
                    return true; // Cycle detected
                }
            }
        }

        visitedNodes.remove(node);
        return false;
    }

    private void addNode(String node) {
        if (!visited.contains(node)) {
            cycleNodes.add(node);
        }
    }

    public static void main(String[] args) {
        DeadlockDetection2 detector = new DeadlockDetection2();

        // Input operations
//        String[] operations = {
//                "read(T1, A1)",
//                "read(T2, A2)",
//                "read(T1, A2)",
//                "write(T1, A2)",
//                "end(T1)"
//        };
        
        // Input operations
        String[] operations = {
                //"T1,read,A1",
                "T2,read,A2",
                //"T1,read,A2",
                "T1,write,A2",
                "T1,end,N"
        };

        // Process operations
        for (String operation : operations) {
            detector.processOperation(operation);
        }
    }
}

