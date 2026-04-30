package graphs.graphsearch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SearchStrategies {

    public static void main(String[] args) {
        // Vi bygger en simpel graf:
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.addNeighbor(B);
        A.addNeighbor(C);
        A.addNeighbor(D);
        C.addNeighbor(E);
        // Hvad sker der hvis vi lade E have A som nabo?
       // E.addNeighbor(A);

        System.out.println("BFS starting...");
        Node foundBFS = searchBFS("F", A);
        if (foundBFS != null) {
            System.out.println("Found by BFS: " + foundBFS.getName());
        } else {
            System.out.println("Found nothing with BFS!");
        }

        System.out.println("DFS starting...");
        Node foundDFS = searchDFS("F", A);
        if (foundDFS != null) {
            System.out.println("Found by DFS: " + foundDFS.getName());
        } else {
            System.out.println("Found nothing with DFS!");
        }
    }


    public static Node searchBFS(String targetName, Node start) {

        // Opretter en queue (FIFO) til BFS
        Queue<Node> queue = new ArrayDeque<>();

        // Starter med at tilføje start-noden
        queue.add(start);

        // Så længe der stadig er elementer i køen
        while (!queue.isEmpty()) {

            // Printer hele køen (for at se rækkefølgen)
            System.out.print("Current queue: ");
            for (Node item : queue) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();

            // Fjerner første element i køen (FIFO)
            Node currentNode = queue.remove();

            // Tjekker om vi har fundet det vi leder efter
            if (currentNode.getName().equals(targetName)) {
                System.out.println("Finished searching!");
                return currentNode; // returnerer noden hvis fundet
            }

            // Hvis ikke fundet → tilføj alle naboer til køen
            // (det er her BFS går niveau for niveau)
            else queue.addAll(currentNode.getNeighbors());
        }

        // Hvis vi har gennemgået hele grafen uden at finde target
        return null;
    }

    public static Node searchDFS(String targetName, Node start) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {

            System.out.print("Current stack: ");
            for (Node item : stack) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();

            Node currentNode = stack.pop();

            if (currentNode.getName().equals(targetName)) {
                System.out.println("Finished searching!");
                return currentNode;
            } else {
                for (Node neighbor : currentNode.getNeighbors()) {
                    stack.push(neighbor);
                }
            }

        }

        return null;
    }



}
