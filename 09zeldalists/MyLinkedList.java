import java.util.*;

public class MyLinkedList implements Iterator<MyLinkedList>, Iterable<MyLinkedList>{

    private class Lnode{

	int value;
        Lnode next, prev;
	
	public Lnode(int number){
	    value = number;
	    next = null;
	    prev = null;
	}

	public Lnode(int number, Lnode node){
	    value = number;
	    next = node;
	    prev = null;
	}
	
	public Lnode(Lnode node, int number){
	    value = number;
	    next = null;
	    prev = node;
	}

	public Lnode(Lnode node, int number, Lnode noded){
	    value = number;
	    next = noded;
	    prev = node;
	}
	
    }

    public boolean removeNext = false;
    
    public boolean hasNext(){
        return size != 0;
    }
    
    public MyLinkedList next(){
	if (hasNext()){
	    removeNext = true;
	    return new MyLinkedList(start);
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    public void remove(){
	if (removeNext){
	    removeNext = false;
	    start = start.next;
	    size --;
	} else {
	    throw new IllegalStateException();
	}
    }

    public Iterator<MyLinkedList> iterator(){
	return this;
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

    public boolean add(int number){
	if (size == 0){
	    Lnode meh = new Lnode (number);
	    start = meh;
	    end = meh;
	    size ++;
	} else {
	    addAfter(end, number);
	}
	return true;
    }

    public boolean addFirst (int number){
	if (size == 0){
	    Lnode meh = new Lnode (number);
	    start = meh;
	    end = meh;
	    size ++;
	} else {
	    addBefore(start, number);
	}
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String s = "[";
        Lnode temmp = start;
	int c = 0;
    	while (c < size){
     	    s += temmp.value;
	    if (temmp != end){
		s += ", ";
	    }
     	    temmp = temmp.next;
	    c ++;
     	}
	s += "]";
	return s;
    }

    public int get(int index){
	return getNode(index).value;
    }

    public int set(int index, int nummber){
	Lnode meh = getNode(index);
	int namber = meh.value;
	meh.value = nummber;
	return namber;
    }
    
    public int indexOf(int number){
	try {
	    Lnode temmp = start;
	    int c = 0;
	    while (temmp.value != number){
		c ++;
		temmp = temmp.next;
	    }
	    return c;
	} catch (NullPointerException e){
	    return -1;
	}
    }
    
    public void add(int index, int number){
	if (index == 0){
	    if (size == 0){
		Lnode meh = new Lnode (number);
		start = meh;
		end = meh;
	    } else {
		addBefore(start, number);
	    }
	}else if (index == size){
	    addAfter(end, number);
	} else {
	    Lnode meh = getNode(index);
	    addBefore(meh, number);
	}
    }

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
	    int c = size - 1  - index;
	    while ((temmp != null) && (c > 0)){
		temmp = temmp.prev;
		c --;
	    }
	    return temmp;
	}
    }

    private void addBefore(Lnode meh, int value){
	try {
	    Lnode newone = new Lnode(meh.prev, value, meh);
	    newone.prev.next = newone;
	    newone.next.prev = newone;
	} catch (NullPointerException e){
	    Lnode newone = new Lnode(value, meh);
	    newone.next.prev = newone;
	    start = newone;
	}
	size ++;
    }

    private void addAfter(Lnode meh, int value){
	try {
	    Lnode newone = new Lnode(meh, value, meh.next);
	    newone.next.prev = newone;
	    newone.prev.next = newone;
	} catch (NullPointerException e){
	    Lnode newone = new Lnode(meh, value);
	    newone.prev.next = newone;
	    end = newone;
	}
	size ++;
    }

    public int remove(int index){
	Lnode meh = getNode(index);
	remove(meh);
	return meh.value;
    }
    
    private void remove(Lnode meh){
	if (meh == start && meh == end){
	    start = null;
	    end = null;
	} else if (meh == start){
	    meh.next.prev = null;
	    start = meh.next;
	} else if (meh == end){
	    meh.prev.next = null;
	    end = meh.prev;
	} else {
	    meh.prev.next = meh.next;
	    meh.next.prev = meh.prev;
	}
	size --;
    }
    
    public static void main(String[] args){
	// MyLinkedList one = new MyLinkedList();
	// one.add(5);
	// System.out.println(one.toString());
	// one.add(4);
	// System.out.println(one.toString());
	// one.add(3);
	// System.out.println(one.toString());
	// one.add(1,2);
	// System.out.println(one.toString());
	// one.add(2,1);
	// System.out.println(one.toString());
	// one.add(0,0);
	// System.out.println(one.toString());
	// one.addFirst(6);
	// System.out.println(one.toString());
	// one.addFirst(7);
	// System.out.println(one.toString());
	// System.out.println(one.get(0));
	// System.out.println(one.get(1));
	// System.out.println(one.get(2));
	// System.out.println(one.get(3));
	// System.out.println(one.get(4));
	// System.out.println(one.get(5));
	// System.out.println(one.get(6));
	// System.out.println(one.get(7));
	// one.set(0,8);
	// one.set(1,7);
	// one.set(2,6);
	// one.set(3,5);
	// one.set(4,4);
	// one.set(5,3);
	// one.set(6,2);
	// one.set(7,1);
	// System.out.println(one.toString());
	// System.out.println(one.indexOf(7));
	// System.out.println(one.indexOf(6));
	// System.out.println(one.indexOf(5));
	// System.out.println(one.indexOf(4));
	// System.out.println(one.indexOf(3));
	// System.out.println(one.indexOf(2));
	// System.out.println(one.indexOf(1));
	// System.out.println(one.indexOf(0));
	// System.out.println(one.remove(7));
	// System.out.println(one.toString());
	// System.out.println(one.remove(6));
	// System.out.println(one.toString());
	// System.out.println(one.remove(0));
	// System.out.println(one.toString());
	// System.out.println(one.remove(2));
	// System.out.println(one.toString());
	// System.out.println(one.remove(0));
	// System.out.println(one.toString());
    }
    
}

