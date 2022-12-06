import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; //Edges to neighbors
    private boolean visited; //True if visited
    private VertexInterface<T> previousVertex; //On path to this vertex
    private double cost; //Of path to this vertex

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    }

    protected class Edge
    {
        private VertexInterface<T> vertex; //Vertex at end of edge
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        }

        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        }

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        }

        protected double getWeight()
        {
            return weight;
        }
    }

    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {
        boolean result = false;
        if(!this.equals(endVertex))
        {
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicateEdge = false;
            while(!duplicateEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor))
                    duplicateEdge = true;
            }
            if(!duplicateEdge)
            {
                edgeList.add(new Edge(endVertex, edgeWeight));
                result = true;
            }
        }
        return result;
    }
    public boolean connect(VertexInterface<T> endVertex)
    {
        return connect(endVertex, 0);
    }

    public Iterator<VertexInterface<T>> getNeighborIterator()
    {
        return new NeighborIterator();
    }

    public boolean hasNeighbor()
    {
        return !edgeList.isEmpty();
    }

    public VertexInterface<T> getUnvisitedNeighbor()
    {
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while(neighbors.hasNext() && (result == null))
        {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if(!nextNeighbor.isVisited())
                result = nextNeighbor;
        }
        return result;
    }

    public boolean equals(Object other)
    {
        boolean result;
        if((other == null) || (getClass() != other.getClass()))
            result = false;
        else 
        {   //The case is safe within this else clause
            @SuppressWarnings("Unchecked")
            Vertex<T> otherVertex = (Vertex<T>)other;
            result = label.equals(otherVertex.label);
        }
        return result;
    }
}

private class NeighborIterator implements Iterator<VertexInterface<T>>
{
    private Iterator<Edge> edges;

    private NeighborIterator()
    {
        edges = edgeList.getIterator();
    }

    public boolean hasNext()
    {
        return edges.hasNext();
    }

    public VertexInterface<T> next()
    {
        VertexInterface<T> nextNeighbor = null;
        if(edges.hasNext())
        {
            Edge edgeToNextNeighbor = edges.next();
            nextNeighbor = edgeToNextNeighbor.getEndVertex();
        } else {
            throw new NoSuchElementException();
        }
        return nextNeighbor;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
