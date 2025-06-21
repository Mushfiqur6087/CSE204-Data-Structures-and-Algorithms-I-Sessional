package Graph;
import java.util.*;


public class Graph {
    public class Edge {
        int source;
        int destination;

        private Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public ArrayList<Edge>[] vertices;
    public int sourceVertex = 0;
    public int totalVertices;

    public Graph(int totalVertices) {
        vertices = new ArrayList[totalVertices];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new ArrayList<Edge>();
        }
        this.totalVertices = totalVertices;
    }

    public void setSource(int s) {
        this.sourceVertex = s;

    }

    public void addEdge(int src, int des) {
        Edge e = new Edge(src, des);
        vertices[src].add(e);
    }


    public String bfs()
    {
        StringBuffer str=new StringBuffer();
        str.append("BFS");

        boolean visited[] = new boolean[totalVertices];
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceVertex);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                if (vertices[curr].size() > 0) {
                    str.append(System.getProperty("line.separator"));
                    str.append(curr + "-> ");
                }
                visited[curr] = true;
                for (int i = 0; i < vertices[curr].size(); i++) {
                    Edge e = vertices[curr].get(i);
                    q.add(e.destination);
                    str.append(e.destination);
                    if (i < vertices[curr].size() - 1) {
                        str.append(",");
                    }
                }
            }
        }
        str.append(System.getProperty("line.separator"));
        return String.valueOf(str);
    }

    public StringBuffer dfs(int curr, boolean visited[],StringBuffer str)
    {
        if (visited[curr]) {
            return str;
        }
        if (vertices[curr].size() > 0) {
            str.append(System.getProperty("line.separator"));
            str.append(curr + "-> ");
        }
        for (int i = 0; i < vertices[curr].size(); i++) {
            Edge e = vertices[curr].get(i);
            str.append(e.destination);
            if (i < vertices[curr].size() - 1) {
                str.append(",");
            }
        }
        visited[curr] = true;
        for (int i = 0; i < vertices[curr].size(); i++) {
            Edge e = vertices[curr].get(i);
            dfs(e.destination, visited,str);
        }

       return str;
    }

    public String dfsRecursive()
    {
        StringBuffer str=new StringBuffer();
        str.append("DFS");
        return String.valueOf(dfs(sourceVertex,new boolean[totalVertices],str));
    }
}
