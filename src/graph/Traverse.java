package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Traverse {
	public void bfs(int s, Graph g) {
		boolean visited[] = new boolean[g.vertices];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size()!=0) {
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> temp = g.adj[s].listIterator();
			
			while (temp.hasNext()) {
				int n = temp.next();
				if (!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}

	public void dfs(int s,Graph g){
		boolean visited[]=new boolean[g.vertices];
		dfsRec(s, visited, g);
	}
	
	public void dfsRec(int s, boolean visited[], Graph g){
		visited[s]=true;
		System.out.print(s+" ");
		Iterator<Integer> i=g.adj[s].listIterator();
		while(i.hasNext()){
			int n=i.next();
			if(!visited[n]){
				dfsRec(n,visited,g);
			}
		}
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

		System.out.println("Breadth First Traversal " + "(starting from vertex 2)");
		t.bfs(2, g);
		System.out.println();
		System.out.println("Depth First Traversal " + "(starting from vertex 2)");
		t.dfs(2, g);
	}
}