import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {
  private int V;
  LinkedList[] adjacencyList;

  public DirectedGraph(int v) {
    V = v;
    adjacencyList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjacencyList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adjacencyList[u].add(v);
  }

  /**
   * Time Complexity: O(V+E)
   * where V is number of vertices in the graph and
   * E is number of edges in the graph.
   * @param s
   */
  public void bfs(int s) {
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    visited[s] = true;
    queue.add(s);
    while(!queue.isEmpty()) {
      s = queue.poll();
      System.out.print(s + " ");
      for (Object o : adjacencyList[s]) {
        int n = (int) o;
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public void dfs(int s) {
    boolean[] visited = new boolean[V];
    dfs(s, visited);
  }

  /**
   * Time Complexity: O(V+E)
   * where V is number of vertices in the graph and
   * E is number of edges in the graph.
   * @param s
   * @param visited
   */
  private void dfs(int s, boolean[] visited) {
    visited[s]  =true;
    System.out.print(s + " ");
    for (Object o : adjacencyList[s]) {
      int n = (int) o;
      if (!visited[n]) {
        dfs(n, visited);
      }
    }
  }

  /**
   * Time Complexity: O(V+E)
   * where V is number of vertices in the graph and
   * E is number of edges in the graph.
   */
  public boolean isCyclic() {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (isCyclic(i, visited, recStack)) {
        return true;
      }
    }
    return false;
  }

  private boolean isCyclic(int v, boolean[] visited, boolean[] recStack) {
    if (!visited[v]) {
      visited[v] = true;
      recStack[v] = true;
      for (Object o : adjacencyList[v]) {
        if (!visited[(int) o] && isCyclic((int) o, visited, recStack)) {
          return true;
        } else if (recStack[(int) o]) {
          return true;
        }
      }
    }
    recStack[v] = false;
    return false;

  }

  public void topologicalSort() {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topologicalSort(i, visited, stack);
      }
    }
    while(!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }

  private void topologicalSort(int v, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;
    for (Object o : adjacencyList[v]) {
      Integer i = (Integer) o;
      if (!visited[i]) {
        topologicalSort(i, visited, stack);
      }
    }
    stack.push(v);
  }

  public boolean isBipartite(Integer startNode) {
    if (startNode == null) {
      return false;
    }
    int[] color = new int[V];
    for (int i = 0; i < V; i++) {
      color[i] = -1;
    }
    color[startNode] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      for (Object o : adjacencyList[node]) {
        int i = (int) o;
        if (color[i] == -1) {
          color[i] = 1 + color[node];
          queue.add(i);
        } else if (color[i] == color[node]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    DirectedGraph directedGraph = new DirectedGraph(4);
    directedGraph.addEdge(0,1);
    directedGraph.addEdge(0,2);
    directedGraph.addEdge(1,2);
    directedGraph.addEdge(2,0);
    directedGraph.addEdge(2,3);
    directedGraph.addEdge(3,3);

    System.out.println("*******BFS traversal*******");
    directedGraph.bfs(2);
    System.out.println();
    directedGraph.bfs(1);
    System.out.println();
    directedGraph.bfs(0);

    System.out.println();
    System.out.println("*******DFS traversal*******");
    directedGraph.dfs(2);
    System.out.println();
    directedGraph.dfs(1);
    System.out.println();
    directedGraph.dfs(0);

    System.out.println();
    System.out.println("isCyclic = " + directedGraph.isCyclic());

    System.out.println();
    DirectedGraph graph = new DirectedGraph(6);
    graph.addEdge(5, 2);
    graph.addEdge(5, 0);
    graph.addEdge(4, 0);
    graph.addEdge(4, 1);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);
    System.out.println("******** Topological Sort********");
    graph.topologicalSort();
    System.out.println();
    System.out.println("isBipartite/two-colorable: " + graph.isBipartite(5));
  }
}

