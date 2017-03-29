public class MyLinkedList{

    public class LNode{

	private int value;
	private LNode next;
	// private Node previous;
	
	private LNode(int number){
	    value = number;
	    next = null;
	    // previous = null;
	}

	private LNode(int number, LNode node){
	    value = number;
	    next = node;
	    // previous = null;
	}
	
    }
    
    private LNode start;
    private int size;
    
    public MyLinkedList(){
	LNode start = null;
	int size = 0;
    }
    
    public MyLinkedList(LNode node){
    	LNode start = node;
        int s = 0;
        LNode temmp = node;
    	while (temmp != null){
     	    s ++;
     	    temmp = temmp.next;
     	}
     	size = s;
    }

    public boolean add (int number){
	LNode Front = new LNode(number, start);
	start = Front;
	size ++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String s = "[";
        LNode temmp = start;
    	while (temmp != null){
     	    s += temmp.value + ", ";
     	    temmp = temmp.next;
     	}
	s += " ]";
	return s;
    }

    public int get(int index){
	if(index >= size()){
	    throw new IndexOutOfBoundsException();
	}
        LNode temmp = start;
        int c = index;
	while (c >= 0 && (temmp != null)){
	    temmp = temmp.next;
	}
	return temmp.value;
    }
	    
}
