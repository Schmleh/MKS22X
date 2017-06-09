import java.util.*;

public class StackCalc{

    public static double eval(String m){
	String[] terms = m.split(" ");
	Stack<String> values = new Stack<String>();
	for (String term : terms){
	    if (isOp(term)){
		values.push(apply(term, values.pop(), values.pop()));
	    } else {
		values.push(term);
	    }
	}
	return Double.parseDouble(values.pop());
    }

    public static boolean isOp(String op){
	if (op.equals("+")){
	    return true;
	}
	if (op.equals("-")){
	    return true;
	}
	if (op.equals("*")){
	    return true;
	}
	if (op.equals("/")){
	    return true;
	}
	if (op.equals("%")){
	    return true;
	}
	return false;
    }

    public static String apply(String op, String s, String f){
	if (op.equals("+")){
	    return "" + (Double.parseDouble(f) + Double.parseDouble(s));
	}
	if (op.equals("-")){
	    return "" + (Double.parseDouble(f) - Double.parseDouble(s));
	}
	if (op.equals("*")){
	    return "" + (Double.parseDouble(f) * Double.parseDouble(s));
	}
	if (op.equals("/")){
	    return "" + (Double.parseDouble(f) / Double.parseDouble(s));
	}
	else {
	    return "" + (Double.parseDouble(f) % Double.parseDouble(s));
	}
    }
    
}
