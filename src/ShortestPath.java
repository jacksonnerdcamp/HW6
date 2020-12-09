/**Class containing the minDistance static method*/
public class ShortestPath {
    /**Method that finds the minimum spanning tree of an input adjacency matrix
     * @param dists the adjacency matrix that represents a graph.
     * @return the minimum total distance of N-1 nodes
     **/
    public static int minDistance(int[][] dists){
        // initialization
        int[] A = new int[dists.length];    // the traversal of the minimum spanning tree
        A[0] = 0;
        int Aindex = 1;

        int[] C = new int[dists.length];    // the current cost estimates to connect vertices to A
        int[] p = new int[dists.length];    // predecessor node along path frm source to v
        boolean[] containedInA = new boolean[A.length];     // search for an item in A with O(1) complexity
        containedInA[0] = true;

        // filling the C array
        for(int v = 1; v < dists.length; v++){      // for all vertices in the graph except vertex zero
            if(dists[v][0] > 0){                    // if the vertex is a neighbor of zero
                C[v] = dists[v][0];                 // set the cost estimate to the distance between the nodes
                p[v] = 0;   // set the parent of i to zero
            }
            else{
                C[v] = Integer.MAX_VALUE;      // the value of MAX_VALUE represents a cost estimate of INFINITY
            }
        }


        // The main loop of the algorithm
        while(Aindex < dists.length){   // while A does not contain every section
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            // find w not in A such that C[w] is a min
            for(int vertex = 0; vertex < C.length; vertex++){
                if(!containedInA[vertex] && C[vertex] < min){     // if the vertex is not contained in A and
                    min = C[vertex];                              // the estimated cost is less than min estimated cost
                    minIndex = vertex;
                }
            }

            A[Aindex] = minIndex;           // adding a vertex to MST
            Aindex++;
            containedInA[minIndex] = true;


            // update C[v] for all v adjacent to minIndex and not in A
            for(int v = 0; v < dists[minIndex].length; v++){
                if(dists[v][minIndex] > 0 && !containedInA[v]){     // if v and minIndex are neighbors and v is not in A
                    if(dists[minIndex][v] < C[v]){
                        C[v] = dists[minIndex][v];
                        p[v] = minIndex;
                    }
                }
            }

        }

        // obtaining the
        int outputSum = 0;
        for(int i : C){
            outputSum += i;
        }

        return outputSum;
    }
}
