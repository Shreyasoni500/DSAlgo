import java.util.Stack;

public class ValidParenthesisString {

	public static void main(String[] args) {
		String str = "(*)())";
		if(checkValidString(str)) {
			System.out.print("true");
		} else {
			System.out.print("false");
		}
	}

	/*private static boolean checkValidString(String str) {
		if(str==null || str.length()==0) {
			return true;
		}
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				stack1.push(str.charAt(i));
			} else if(str.charAt(i)=='*') {
				stack2.push(str.charAt(i));
			} else {
				if(!stack1.isEmpty()) {
					stack1.pop();
				} else if(!stack2.isEmpty()) {
					stack2.pop();
				} else {
					return false;
				}
			}
		}
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if(stack1.pop()>stack2.pop()) {
				return false;
			}
		}
		return stack1.isEmpty();
	}*/
	
	private static boolean checkValidString(String str) {
		int left = 0, right = 0; 
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=')') {
				left++;
			} else {
				left--;
			}
			if(str.charAt(str.length()-1-i)!='(') {
				right++;
			} else {
				right--;
			}
			if(left<0 || right<0) {
				return false;
			}
		}
		return true;
	}
}
