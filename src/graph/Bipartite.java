package graph;

import java.util.Iterator;
import java.util.LinkedList;

class Bipartite {
	public boolean isbipartite(Graph g, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int color[] = new int[g.vertices];

		for (int i = 0; i < g.vertices; i++) {
			color[i] = -1;
		}

		int c = 0;
		queue.add(s);
		color[s] = c++;
		while (queue.size() != 0) {
			int n = queue.poll();
			Iterator<Integer> i = g.adj[n].listIterator();
			while (i.hasNext()) {
				int x = i.next();
				if (color[x] == c) {
					if (color[n] == c) {
						return false;
					}
				} else if (color[x] == -1) {
					color[x] = c;
					queue.add(x);
				}
			}
			c++;
			if (c == 2) {
				c = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(1, 0);

		Bipartite b = new Bipartite();
		if (b.isbipartite(g, 0)) {
			System.out.println("The graph is Bipartite");
		} else {
			System.out.println("The graph is not Bipartite");
		}

	}

}
