package graph.exceptions;

public class EmptyInputDataException extends Exception {
    private static final StringBuilder NULL_INPUT_DATA =
            new StringBuilder(
                    "Error! Defining the graph with null height/width parameters."
            );

    public EmptyInputDataException(){
        super(NULL_INPUT_DATA.toString());
    }

    @Override
    public String toString() {
        return NULL_INPUT_DATA.toString();
    }
}
