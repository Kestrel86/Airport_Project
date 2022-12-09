//
//  Name:   Valdez, Andrew
//  Project:   Project #5
//  Due:    12/9/22
//  Course: CS-2400-02-f22
//
//  Description:
//  Designed to define all methods in the Graph Interface. 
//  Creates a directed graph that will be able to use the methods defined in this file.
//

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Map;


public class DirectedGraph<T> implements GraphInterface<T> 
{
    private Map<T, VertexInterface<T>> vertices;
    private int edgeCount;

    /**
     * Initializes vertices and edgeCount, creating Graph
     */
    public DirectedGraph()
    {
        vertices = new LinkedHashMap<>(); 
        edgeCount = 0;       
    }

    public boolean addVertex(T vertexLabel) 
    {
        VertexInterface<T> addOutcome = vertices.put(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    public boolean addEdge(T begin, T end, double edgeWeight) 
    {
        boolean result = false;
        boolean remove = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if((beginVertex != null) && (endVertex != null)) {
            if(edgeWeight == 0)
            {
                remove = beginVertex.connect(endVertex, edgeWeight);
            } else {
                result = beginVertex.connect(endVertex, edgeWeight);
            }
        }
        if(result) {
            edgeCount++;
        } else if(remove) {
            edgeCount--;
            return remove;
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
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
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
        return vertices.size();
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
        Iterator<VertexInterface<T>> vertexIterator = vertices.values().iterator();
        while(vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    public Queue<T> getBreadthFirstTraversal(T origin) 
    {
        // Will not be implemented
        throw new RuntimeException("Method not fully implemented");    
    }

    public Queue<T> getDepthFirstTraversal(T origin) 
    {
        // Will not be implemented
        throw new RuntimeException("Method not fully implemented");    
    }

    public Stack<T> getTopologicalOrder() 
    {
        // Will not be implemented
        throw new RuntimeException("Method not fully implemented");    
    }

    public int getShortestPath(T begin, T end, Stack<T> path) 
    {
        //Will not be implemented
        throw new RuntimeException("Method not fully implemented");
    }

    public double getCheapestPath(T begin, T end, Stack<T> path) {
        resetVertices();
        boolean done = false;
        PriorityQueue<EntryPQ> priQueue = new PriorityQueue<>();

        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        priQueue.add(new EntryPQ(originVertex, 0, null));

        while(!done && !priQueue.isEmpty())
        {
            EntryPQ frontEntry = priQueue.remove();
            VertexInterface<T> frontVertex = frontEntry.getVertex();

            if(!frontVertex.isVisited())
            {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.getCost());
                frontVertex.setPredecessor(frontEntry.getPredecessor());

                if(frontVertex.equals(endVertex)) {
                    done = true;
                } else {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edgeWeights = frontVertex.getWeightIterator();
                    while(neighbors.hasNext())
                    {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        Double weightOfEdgeToNeighbor = edgeWeights.next();

                        if(!nextNeighbor.isVisited())
                        {
                            double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
                            priQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                        }
                    }
                }
            }
        }
        double pathCost = endVertex.getCost();
        path.push(endVertex.getLabel());

        VertexInterface<T> vertex = endVertex;
        while(vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }
        return pathCost;
    }

    private class EntryPQ implements Comparable<EntryPQ>, java.io.Serializable
	{
		private VertexInterface<T> vertex; 	
		private VertexInterface<T> previousVertex; 
		private double cost; // cost to nextVertex
		
		private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex)
		{
			this.vertex = vertex;
			this.previousVertex = previousVertex;
			this.cost = cost;
		} // end constructor
		
		public VertexInterface<T> getVertex()
		{
			return vertex;
		} // end getVertex
		
		public VertexInterface<T> getPredecessor()
		{
			return previousVertex;
		} // end getPredecessor

		public double getCost()
		{
			return cost;
		} // end getCost
		
		public int compareTo(EntryPQ otherEntry)
		{
			// using opposite of reality since our priority queue uses a maxHeap;
			// could revise using a minheap
			return (int)Math.signum(otherEntry.cost - cost);
		} // end compareTo
		
		public String toString()
		{
			return vertex.toString() + " " + cost;
		} // end toString 
	} // end EntryPQ
}

