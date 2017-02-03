package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Traverse {
	/**
	 * Breadth First Search approach to traverse through graph
	 */
	public void bfs(int s, Graph g) {
		boolean visited[] = new boolean[g.vertices];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> temp = g.adj[s].listIterator();

			while (temp.hasNext()) {
				int n = temp.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	/**
	 * Depth First Search approach to traverse through graph
	 */
	public void dfs(int s, Graph g) {
		boolean visited[] = new boolean[g.vertices];
		dfsRec(s, visited, g);
	}

	// Recursive function for DFS
	public void dfsRec(int s, boolean visited[], Graph g) {
		visited[s] = true;
		System.out.print(s + " ");
		Iterator<Integer> i = g.adj[s].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				dfsRec(n, visited, g);
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/topological-sorting/
	 * 
	 */
	public void topologicalSort(Graph g) {
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[g.vertices];
		for (int i = 0; i < g.vertices; i++) {
			if (!visited[i]) {
				topologicalRec(i, g, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	// Recursive function for topological sort
	public void topologicalRec(int s, Graph g, boolean visited[], Stack<Integer> stack) {
		visited[s] = true;
		Iterator<Integer> i = g.adj[s].listIterator();

		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				topologicalRec(n, g, visited, stack);
			}
		}

		stack.push(s);
	}

	public static void main(String args[]) {
		Traverse t = new Traverse();
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		// System.out.println("Breadth First Traversal " + "(starting from
		// vertex 2)");
		// t.bfs(2, g);
		// System.out.println();
		// System.out.println("Depth First Traversal " + "(starting from vertex
		// 2)");
		// t.dfs(2, g);

		Graph g1 = new Graph(6);
		g1.addEdge(5, 2);
		g1.addEdge(5, 0);
		g1.addEdge(4, 0);
		g1.addEdge(4, 1);
		g1.addEdge(2, 3);
		g1.addEdge(3, 1);
		System.out.println("Following is a Topological sort of the given graph");
		t.topologicalSort(g1);
	}
}