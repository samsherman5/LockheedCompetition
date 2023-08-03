import java.util.*;

public class MinDistance {
	public int minCostConnectPoints(int[][] points) {
		//Create a list of all the points
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		for (char i = 0; i < points.length; i++) {
			matrix.addNode(i);
		}

		//create edges between all nodes in the adjacency matrix, with the cost being the manhattan distance between the two points

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if(i!=j){
					matrix.addEdge((char)i, (char)j, Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
				}
			}
		}

		Set<Character> mstSet = new HashSet<>();
		Map<Character, Integer> keys = new HashMap<>();
		keys.put((char)0, 0);
		for (int i = 1; i < points.length; i++) {
			keys.put((char)i, Integer.MAX_VALUE);
		}

		PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(keys::get));
		queue.addAll(keys.keySet());
		while(!queue.isEmpty()){
			char point = queue.poll();
			mstSet.add(point);
			for (char neighbor : matrix.getEdges(point)) {
				if(queue.contains(neighbor) && matrix.findEdge(point, neighbor) < keys.get(neighbor)){
					keys.put(neighbor, matrix.findEdge(point, neighbor));
					queue.remove(neighbor);
					queue.add(neighbor);
				}
			}
		}

		//add up all the edges in the mst
		int sum = 0;
		for (char point : mstSet) {
			for (char neighbor : matrix.getEdges(point)) {
				if(mstSet.contains(neighbor)){
					sum += matrix.findEdge(point, neighbor);
				}
			}
		}
		return sum/2;
	}
}

class AdjacencyMatrix{
	public ArrayList<Character> nodes;
	public ArrayList<ArrayList<Integer>> edges;
	private final boolean directed;

	public AdjacencyMatrix(){
		this(false);
	}

	public AdjacencyMatrix(boolean directed){
		this.directed = directed;
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	public AdjacencyMatrix(int[][]am, boolean directed){
		this.directed = directed;
		this.nodes = new ArrayList<>();
		for (int i = 0; i < am.length; i++) {
			nodes.add(Integer.toString(i).charAt(0));
		}
		this.edges = new ArrayList<>();
		for (int i = 0; i < am.length; i++) {
			edges.add(new ArrayList<>());
			for (int j = 0; j < am.length; j++) {
				edges.get(i).add(am[i][j]);
			}
		}
	}

	public List<Character> getNodes(){
		return this.nodes;
	}

	public void addNode(Character c){
		if(nodes.contains(c)) return;
		nodes.add(c);
		edges.add(new ArrayList<>());
		for (int i = 0; i < edges.size(); i++) {
			edges.get(nodes.size()-1).add(-1);
		}
		for (int i = 0; i < edges.size()-1; i++) {
			edges.get(i).add(-1);
		}
	}

	public List<Character> getEdges(Character c){
		List<Character> out = new ArrayList<Character>();
		if(!nodes.contains(c)) return null;
		ArrayList<Integer> tem = edges.get(nodes.indexOf(c));
		for (int i = 0; i < tem.size(); i++) {
			if(!tem.get(i).equals(-1)) {
				out.add(nodes.get(i));
			}
		}
		return out;
	}

	public void addEdge(Character a, Character b, int cost){
		if(!nodes.contains(a) || !nodes.contains(b)) return;
		int i1 = nodes.indexOf(a);
		int i2 = nodes.indexOf(b);
		edges.get(i1).set(i2, cost);
		if(!directed)
			edges.get(i2).set(i1, cost);
	}

	public int findEdge(Character a, Character b){
		if(!nodes.contains(a) || !nodes.contains(b)) return -1;
		int i1 = nodes.indexOf(a);
		int i2 = nodes.indexOf(b);
		return edges.get(i1).get(i2);
	}
}
