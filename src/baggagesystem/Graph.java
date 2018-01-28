package baggagesystem;

import java.util.ArrayList;
import java.util.HashMap;

class Graph<V> {

	private HashMap<V, ArrayList<Edge<V>>> adjacencyList;

	/**
	 * This list holds all the vertices so that we can iterate over them in the
	 * toString function
	 */
	private ArrayList<V> vertexList;

	Graph() {
		adjacencyList = new HashMap<V, ArrayList<Edge<V>>>();
		vertexList = new ArrayList<V>();
	}

	private void add( V vertex, ArrayList<Edge<V>> connectedVertices ) {
		// Add the new vertex to the adjacencyList with it's list of connected
		// nodes
		adjacencyList.put(vertex, connectedVertices);
		vertexList.add(vertex);

			for (Edge<V> vertexConnectedToAddedVertex : connectedVertices) {
                ArrayList<Edge<V>> correspondingConnectedList = adjacencyList
                        .get(vertexConnectedToAddedVertex.getVertex());
                // The added vertex's connections might not be represented in
                // the Graph yet, so we implicitly add them
                if( correspondingConnectedList == null ) {
                    adjacencyList.put(vertexConnectedToAddedVertex.getVertex(),
                            new ArrayList<Edge<V>>());
                    vertexList.add(vertexConnectedToAddedVertex.getVertex());
                    correspondingConnectedList = adjacencyList
                            .get(vertexConnectedToAddedVertex.getVertex());
                }

                int weight = vertexConnectedToAddedVertex.getWeight();
                correspondingConnectedList.add(new Edge<V>(vertex, weight));
            }
		
	}

	void addEdge( V vertexOne, V vertexTwo, int weight ) {
		
		if (!adjacencyList.containsKey(vertexOne)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			tempList.add(new Edge<V>(vertexTwo, weight));
			add(vertexOne, tempList);
		}

		if (!adjacencyList.containsKey(vertexTwo)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			tempList.add(new Edge<V>(vertexOne, weight));
			add(vertexTwo, tempList);
		}

		adjacencyList.get(vertexOne).add(new Edge<V>(vertexTwo, weight));
		adjacencyList.get(vertexTwo).add(new Edge<V>(vertexOne, weight));
    }

	/**
	 * This method returns a list of all adjacent vertices of the give vertex without weight
	 * 
	 * @param vertex the source vertex 
	 * @return an array list containing the vertices
	 */
	ArrayList<V> getAdjacentVertices( V vertex ){
		ArrayList<V> returnList = new ArrayList<V>();
		for (Edge<V> edge : adjacencyList.get(vertex)) {
			returnList.add(edge.getVertex());
		}
		return returnList;
	}
	
	double getDistanceBetween( V source, V end ){
		 for (Edge<V> edge : adjacencyList.get(source)) {
			if (edge.getVertex() == end){
				return (double) edge.getWeight();
			}
		}
		return Double.POSITIVE_INFINITY;
	}
	
	ArrayList<V> getVertexList() {
		return vertexList;
	}
}
