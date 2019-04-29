package graph.exceptions;

public class GraphAdjacencyInitException extends Exception {
    private static final StringBuilder ADJACENCY_INIT_ERROR =
            new StringBuilder(
                    "Error. Cannot define the graph due to it's not symmetrical or the size parameters are not equal."
            );

    public GraphAdjacencyInitException(){
        super(ADJACENCY_INIT_ERROR.toString());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
