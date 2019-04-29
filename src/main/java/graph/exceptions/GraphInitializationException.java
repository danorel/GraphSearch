package graph.exceptions;

public class GraphInitializationException extends Exception {
    private static final StringBuilder INIT_ERROR =
            new StringBuilder(
                    "Error! Cannot define the graph due to the enormous amount of input data"
            );

    public GraphInitializationException(){
        super(INIT_ERROR.toString());
    }

    @Override
    public String toString() {
        return INIT_ERROR.toString();
    }
}
