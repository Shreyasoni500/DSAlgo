import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = {5, 3, 2, 4};
		int result[] = findNextGreaterElement(arr);
		for(int r:result) {
			System.out.print(r+" ");
		}

	}

	/*private static void findNextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int res[] = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && stack.peek()<arr[i]) {
				stack.pop();
			}
			res[i]=(stack.isEmpty()?-1:stack.peek());
			stack.push(arr[i]);
		}
		for(int r:res) {
			System.out.print(r+" ");
		}
		
	}*/
	
	//Circular Next Greater Element //-1,4,4,5
	/*private static int[] findNextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int result[] = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			stack.push(arr[i]);
		}
		for(int i=arr.length-1;i>=0;i--) {
			result[i]=-1;
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			result[i]=stack.isEmpty()?-1:stack.peek();
			stack.push(arr[i]);
		}
		return result;
	}*/
	
	//Circular Next Greater Element //-1,4,4,5
	public static int[] findNextGreaterElement(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }

}