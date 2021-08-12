import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class detectDirectedGraphCycle {
    static Graph graph = new Graph(4);
    static boolean dfsHelper(boolean[] visited, int[] parent, int s){
        visited[s] = true;

        Iterator<Integer> iterator = graph.adjacenyList[s].listIterator();
        while(iterator.hasNext()){
            int val = iterator.next();
            if(parent[s]!=-1){
                parent[val] = parent[s];
            }else{
                parent[val] = s;
            }
            if(parent[val]==val) return true;
            if(!visited[val]){
                boolean hasCycle =  dfsHelper(visited, parent, val);
                if(hasCycle) return true;
            }

        }
        return false;
    }

    static boolean dfs(){
        boolean[] visited = new boolean[graph.adjacenyList.length];
        int[] parent = new int[graph.adjacenyList.length];
        Arrays.fill(parent, -1);
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(dfsHelper(visited, parent, i)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        System.out.println(dfs());
    }
}
