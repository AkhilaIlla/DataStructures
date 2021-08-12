import java.util.LinkedList;

class Graph{
    int v;
    LinkedList<Integer> adjacenyList[];

    Graph(int v){
        this.v = v;
        adjacenyList = new LinkedList[v];
        for(int i =0; i<v; i++){
            adjacenyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int i, int j){
        adjacenyList[i].add(j);
    }
}

