import java.util.LinkedList;

/**Implementation of the Queue data structure for integers*/
public class Queue {
    private LinkedList<Integer> list;   // implementation uses linked list data structure
    public LinkedList<Integer> getList(){
        return this.list;
    }

    /**Constructor for the Queue class*/
    public Queue(){
        this.list = new LinkedList<Integer>();
    }

    /**Inserts a new integer to the rear of the queue
     * @param integer the integer to insert*/
    public void insert(int integer){
        getList().add(integer);
    }

    /**Removes the head of the queue and returns it
     * @return the element of the queue that occupied the head*/
    public int remove(){
        return getList().removeFirst();
    }

    /**Returns the head of the queue without removing it
     * @return the head of the queue*/
    public int peek(){
        return getList().getFirst();
    }

    /**Returns true if the queue is empty and false if it is not empty
     * @return whether the queue is empty*/
    public boolean isEmpty(){
        return getList().isEmpty();
    }
}
