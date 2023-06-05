//leetcode submission for NumberofProvinces 

//Uses Union by rank method

class Solution {

    //implement the find parent method

    int find(int parent[],int i)
    {
        //initially set parent to itself
        if(parent[i]==i){
            return i;
        }

        return find(parent,parent[i]);
    }
    // impelement the union & rank here

    void union(int parent[],int s, int d,int[] rank){
        
        s = find(parent,s);
        d = find(parent,d);
        
        //merge sets into each other by checking the parent's order

        if(s==d)
        return;
        
        //rank s is simply when rank[find(parent,s)] has a higher number than rank[find(parent,d)]
        if(rank[s] < rank[d]){
            //change the parent to D
            parent[s] = d;
        }
        
        //rank s is simply when rank[find(parent,d)] has a higher number than rank[find(parent,s)]
        else if(rank[s] > rank[d]){
            //change the parent to S
            parent[d] = s;
        }
        //same rank so set it to parent d
        else
        //change the parent to D
        parent[s] = d;

    }

    public int findCircleNum(int[][] isConnected) {
        //this is where it gets a little tricky

        //first find the length of the adjacenct matrix

        // the length is equal to the number of nodes

        int V = isConnected.length;
        int cntsets = 0;
        int [] parent = new int[V];
        
        int [] rank = new int[V];

        //initialize a singleton set, with all nodes rank=0
        for(int i =0;i<V;i++){
            parent[i] =i;
            rank[i]=0;
        }

         for(int i=0;i<V;i++){
         for(int j=0;j<V;j++) {
            //if we find a [....,1,1....,1...1] in the 
            //adjacency matrix start the union by rank method
           if(isConnected[i][j]==1){
               union(parent,i,j,rank);
           }
       }
         }

        //if parents are equal to the initial vertex we started upon
        //ofcourse with higher rank
        //then increase the set count 
       for(int i=0;i<V;i++){

           if(parent[i]==i){
               cntsets++;
           }
       }
       //now return the number of sets
       
       return cntsets;
    }
}
