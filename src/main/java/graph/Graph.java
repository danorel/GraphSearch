package graph;

import graph.consistsOf.DoublyLinkedList;
import graph.exceptions.EmptyInputDataException;
import graph.exceptions.GraphAdjacencyInitException;
import graph.exceptions.GraphInitializationException;

import java.io.Serializable;
import java.util.ArrayList;

public class Graph<T extends Comparable> implements Serializable, Cloneable {

    private enum Type{ ADJACENCY, INCIDENCE }

    private ArrayList<DoublyLinkedList<T>> graph;

    private Graph(Comparable[][] source, String type){
        graph = new ArrayList<>();
        if(Type.ADJACENCY.equals(type)){
            asAdjacency(source);
        } else {
            asIncidence(source);
        }
    }

    private void asAdjacency(Comparable[][] source){
        for(int outer = 0; outer < source.length; outer++){
            DoublyLinkedList<T> row = new DoublyLinkedList<>();
            for(int inner = 0; inner < source[0].length; inner++){
                if(outer != inner){
                    if(equals(source[outer][inner], 1)){
                        row.add((T) source[outer][inner]);
                    }
                }
            }
            graph.add(row);
        }
    }

    private void asIncidence(Comparable[][] source){

    }

    public static class Builder<T extends Comparable>{
        private Comparable[][] source = null;
        private int width;
        private int height;
        private int currentRow = 0;

        public Builder(int width, int height) throws EmptyInputDataException {
            if(width != 0 && height != 0){
                this.width = width;
                this.height = height;
                source = new Comparable[width][height];
            } else {
                throw new EmptyInputDataException();
            }
        }

        public Builder(T [][]source) throws EmptyInputDataException {
            if(source.length > 0){
                this.width = source.length;
                this.height = source[0].length;
                this.source = source;
            } else {
                throw new EmptyInputDataException();
            }
        }

        public Builder append(Comparable[] row) throws GraphInitializationException {
            if(row.length > width){
                throw new GraphInitializationException();
            } else {
                System.arraycopy(row, 0, source[currentRow], 0, row.length);
                currentRow++;
                return this;
            }
        }

        public Graph<Comparable> asAdjacencyMatrix() throws GraphAdjacencyInitException {
            if(isValidAdjacencyMatrix(source)){
                return new Graph<>(source, "ADJACENCY");
            } else {
                throw new GraphAdjacencyInitException();
            }
        }

        private boolean isValidAdjacencyMatrix(Comparable[][] source){
            if(this.width != this.height){
                return false;
            }
            /*
                Symmetry check,
                if the data in the input source is symmetric
                then return true, else - false
             */
            for(int outer = 0; outer < source.length; outer++){
                for(int inner = 0; inner < source[0].length; inner++){
                    if(outer >= inner){
                        if(!equals(source[outer][inner], source[inner][outer])){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private boolean equals(Comparable first, Comparable second){
            return first.compareTo(second) == 0;
        }

        public Graph<Comparable> asIncidenceMatrix(){
            return new Graph<>(source, "INCIDENCE");
        }
    }

    private boolean equals(Comparable first, Comparable second){
        return first.compareTo(second) == 0;
    }

    public Graph<T> clone(Graph<T> graph) throws CloneNotSupportedException {
        return (Graph<T>) clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder graph = new StringBuilder();
        for(int index = 0; index < this.graph.size(); index++){
            graph
                    .append(
                        display(this.graph.get(index))
                    )
                    .append("\n");
        }
        return this.graph.toString();
    }

    private String display(DoublyLinkedList<T> dll){
        return dll.toString();
    }
}
