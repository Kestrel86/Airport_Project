import java.util.Stack; //ask teacher about this
import java.util.Queue;

public interface GraphAlgorithmsInterface<T> {
    public Queue<T> getBreadthFirstTraversal(T origin);

    public Queue<T> getDepthFirstTraversal(T origin);

    public Stack<T> getTopologicalOrder();

    public int getShortestPath(T begin, T end, Stack<T> path);

    public double getCheapestPath(T begin, T end, Stack<T> path); //only one needed
}

//pg 1081