import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Edge implements Comparable<Edge> {
	private int firstnode;
	private int secondnode;
	private int weight;

	Edge(int firstnode, int secondnode, int weight) {
		this.firstnode = firstnode;
		this.secondnode = secondnode;
		this.weight = weight;
	}

	public int getFirstnode() {
		return firstnode;
	}

	public int getSecondnode() {
		return secondnode;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}

interface UndirectedGraph {
	public boolean isConnected();

	public List<Integer> reachable(int vertex);

	public List<Edge> mst();

	public List<Integer> shortestPath(int source, int destination);
}

class WeightedGraph implements UndirectedGraph {
	private List<Edge> edges;

	WeightedGraph(List<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * 
	 * @return all nodes in graph with visited status false
	 */
	private Map<Integer, Boolean> getVisited() {
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < edges.size(); i++) {
			if (!visited.containsKey(edges.get(i).getFirstnode())) {
				visited.put(edges.get(i).getFirstnode(), false);
			}
			if (!visited.containsKey(edges.get(i).getSecondnode())) {
				visited.put(edges.get(i).getSecondnode(), false);
			}
		}
		return visited;
	}

	/**
	 * Follow the DFS for connected node using stack
	 * 
	 * @param visited
	 *            contain the status of visited node
	 * @param stack
	 *            use for stack in DFS traverse
	 * @return updated status of visited
	 */
	private Map<Integer, Boolean> traverseDfs(Map<Integer, Boolean> visited,
			Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			int found = 0;
			for (int i = 0; i < edges.size(); i++) {
				if (stack.peek() == edges.get(i).getFirstnode()
						&& visited.get(edges.get(i).getSecondnode()) == false) {
					found = 1;
					stack.push(edges.get(i).getSecondnode());
					visited.replace(edges.get(i).getSecondnode(), true);
					break;
				} else if (stack.peek() == edges.get(i).getSecondnode()
						&& visited.get(edges.get(i).getFirstnode()) == false) {
					found = 1;
					stack.push(edges.get(i).getFirstnode());
					visited.replace(edges.get(i).getFirstnode(), true);
					break;
				}
			}
			if (found == 0) {
				stack.pop();
			}
		}
		return visited;
	}

	/**
	 * 
	 * @return parent of each vertex is -1
	 */
	private Map<Integer, Integer> getVertexParent() {
		Map<Integer, Integer> visited = new HashMap<>();
		for (int i = 0; i < edges.size(); i++) {
			if (!visited.containsKey(edges.get(i).getFirstnode())) {
				visited.put(edges.get(i).getFirstnode(), -1);
			}
			if (!visited.containsKey(edges.get(i).getSecondnode())) {
				visited.put(edges.get(i).getSecondnode(), -1);
			}
		}
		return visited;
	}

	/**
	 * Update the vertex parent of each vertex
	 * 
	 * @param vertexparent
	 *            show the parent vertex of each vertex
	 * @param edge
	 *            is node and their edge weight
	 * @param parent
	 *            represent top parent vertex
	 */
	private void changeParent(Map<Integer, Integer> vertexparent, Edge edge,
			int parent) {
		if (edge.getFirstnode() == parent) {
			for (Integer key : vertexparent.keySet()) {
				if (vertexparent.get(key) == edge.getSecondnode()) {
					vertexparent.put(key, parent);
				}
			}
			vertexparent.put(edge.getSecondnode(), parent);
		} else if (edge.getSecondnode() == parent) {
			for (Integer key : vertexparent.keySet()) {
				if (vertexparent.get(key) == edge.getFirstnode()) {
					vertexparent.put(key, parent);
				}
			}
			vertexparent.put(edge.getFirstnode(), parent);
		} else {
			for (Integer key : vertexparent.keySet()) {
				if (vertexparent.get(key) == edge.getSecondnode()) {
					vertexparent.put(key, edge.getFirstnode());
				}
			}
			vertexparent.put(edge.getSecondnode(), edge.getFirstnode());
		}
	}

	/**
	 * 
	 * @return distance of each node with max distance
	 */
	private Map<Integer, Integer> getDistance() {
		Map<Integer, Integer> distance = new HashMap<>();
		for (int i = 0; i < edges.size(); i++) {
			if (!distance.containsKey(edges.get(i).getFirstnode())) {
				distance.put(edges.get(i).getFirstnode(), Integer.MAX_VALUE);
			}
			if (!distance.containsKey(edges.get(i).getSecondnode())) {
				distance.put(edges.get(i).getSecondnode(), Integer.MAX_VALUE);
			}
		}
		return distance;
	}

	/**
	 * Check first and second vertex is connected
	 * 
	 * @param first
	 *            show first vertex
	 * @param second
	 *            show second vertex
	 * @return true if connected
	 */
	private boolean connected(int first, int second) {
		for (int i = 0; i < edges.size(); i++) {
			int firstvertex = edges.get(i).getFirstnode();
			int secondvertex = edges.get(i).getSecondnode();
			if ((first == firstvertex && second == secondvertex)
					|| (first == secondvertex && second == firstvertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Show the graph is connected or not using DFS
	 */
	@Override
	public boolean isConnected() {
		Map<Integer, Boolean> visited = getVisited();
		Stack<Integer> stack = new Stack<>();
		stack.push(edges.get(0).getFirstnode());
		visited.replace(edges.get(0).getFirstnode(), true);
		traverseDfs(visited, stack);
		for (int node : visited.keySet()) {
			if (!visited.get(node)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * return all reachable node from vertex
	 */
	@Override
	public List<Integer> reachable(int vertex) {
		Map<Integer, Boolean> visited = getVisited();
		List<Integer> connected = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(vertex);
		visited.replace(vertex, true);
		traverseDfs(visited, stack);
		for (int node : visited.keySet()) {
			if (visited.get(node) && node != vertex) {
				connected.add(node);
			}
		}
		return connected;
	}

	/**
	 * Find the minimum spanning tree
	 */
	@Override
	public List<Edge> mst() {
		List<Edge> minimum = new ArrayList<>();
		Collections.sort(edges);
		int parent = edges.get(0).getFirstnode();
		Map<Integer, Integer> vertexparent = getVertexParent();
		for (int i = 0; i < edges.size(); i++) {
			if (vertexparent.get(edges.get(i).getFirstnode()) == -1
					&& vertexparent.get(edges.get(i).getSecondnode()) == -1) {
				minimum.add(edges.get(i));
				changeParent(vertexparent, edges.get(i), parent);
			} else if (vertexparent.get(edges.get(i).getFirstnode()) == vertexparent
					.get(edges.get(i).getSecondnode())) {
				continue;
			} else if (vertexparent.get(edges.get(i).getFirstnode()) != -1
					&& vertexparent.get(edges.get(i).getSecondnode()) != -1) {
				changeParent(vertexparent, edges.get(i), parent);
			} else if (vertexparent.get(edges.get(i).getFirstnode()) == -1
					&& parent != edges.get(i).getFirstnode()) {
				minimum.add(edges.get(i));
				int p = vertexparent.get(edges.get(i).getSecondnode());
				for (Integer key : vertexparent.keySet()) {
					if (vertexparent.get(key) == edges.get(i).getFirstnode()) {
						vertexparent.put(key, p);
					}
				}
				vertexparent.put(edges.get(i).getFirstnode(), p);
			} else if (vertexparent.get(edges.get(i).getSecondnode()) == -1
					&& parent != edges.get(i).getSecondnode()) {
				minimum.add(edges.get(i));
				int p = vertexparent.get(edges.get(i).getFirstnode());
				for (Integer key : vertexparent.keySet()) {
					if (vertexparent.get(key) == edges.get(i).getSecondnode()) {
						vertexparent.put(key, p);
					}
				}
				vertexparent.put(edges.get(i).getSecondnode(), p);
			}
		}
		return minimum;
	}

	/**
	 * Find the shortest path of source to destination
	 */
	@Override
	public List<Integer> shortestPath(int source, int destination) {
		Map<Integer, Integer> distance = getDistance();
		Map<Integer, Boolean> visited = getVisited();
		List<Integer> path = new ArrayList<>();
		distance.replace(source, 0);
		int currentvertex = source;
		while (currentvertex != destination) {
			for (int i = 0; i < edges.size(); i++) {
				int first = edges.get(i).getFirstnode();
				int second = edges.get(i).getSecondnode();
				int weight = edges.get(i).getWeight();
				if (currentvertex == first && visited.get(second) == false) {
					if (distance.get(first) + weight < distance.get(second)) {
						distance.replace(second, distance.get(first) + weight);
					}
				} else if (currentvertex == second
						&& visited.get(first) == false) {
					if (distance.get(second) + weight < distance.get(first)) {
						distance.replace(first, distance.get(second) + weight);
					}
				}
			}
			path.add(currentvertex);
			distance.remove(currentvertex);
			visited.replace(currentvertex, true);
			int dis = Integer.MAX_VALUE;
			for (Integer key : distance.keySet()) {
				if (distance.get(key) <= dis && connected(key, currentvertex)) {
					dis = distance.get(key);
					currentvertex = key;
				}
			}

		}
		path.add(destination);
		return path;
	}

}

public class Graphs {
	public static void main(String... k) {
		/*
		 *     1--(8)--2--(7)--3 
		 *    /|       |\      | \ 
		 *  (4)|      (2)\     |  \ 
		 *  /  (11)    |  \   (14) (9)
		 * 0   |       8  (4)  |     \
		 *  \  |	  (6)   \  |      4
		 *  (8)| 	   |     \ |      /
		 *   `\|       |      \|    (10)
		 *     7--(1)--6--(2)--5---/
		 */
		List<Edge> l = new ArrayList<>();
		l.add(new Edge(0, 1, 4));
		l.add(new Edge(1, 2, 8));
		l.add(new Edge(0, 7, 8));
		l.add(new Edge(1, 7, 11));
		l.add(new Edge(7, 6, 1));
		l.add(new Edge(7, 8, 7));
		l.add(new Edge(2, 8, 2));
		l.add(new Edge(8, 6, 6));
		l.add(new Edge(2, 5, 4));
		l.add(new Edge(2, 3, 7));
		l.add(new Edge(6, 5, 2));
		l.add(new Edge(3, 5, 14));
		l.add(new Edge(3, 4, 9));
		l.add(new Edge(4, 5, 10));
		WeightedGraph w = new WeightedGraph(l);
		System.out.println(w.isConnected());
		List<Integer> connect = w.reachable(1);
		System.out.println(connect);
		List<Edge> mst = w.mst();
		for (int i = 0; i < mst.size(); i++) {
			System.out
					.println(mst.get(i).getFirstnode() + " "
							+ mst.get(i).getSecondnode() + " "
							+ mst.get(i).getWeight());
		}
		List<Integer> path = w.shortestPath(1, 2);
		System.out.println("shortest");
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + " ");
		}

	}

}
