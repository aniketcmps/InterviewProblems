package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it,
 * find the longest distances from s to all other vertices in the given graph.
 * O(V+E)
 */
class Edge {
	int v;
	int weight;

	Edge(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	public int getV() {
		return v;
	}

	public int getWeight() {
		return weight;
	}
}

class WGraph {
	int v;
	LinkedList<Edge> adj[];

	WGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(int u, int v, int w) {
		adj[u].add(new Edge(v, w));
	}

}

public class LongestPath {

	public void longestPath(WGraph g, int u) {
		boolean visited[] = new boolean[g.v];
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < g.v; i++) {
			if (!visited[i]) {
				topologicalSort(i, g, visited, s);
			}
		}

		int dist[] = new int[g.v];
		for (int i = 0; i < g.v; i++) {
			dist[i] = Integer.MIN_VALUE;
		}
		dist[u] = 0;

		while (!s.isEmpty()) {
			int n = s.pop();

			if (dist[n] != Integer.MIN_VALUE) {
				Iterator<Edge> i = g.adj[n].listIterator();
				while (i.hasNext()) {
					Edge v = i.next();
					if (dist[v.getV()] < dist[n] + v.getWeight()) {
						dist[v.getV()] = dist[n] + v.getWeight();
					}
				}
			}
		}

		System.out.println(" Distances of vertices from " + u + " are \n" + Arrays.toString(dist));
	}

	public void topologicalSort(int u, WGraph g, boolean visited[], Stack<Integer> s) {
		visited[u] = true;

		Iterator<Edge> i = g.adj[u].listIterator();
		while (i.hasNext()) {
			Edge t = i.next();
			if (!visited[t.getV()]) {
				topologicalSort(t.getV(), g, visited, s);
			}
		}
		s.push(u);
	}

	public static void main(String[] args) {
		WGraph g = new WGraph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		LongestPath l = new LongestPath();
		l.longestPath(g, 2);
	}

}
