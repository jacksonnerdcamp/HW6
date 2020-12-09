import java.util.LinkedList;

/**A class that contains both depthFirst and breadthFirst traversal methods*/
public class Traverse {

    /**Algorithm to perform a depth-first traversal on a graph
     * @param dists an adjacency matrix detailing
     * @return the array describing the traversal.*/
    public static int[] depthFirst(boolean[][] dists){
        boolean[] visited = new boolean[dists.length];
        /*Used a linked list here instead of an array because the index responsible for adding
        * an element to the "back" of an array would not update independently to the recursive call.
        * On the other hand, a linked list can always attach a new element to its "back". */
        LinkedList<Integer> output = new LinkedList<>();

        myDepthFirst(dists, 0, visited, output);          // the first recursive call

        int[] finalOutput = new int[dists.length];
        int iterator = 0;
        for(Integer i:output){                              // converting the linked list into a int[]
            finalOutput[iterator] = i;
            iterator++;
        }

        return finalOutput;
    }

    /**The recursive method that updates the visited array and output LinkedList in depthFirst()
     * @param dists the input adjacency matrix
     * @param v the current vertex to be processed
     * @param visited the visited array from depthFirst()
     * @param output the linked list that will eventually be converted into the int[] finalOutput*/
    private static void myDepthFirst(boolean[][] dists, int v, boolean[] visited, LinkedList<Integer> output){
        visited[v] = true;
        output.addLast(v);    // places the vertex v at the end of the output

        for(int i = 0; i < dists[v].length; i++){   // for each of the possible neighbors of v
            if(dists[v][i] && !visited[i]){         // if the location is a neighbor of v and has not been visited
                myDepthFirst(dists, i, visited, output);   // recursive call on v's
                                                                                       // first available neighbor
            }
        }
    }


    /**Returns the order of breadth-first traversal for an adjacency matrix
     * @param dists the adjacency matrix to traverse
     * @return the order of traversal*/
    public static int[] breadthFirst(boolean[][] dists){
        boolean[] visited = new boolean[dists.length];      // an array indicating which landmarks have been visited
        int[] output = new int[dists.length];               // the output traversal array
        int outputIndex = 0;
        Queue q = new Queue();                              // the data structure that processes locations
        q.insert(0);
        visited[0] = true;

        while(!q.isEmpty()){        // if the queue is not empty there are still locations to visit
            int v = q.remove();
            output[outputIndex] = v;
            outputIndex++;

            for(int i = 0; i < dists[v].length; i++){   // for each of the possible neighbors of v
                if(dists[v][i] && !visited[i]){     // if the location is a neighbor of v and has not been visited
                    q.insert(i);
                    visited[i] = true;
                }
            }
        }
        return output;
    }
}
