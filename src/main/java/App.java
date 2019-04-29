import graph.Graph;
import graph.exceptions.EmptyInputDataException;
import graph.exceptions.GraphAdjacencyInitException;
import graph.exceptions.GraphInitializationException;

public class App {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph
                    .Builder(4,4)
                    .append(new Comparable[]{0, 1, 0, 1})
                    .append(new Comparable[]{1, 0, 1, 0})
                    .append(new Comparable[]{0, 1, 0, 1})
                    .append(new Comparable[]{1, 0, 1, 0})
                    .asAdjacencyMatrix();
            System.out.println(graph);
        } catch (EmptyInputDataException | GraphAdjacencyInitException | GraphInitializationException exception) {
            exception.printStackTrace();
        }
    }
}
