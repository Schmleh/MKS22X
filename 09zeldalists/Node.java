public class Node{

    private int value;
    private Node next;
    private Node previous;

    public Node(){
	value = 0;
	next = null;
	previous = null;
    }

    public Node(int number){
        value = number;
	next = null;
	previous = null;
    }

    public void linkNext(Node node){
        next = node;
    }

    public void linkPrev(Node node){
        previous = node;
    }

    public void set(int number){
	value = number;
    }

    public int get(){
	return value;
    }

}
