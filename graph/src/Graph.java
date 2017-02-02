import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Graph {
    Vertex[] vertices;
    public Graph(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        String graphType = sc.next();
        boolean isUndirected = true;
        if(graphType.equals("directed")) {
            isUndirected = false;
        }
        vertices = new Vertex[sc.nextInt()];
        for(int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(sc.next(), null);
        }
        while (sc.hasNext()) {
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
            vertices[v1].neighbor = new Neighbor(v2, vertices[v1].neighbor);
            if (isUndirected) {
                vertices[v2].neighbor = new Neighbor(v1, vertices[v2].neighbor);
            }
        }
    }

    private int indexForName(String name) {
        for(int i = 0; i < vertices.length; i++) {
            if (vertices[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i].name);
            for (Neighbor nbr = vertices[i].neighbor; nbr != null; nbr = nbr.next) {
                System.out.print(" --> " + vertices[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[vertices.length];
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                System.out.println("\n STARTING AT " + vertices[v].name);
                dfs(v, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("Visiting " + vertices[v].name);
        for (Neighbor nbr = vertices[v].neighbor; nbr != null; nbr = nbr.next) {
            if (!visited[v]) {
                System.out.println("\n" + vertices[v].name + "--" + vertices[nbr.vertexNum].name);
                dfs(v, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        Graph graph = new Graph(file);
        graph.print();
        graph.dfs();
        graph.bfs();
    }

    public void bfs() {
        boolean[] visited = new boolean[vertices.length];
        Queue<Integer> queue = new Queue<Integer>();
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                System.out.println("\nSTARTING AT " + vertices[i].name);
                queue.clear();
                bfs(i, visited, queue);
            }
        }

    }

    private void bfs(int start, boolean[] visited, Queue<Integer> queue) {
        visited[start] = true;
        System.out.println("visiting " + vertices[start].name);
        queue.enqueue(start);
        while(!queue.isEmpty()) {
            int v = queue.dequeue();
            for (Neighbor nbr = vertices[v].neighbor; nbr != null; nbr = nbr.next) {
                int vnum = nbr.vertexNum;
                if(!visited[vnum]) {
                    System.out.println("\n" + vertices[v].name + "--" + vertices[vnum].name);
                    visited[vnum] = true;
                    queue.enqueue(vnum);
                }
            }
        }

    }
}

class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vertexNum, Neighbor nbr) {
        this.vertexNum = vertexNum;
        next = nbr;
    }
}
class Vertex {
    String name;
    Neighbor neighbor;
    Vertex (String name, Neighbor neighbor) {
        this.name = name;
        this.neighbor = neighbor;
    }
}
