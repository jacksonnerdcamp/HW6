public class Runner {
    public static void main(String[] args){
        boolean[][] example = new boolean[][]{
                {false, true, false, true},
                {true, false, true, false},
                {false, true, false, false},
                {true, false, false, false}};

        boolean[][] example2 = new boolean[][]{
                {false, true},
                {true, false}};

        boolean[][] example3 = new boolean[][]{{false}};

        boolean[][] example4 = new boolean[][]{
                {false, true, false, false, true},
                {true, false, true, true, true},
                {false, true, false, true, false},
                {false, true, true, false, true},
                {true, true, false, true, false}
        };


        printArr(Traverse.depthFirst(example4));         // prints the depth first traversal
        printArr(Traverse.breadthFirst(example4));       // prints the breadth first traversal

        // On to testing part II
        ///////////////////////////////////////////////////////////////////////////////////////
        int[][] given = new int[][]{
                {0,1,2,6},
                {1,0,3,4},
                {2,3,0,3},
                {6,4,3,0}
        };

        int[][] given2 = new int[][]{
                {0,3,-1,7,8},
                {3,0,1,4,-1},
                {-1,1,0,2,3},
                {7,4,2,0,3},
                {8,-1,3,3,0}
        };

        int[][] given3 = new int[][]{
                {0,7,0,0,0,8},
                {7,0,6,0,0,3},
                {0,6,0,5,2,4},
                {0,0,5,0,2,0},
                {0,0,2,2,0,3},
                {8,3,4,0,3,0}
        };

        System.out.print(ShortestPath.minDistance(given3));
    }

    /**Method to visualize int arrays
     * @param arr the array to be printed to console*/
    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println();
    }
}
