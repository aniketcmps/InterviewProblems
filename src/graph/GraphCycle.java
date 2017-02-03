package graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class GraphCycle {
	public boolean directedCycle(Graph g) {
		boolean visiting[] = new boolean[g.vertices];
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
		for (int i = 0; i < visiting.length; i++) {
			if (!visiting[i]) {
				if (directedCycleRec(i, g, visiting, parent)) {
					return true;
				}
			}
		}
		return false;
	}

	public void printCycle(int s, Map<Integer, Integer> map, Graph g) {
		boolean visited[] = new boolean[g.vertices];
		System.out.print(s);
		while (map.get(s) != null && !visited[s]) {
			visited[s] = true;
			System.out.print("<--" + map.get(s));
			s = map.get(s);
		}
		System.out.println();
	}

	public boolean directedCycleRec(int s, Graph g, boolean visiting[], Map<Integer, Integer> map) {
		visiting[s] = true;
		Iterator<Integer> temp = g.adj[s].listIterator();
		while (temp.hasNext()) {
			int n = temp.next();
			map.put(n, s);
			if (!visiting[n]) {
				if (directedCycleRec(n, g, visiting, map)) {
					return true;
				}
			} else {
				printCycle(n, map, g);
				return true; // cycle detected
			}
		}
		visiting[s] = false;
		return false;
	}

	public static void main(String args[]) {
		GraphCycle gc = new GraphCycle();
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		if (gc.directedCycle(g)) {
			System.out.println("Cycle detected");
		} else {
			System.out.println(" No Cycle");
		}

	}
}