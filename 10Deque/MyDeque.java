import java.util.*;

public class MyDeque{

    private String[] stack;
    private int start, last, size;
    private boolean aN;
    
    public MyDeque(){
	stack = new String[10];
	start = 0;
	last = 0;
	size = 0;
	aN = true;
    }

    public MyDeque(int capacity){
	stack = new String[capacity];
	start = 0;
	last = 0;
	size = 0;
    }

    public MyDeque(int capacity, boolean allow){
	stack = new String[capacity];
	start = 0;
	last = 0;
	size = 0;
	aN = allow;
    }

    public MyDeque(boolean allow){
	stack = new String[10];
	start = 0;
	last = 0;
	size = 0;
	aN = allow;
    }
    
    public void addFirst(String s){
	if (size == 0){
	    stack[0] = s;
	} else {
	    if (aN == false && s.equals("")){
		throw new NullPointerException();
	    }
	    if (wheresPrev() == -1){
		grow();
	    }
	    stack[wheresPrev()] = s;
	    start = wheresPrev();
	}
	size ++;
    }

    public void addLast(String s){
	if (size == 0){
	    stack[0] = s;
	} else {
	    if (aN == false && s.equals("")){
		throw new NullPointerException();
	    }
	    if (wheresNext() == -1){
		grow();
	    }
	    stack[wheresNext()] = s;
	    last = wheresNext();
	}
	size ++;
    }
    
    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String it = stack[start];
	if (size == 1){
	    start = 0;
	    last = 0;
	} else {
	    start = wStF();
	}
	size --;
	return it;
    }

    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String it = stack[last];
	if (size == 1){
	    start = 0;
	    last = 0;
	} else {
	    last = wStL();
	}
	size --;
	return it;
    }

    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String First = stack[start];
	return First;
    }

    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String Last = stack[last];
	return Last;
    }

    private int wheresNext(){
	if (last == stack.length - 1){
	    if (start == 0){
		return -1;
	    } else {
		return 0;
	    }
	} else {
	    if (last + 1 != start){
		return last + 1;
	    } else {
		return -1;
	    }
	}
    }

    private int wheresPrev(){
	if (start == 0){
	    if (last == stack.length - 1){
		return -1;
	    } else {
		return stack.length - 1;
	    }
	} else {
	    if (start - 1 != last){
		return start - 1;
	    } else {
		return -1;
	    }
	}
    }

    private int wStF(){
	if (start == stack.length - 1){
	    return 0;
	} else {
	    return start + 1;
	}   
    }

    private int wStL(){
	if (last == 0){
	    return stack.length - 1;
	} else {
	    return last - 1;
	}
    }
    
    private void grow(){
	String[] newArray = new String[stack.length * 2];
	for (int i = 0; i < stack.length; i ++){
	    newArray[i] = stack[(start + i) % stack.length];
	}
	stack = newArray;
	start = 0;
	last = size - 1;
    }

    public void push(String s){
	addLast(s);
    }

    public String pop(){
	return removeLast();
    }

    public String peek(){
	return getLast();
    }

    // private void printAll(){
    // 	System.out.print(start + " to " + last + " ");
    // 	for (String i : stack){
    // 	    System.out.print(i + ", ");
    // 	}
    // 	System.out.println("");
    // }

    // public static void main(String[] args){
    // 	MyDeque meh = new MyDeque(3);
    // 	meh.addFirst("Star");
    // 	meh.printAll();
    // 	meh.addLast("Butterfly");
    // 	meh.printAll();
    // 	meh.addFirst("Princess");
    // 	meh.printAll();
    // 	meh.addLast("Diaz");
    // 	meh.printAll();
    // 	meh.addFirst("The");
    // 	meh.printAll();
    // 	System.out.println(meh.removeFirst());
    // 	meh.printAll();
    // 	System.out.println(meh.getLast());
    // 	System.out.println(meh.removeLast());
    // 	meh.printAll();
    // 	System.out.println(meh.getFirst());
    // }
    
}   
