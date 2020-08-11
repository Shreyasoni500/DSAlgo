
public class RarrangeCharacters {

	public static void main(String[] args) {
		String message = "abaabbbc";
		//O/P: aba2b3c
		String str = compressedString(message);
		System.out.print(str);
	}

	private static String compressedString(String message) {
		String str = "";
		for(int i=0;i<message.length();i++) {
			int count = 1;
			char ch = message.charAt(i);
			int start = i, end = message.length()-1;
			while(start<end && message.charAt(i)==message.charAt(i+1)) {
				count++;
				i++;
			}
			if(count==1) {
				str+=ch;
			} else {
				str+=ch+""+count;
			}
		}
		return str;
	}

}
