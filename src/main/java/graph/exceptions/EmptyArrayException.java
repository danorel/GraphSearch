package graph.exceptions;

public class EmptyArrayException extends Exception {
    private static final StringBuilder EMPTY_ARRAY =
            new StringBuilder(
                    "Error! Defining the graph with empty input array data."
            );

    public EmptyArrayException(){
        super(EMPTY_ARRAY.toString());
    }

    @Override
    public String toString() {
        return EMPTY_ARRAY.toString();
    }
}
