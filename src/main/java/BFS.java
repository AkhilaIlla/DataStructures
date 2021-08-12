import java.util.Iterator;
import java.util.LinkedList;


public class BFS {
    static Graph graph = new Graph(4);
    static void bfsHelper(boolean[] visited, LinkedList<Integer> queue){
        if(queue.size()<1) return;
        int s = queue.poll();
        System.out.print(s+" ");

        Iterator<Integer> iterator = graph.adjacenyList[s].listIterator();
        while(iterator.hasNext()){
            int val = iterator.next();
            if(!visited[val]){
                queue.add(val);
                visited[val] = true;
            }
        }

        bfsHelper(visited, queue);


    }
    static void bfs(int start){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.adjacenyList.length];
        visited[start] = true;
        queue.add(start);
        bfsHelper(visited, queue);

    }

    public static void main(String[] args) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        bfs(2);
    }
}