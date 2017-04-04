public class MyLinkedList{

    private class Lnode{

	private int value;
	private Lnode next, prev;
	// private Node previous;
	
	private Lnode(int number){
	    value = number;
	    next = null;
	    prev = null;
	}

	private Lnode(int number, Lnode node){
	    value = number;
	    next = node;
	    prev = null;
	}
	
	private Lnode(Lnode node, int number){
	    value = number;
	    next = null;
	    prev = node;
	}

	private Lnode(Lnode node, int number, Lnode noded){
	    value = number;
	    next = noded;
	    prev = node;
	}
	
    }
    
    private Lnode start, end;
    private int size;
    
    public MyLinkedList(){
	Lnode start = null;
	int size = 0;
    }
    
    public MyLinkedList(Lnode node){
    	Lnode start = node;
	Lnode end = node;
        int s = 0;
        Lnode temmp = node;
    	while (temmp != null){
     	    s ++;
     	    temmp = temmp.next;
     	}
     	size = s;
    }

    public boolean addFirst (int number){
        addBefore(number, start);
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String s = "[";
        Lnode temmp = start;
    	while (temmp != null){
     	    s += temmp.value + ", ";
     	    temmp = temmp.next;
     	}
	s += "]";
	return s;
    }

    // public int get(int index){
    // 	if(index >= size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    //     LNode temmp = start;
    //     int c = index;
    // 	while (c >= 0 && (temmp != null)){
    // 	    temmp = temmp.next;
    // 	    c --;
    // 	}
    // 	return temmp.value;
    // }

    public int get(int index){
	return getNode(index).value;
    }

    // public int set(int index, int nummber){
    // 	if(index >= size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    //     LNode temmp = start;
    //     int c = index;
    // 	while (c >= 0 && (temmp != null)){
    // 	    temmp = temmp.next;
    // 	    c --;
    // 	}
    // 	int ret = temmp.value;
    // 	temmp.value = nummber;
    // 	return ret;
    // }

    public int set(int index, int nummber){
	Lnode meh = getNode(index);
	int namber = meh.value;
	meh.value = nummber;
	return namber;
    }

    public int indexOf(int number){
        Lnode temmp = start;
        int c = 0;
	while (temmp != null){
	    if (temmp.value == number){
		return c;
	    }
	    temmp = temmp.next;
	    c ++;
	}
	return -1;
    }

    // public void add(int index, int number){
    // 	if(index >= size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    //     LNode temmp = start;
    //     int c = index;
    // 	while ((temmp != null) && (c > 1)){
    // 	    temmp = temmp.next;
    // 	    c --;
    // 	}
    // 	Lnode adin = new Lnode(temmp, number, temmp.next);
    // 	temmp.next.prev = adin;
    // 	temmp.next = adin;
    // 	size ++;
    // }

    public void add(int index, int number){
	if (index == 0){
	    addBefore(number, start);
	} else {
	    Lnode meh = getNode(index - 1);
	    addAfter(number, meh);
	}
    }	    

    // public int remove(int index){
    // 	if(index >= size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    //     LNode temmp = start;
    //     int c = index;
    // 	while ((temmp != null) && (c > 0)){
    // 	    temmp = temmp.next;
    // 	    c --;
    // 	}
    // 	temmp.next.prev = temmp.prev;
    // 	temmp.prev.next = temmp.next;
    // 	size --;
    // 	return temmp.value;
    // }

    private Lnode getNode(int index){
	if(index >= size()){
     	    throw new IndexOutOfBoundsException();
     	}
	if(index < 0){
	    throw new IndexOutOfBoundsException();
     	}
	if(index < size / 2){
	    Lnode temmp = start;
	    int c = index;
	    while ((temmp != null) && (c > 0)){
		temmp = temmp.next;
		c --;
	    }
	    return temmp;
	} else {
	    Lnode temmp = end;
	    int c = index;
	    while ((temmp != null) && (c > 0)){
		temmp = temmp.prev;
		c --;
	    }
	    return temmp;
	}
    }


    private void addBefore(int value, Lnode meh){
	if (meh.prev == null){
	    Lnode newone = new Lnode(value, meh);
	    meh.prev = newone;
	    start = newone;
	} else {
	    Lnode newone = new Lnode(meh.prev, value, meh);
	    meh.prev.next = newone;
	    meh.prev = newone;
	}
	size ++;
    }

    private void addAfter(int value, Lnode meh){
	if (meh.next == null){
	    Lnode newone = new Lnode(meh, value);
	    meh.next = newone;
	    start = newone;
	} else {
	    Lnode newone = new Lnode(meh, value, meh.next);
	    meh.next.prev = newone;
	    meh.next = newone;
	}
	size ++;
    }

    public void remove(int index){
	Lnode meh = getNode(index);
	if (meh.prev == null){
	    meh.next.prev = null;
	    start = meh.next;
	} else if (meh.next == null){
	    meh.prev.next = null;
	    end = meh.prev;
	} else {
	    meh.prev.next = meh.next;
	    meh.next.prev = meh.prev;
	}
	size --;
    }

    public static void main(String[] args){
	MyLinkedList one = new MyLinkedList();
	one.add(0, 5);
	one.add(1, 4);
	one.add(2, 3);
	one.add(3, 2);
	one.add(4, 1);
	one.add(5, 1);
	one.remove(0);
	System.out.println(one.toString());
    }
    
}

