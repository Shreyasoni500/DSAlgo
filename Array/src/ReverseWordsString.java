
public class ReverseWordsString {

	public static void main(String[] args) {
		String s = "the sky   is blue";
		String res = reverseWords(s);
		System.out.print(res);
	}

	private static String reverseWords(String s) {
		String word[] = s.split(" +");
		StringBuilder sb = new StringBuilder();
		for(int i=word.length-1;i>0;i--) {
			sb.append(word[i]+" ");
		}
		return sb.append(word[0]).toString();
	}

	/*private static String reverseWords(String s) {
		/*char ch[] = s.toCharArray();
		int start = 0, end = 0;
		while(end<ch.length) {
			while(end<ch.length && ch[end]!=' ') {
				end++;
			}
			reverseWord(ch,start,end-1);
			end++;
			start = end;
		}
		reverseWord(ch,0,ch.length-1);
		//System.out.println(ch);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ch.length;i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
}

	private static void reverseWord(char[] ch, int start, int end) {
		while(start<end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end]=temp;
			start++;
			end--;
		}
		 if (s == null) {
		        return s;
		        }
		     String[] parts = s.trim().split("\\s+"); //to remove one or more spaces
		     for(int i=0;i<parts.length;i++) {
		    	 System.out.print(i+" "+parts[i]);
		     }
		     String out = "";
		     for (int i = parts.length - 1; i >= 0; i--) {
		        out += parts[i] + " ";
		     }
		     System.out.println();
		     System.out.print(out);
		     return out + parts[0];   
	}*/
}
