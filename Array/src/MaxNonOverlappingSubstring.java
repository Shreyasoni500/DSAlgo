import java.util.ArrayList;
import java.util.List;

public class MaxNonOverlappingSubstring {

	public static void main(String[] args) {
		String s="adefaddaccc";
		List<String> res=maxNumOfSubstrings(s);
		for(String ans:res) {
			System.out.print(ans+ " ");
		}
	}

	private static List<String> maxNumOfSubstrings(String s) {
		 if(s.length()==0) {
	            return null;
	        }
	        List<String> list = null;
	        int count[] = new int[26];
	        char ch[] = s.toCharArray();
	        int end=0;
	        while(end<ch.length) {
	            count[s.charAt(end)-'a']++;
	            end++;
	            while(end<ch.length && ch[end]==ch[end+1]) {
	                count[s.charAt(end)-'a']++;
	                end++;
	            }
	            StringBuilder sb = new StringBuilder();
	            list = new ArrayList<String>();
	            int c = count[s.charAt(end-1)];
	            System.out.print(c);
	            for(int i=0;i<c;i++) {
	                sb.append(ch[i]);
	            }
	            list.add(sb.toString());
	        }
	        return list;
	}

}
