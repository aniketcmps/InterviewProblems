package graph;

import java.util.LinkedList;

class Graph {
	int vertices;
	LinkedList<Integer> adj[];

	Graph(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
}