package practice9;

public class GraphAdjMatrix implements Graph{

	private int[][] graph;
	private int size;
	
	//constructor
	public GraphAdjMatrix(int vertices) {
		this.graph = new int[vertices][vertices];
		this.size = vertices;
		
	}
	
	@Override
	public void addEdge(int v1, int v2) {
		//p8
	}

	@Override
	public void topologicalSort() {
		//p8
	}

	@Override
	public void addEdge(int v1, int v2, int weight) {
		graph[v1][v2] = weight;
		graph[v2][v1] = weight;
	}

	@Override
	public int getEdge(int v1, int v2) {
		return graph[v1][v2];
	}

	@Override
	public int createSpanningTree() {
		int[] cost = prim();
		int totalcost = 0;
		for(int i = 0; i < cost.length; i++) {
			totalcost += cost[i];
		}
		return totalcost;
	}
	
	private int[] prim() {
		int[] path = new int[size];
		int[] cost = new int[size];
		boolean[] known = new boolean[size];
		
		for(int i = 0; i < size; i++) {
			cost[i] = Integer.MAX_VALUE;
			known[i] = false;
		}
		
		cost[0] = 0;
		path[0] = -1;
		for(int i = 0; i < size - 1; i++) {
			int u = minIndex(cost, known);
			known[u] = true;
			for(int v = 0; v < size; v++) {
				if(graph[u][v] != 0 && known[v] == false && graph[u][v] < cost[v]) {
					path[v] = u;
					cost[v] = graph[u][v];
				}
			}
		}
		return cost;
	}
	
	public int minIndex(int key[], boolean known[]) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for (int i = 0; i < size; i++) {
			if (known[i] == false && key[i] < min) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

}
