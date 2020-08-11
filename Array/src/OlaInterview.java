import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OlaInterview {

	public static void main(String[] args) {
		//String str = "car1 car3 car3 car5 car1";
		String str = "dog cat cat fish";
		//String pattern = "addga";
		String pattern = "abba";
		if(isValid(str, pattern)) {
			System.out.print("true");
		} else {
			System.out.print("false");
		}
	}

	/*private static boolean isValid(String str, String pattern) {
		Map<Character, String> charMap = new HashMap<>();
		Map<String,Character> wordMap = new HashMap<>();
		String word[] = str.split(" ");
		for(int i=0;i<word.length;i++) {
			char ch = pattern.charAt(i);
			String w = word[i];
			if(!charMap.containsKey(ch)) {
				if(wordMap.containsKey(w)) {
					return false;
				} else {
					charMap.put(ch, w);
					wordMap.put(w, ch);
				}
			} else {
				String temp = charMap.get(ch);
				if(!temp.equals(w)) {
					return false;
				}
			}
		}
		return true;
	}*/
	
	private static boolean isValid(String str, String pattern) {
		Map map = new HashMap<>();
		String word[] = str.split(" ");
		for(int i=0;i<word.length;i++) {
			char ch = pattern.charAt(i);
			String w = word[i];
			if(!map.containsKey(ch)) {
				map.put(ch, i);
			}
			if(!map.containsKey(w)) {
				map.put(w, i);
			}
			if(map.get(ch)!=map.get(w)) {
				return false;
			}
		}
		return true;
	}

}
