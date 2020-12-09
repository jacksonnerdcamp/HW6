/**Created a heap class but opted to use a different method of searching for the minimum value in the prim's algorithm*/
public class IntHeap{
    // fields
    private int[] items;
    private int maxItems;
    private int numItems;

    //getters and setters
    public int[] getItems(){return this.items;}
    public void setItem(int index, int item){
        this.items[index] = item;
    }
    public void setItems(int[] arr){
        this.items = arr;
        this.numItems = arr.length;
    }
    public int getMaxItems(){return this.maxItems;}
    public int getNumItems(){return this.numItems;}
    public void incrementNumItems(int increment){this.numItems += increment;}

    /**IntHeap constructor
     * @param maxSize the maximum size of the items array*/
    public IntHeap(int maxSize){
        items = new int[maxSize];
        maxItems = maxSize;
        numItems = 0;
    }

    /**Algorithm to sift a particular index down
     * @param i the index to sift down*/
    public void siftDown(int i){
        int toSift = getItems()[i];
        int parent = i;
        int child = 2 * parent + 1; // start with the left child
        while(child < getNumItems()){
            if(child + 1 < getNumItems()   // if RIGHT child exists
                && getItems()[child] > getItems()[child + 1]){  // and RIGHT < LEFT
                child = child + 1;  // take the right child
            }
            if(toSift <= getItems()[child]){
                break;
            }

            // Sift down one level of the tree
            setItem(parent, getItems()[child]);
            setItem(child, toSift);
            parent = child;
            child = 2 * parent + 1;
        }
    }

    /**Removes the top item of the min-at-top heap in constant time
     * @return the minimum item*/
    public int removeMin(){
        int toRemove = getItems()[0];
        setItem(0, getItems()[getNumItems() - 1]);
        incrementNumItems(-1);
        siftDown(0);
        return toRemove;
    }

    /**Builds the heap efficiently
     * @param array the unheapified array*/
    public void buildHeap(int[] array){
        setItems(array);
        for(int i = (getNumItems() - 2)/2; i >=0; i--){
            siftDown(i);
        }
    }

    /**Prints the heap in its array format*/
    public void printHeap(){
        int[] heap = getItems();
        for(int i : heap){
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args){
        IntHeap heap = new IntHeap(10);
        heap.buildHeap(new int[]{6,3,11,7,14,8,5,15,1,2});
    }
}
