import java.util.Iterator;
import java.util.Queue;
import java.util.PriorityQueue;

//pg 1104

public class DirectedGraph<T> implements GraphInterface<T> {
    private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public DirectedGraph()
    {
        vertices = new LinkedDictionary<>();
        edgeCount = 0;       
    }

    @Override
    public boolean addVertex(T vertexLabel) 
    {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    public boolean addEdge(T begin, T end, double edgeWeight) 
    {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if((beginVertex != null) && (endVertex != null)) {
            result = beginVertex.connect(endVertex, edgeWeight);
        }
        if(result) {
            edgeCount++;
        }
        return result;
    }

    public boolean addEdge(T begin, T end) 
    {
        return addEdge(begin, end, 0);
    }

    public boolean hasEdge(T begin, T end) 
    {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if((beginVertex != null) && (endVertex != null))
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while(!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor))
                    found = true;
            }
        }
        return found;
    }

    public boolean isEmpty() 
    {
        return vertices.isEmpty();
    }

    public int getNumberOfVertices() 
    {
        return vertices.getSize();
    }

    public int getNumberOfEdges() 
    {
        return edgeCount;
    }

    public void clear() 
    {
        vertices.clear();
        edgeCount = 0;
    }

    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while(vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    public QueueInterface<T> getBreadthFirstTraversal(T origin) 
    {
        // Will not be implemented
        return null;
    }

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        // Will not be implemented
        return null;
    }

    public StackInterface<T> getTopologicalOrder() 
    {
        // Will not be implemented
        return null;
    }

    public int getShortestPath(T begin, T end, StackInterface<T> path) 
    {
        resetVertices();
        boolean done = false;
        QueueInterface<VertexInterface<T>> vertexQueue = new Queue<>();
        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        originVertex.visit();
        vertexQueue.enqueue(originVertex);
        while(!done && !vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while(!done && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    nextNeighbor.setCost(1 + frontVertex.getCost());
                    nextNeighbor.setPredecessor(frontVertex);
                    vertexQueue.enqueue(nextNeighbor);
                }
                if(nextNeighbor.equals(endVertex))
                    done = true;
            }
        }
        int pathLength = (int)endVertex.getCost();
        path.push(endVertex.getLabel());
        VertexInterface<T> vertex = endVertex;
        while(vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }
        return pathLength;
    }

    //https://github.com/marat00/Java/blob/master/LabX/DirectedGraph.java
    public double getCheapestPath(T begin, T end, StackInterface<T> path) {
        boolean done = false;
        PriorityQueue<T> priQueue = new PriorityQueue<>();
        priQueue.add(new Entry(originVertex, 0, null));
        return pathCost;
    }
}

//pg 1104
//pg 1106
