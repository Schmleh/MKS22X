import java.util.*;
public class Quiz2Redux{  

    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words, s, 0, "", true);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s, int i, String w, boolean doadd){
	if (i < s.length()){
	    if (doadd) {
		words.add(w);
	    }
	    help(words, s, i + 1, w + s.charAt(i), true);
	    help(words, s, i + 1, w, false);
	}
	if (words.indexOf(w) == -1){
	    words.add(w);
	}
    }
}
