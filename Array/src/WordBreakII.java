import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordBreakII {
	
	public static List<String> wordBreak(String s, List<String> wordDict, Map<String, LinkedList<String>> map) {
		if(s==null || s.length()==0) {
			return null;
		}
		return dfs(s, wordDict, map);
	}

	private static List<String> dfs(String s, List<String> wordDict, Map<String, LinkedList<String>> map) {
		if(map.containsKey(s)) {
			System.out.println("lol: "+map.get(s));
			return map.get(s);
		}
		LinkedList<String> res = new LinkedList<String>();
		if(s.length()==0) {
			res.add("");
			return res;
		}
		System.out.println();
		for(String word:wordDict) {
			System.out.println(word+ " ");
			if(s.startsWith(word)) {
				List<String> subList = dfs(s.substring(word.length()),wordDict,map);
				System.out.println("shreya"+subList.toString());
				for(String sub:subList) {
					res.add(word+ (sub.isEmpty()?"":" ")+sub);
				}
			}
		}
		map.put(s, res);
		for(String check:map.keySet()) {
			System.out.println("hupp: "+ check+ " " +check.toString()); 
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		//wordDict.addAll(Arrays.asList("A", "B", "C", "D", "E"));
		wordDict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		//String s = "BCD";
		String s = "catsanddog";
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		wordBreak(s, wordDict,map);
		for(String key:map.keySet()) {
			System.out.println("key"+key);
			for(String str:map.get(key)) {
				System.out.print("str: "+str+" ");
			}
			System.out.println();
		}
	}

}
