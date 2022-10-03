
class DijkstraShortestPath
{
    public static class Pair implements Comparable<Pair>{
        int v,wt;
        Pair(int v,int wt){
            this.v = v;
            this.wt =  wt;
        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(S,0));
        int[] sp = new int[V];
        Arrays.fill(sp,Integer.MAX_VALUE);
        sp[S] = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(visited[curr.v])continue;
            
            visited[curr.v] = true;
            
            for(ArrayList<Integer> e : adj.get(curr.v)){
                if(sp[e.get(0)] > sp[curr.v] + e.get(1)){
                    sp[e.get(0)] = sp[curr.v] + e.get(1);
                    pq.offer(new Pair(e.get(0),sp[e.get(0)]));
                }
            }
            
        }
        return sp;
        
    }
}
