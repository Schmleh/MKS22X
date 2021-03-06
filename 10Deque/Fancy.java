public class Fancy{

    public static double evaluate(String m){
	String[] terms = m.split(" ");
	MyDeque values = new MyDeque(terms.length);
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

    // public static void main(String[] args){
    // 	System.out.println(evaluate("2 3 -"));
    // 	System.out.println(evaluate("4 5 % 7 +"));
    // 	System.out.println(evaluate("0 1 2 3 * + +"));
    // 	System.out.println(evaluate("1 2 * 6 9 4 / * -"));
    // }
    
}
