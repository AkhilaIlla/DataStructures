import java.util.Iterator;

public class DFS {
    static Graph graph = new Graph(4);
    static void dfsHelper(boolean[] visited, int s){
        System.out.print(s+" ");
        visited[s] = true;

        Iterator<Integer> iterator = graph.adjacenyList[s].listIterator();
        while(iterator.hasNext()){
            int val = iterator.next();
            if(!visited[val]){
                dfsHelper(visited, val);
            }
        }
    }

    static void dfs(int start){
        boolean[] visited = new boolean[graph.adjacenyList.length];

        dfsHelper(visited, start);
    }

    public static void main(String[] args) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        dfs(2);
    }
}