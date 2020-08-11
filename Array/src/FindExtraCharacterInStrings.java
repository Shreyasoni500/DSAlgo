import java.util.HashMap;
import java.util.Map;

public class FindExtraCharacterInStrings {

	public static void main(String[] args) {
		String str1 = "Shreya";
		String str2 = "Shrweya";
		
		char ch = findOneExtraCharacter(str1,str2);
		System.out.print(ch+" ");
	}

	/*private static char findOneExtraCharacter(String str1, String str2) {
		if(str1==null || str2==null) {
			return '0';
		}
		int count[] = new int[256];
		for(char ch:str1.toCharArray()) {
			count[ch]++;
		}
		for(char ch:str2.toCharArray()) {
			count[ch]--;
		}
		for(int i=0;i<256;i++) {
			if(count[i]!=0) {
				//char res = (char)i;
				//System.out.print(res);
				return (char)i;
			}
		}
		return '0';
	}*/
	
	private static char findOneExtraCharacter(String str1, String str2) {
		if(str1==null || str2==null) {
			return '0';
		}
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(char ch:str1.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		for(char ch:str2.toCharArray()) {
			if(!map.containsKey(ch)) {
				return ch;
			} else {
				int count = map.get(ch);
				map.put(ch, --count);
			}
		}
		for(char ch:map.keySet()) {
			if(map.get(ch)!=0) {
				return ch;
			}
		}
		return '0';
	}
}
