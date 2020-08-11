import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindow {

	public static void main(String[] args) {
		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int res[] = maxSlidingWindow(nums,k);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+ " ");
		}
	}
	
	//TC: TLE
	/*private static int[] maxSlidingWindow(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++) {
            if(nums[i]>max) {
                max=nums[i];
            }
        }
        list.add(max);
        
        for(int i=k;i<nums.length;i++) {
            max = Integer.MIN_VALUE;
            for(int j=i-k+1;j<=i;j++) {
                if(nums[j]>max) {
                    max = nums[j];
                }
            }
            list.add(max);
        }
        int res[] = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i]=list.get(i);
        }
        return res;
	}*/
	
	/*private static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null) {
			return null;
		}
		if(nums.length==0 || k<=0) {
			return new int[0];
		}
		int result[] = new int[nums.length-k+1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1;
			}
		});
		//PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> b-a);
		for(int i=0;i<k;i++) {
			queue.add(nums[i]);
		}
		result[0] = queue.peek();
		for(int i=k;i<nums.length;i++) {
			queue.remove(nums[i-k]);
			queue.add(nums[i]);
			result[i-k+1]=queue.peek();
		}
		return result;
	}*/

	/*private static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0 || k<=0) {
			return new int[0];
		}
		int res[] = new int[nums.length-k+1];
		for(int i=0;i<nums.length-k+1;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=i;j<i+k;j++) {
				max = Math.max(max, nums[j]);
			}
			res[i]=max;
		}
		return res;
	}*/
	
	private static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0 || k<=0) {
			return new int[0];
		}
		int res[] = new int[nums.length-k+1];
		int count = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<nums.length;i++) {
			while(!dq.isEmpty() && dq.peek()<i-k+1) {
				dq.poll();
			}
			while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) {
				dq.poll();
			}
			dq.offer(i);
			if(i>=k-1) {
				res[count++] = nums[dq.peek()];
			}
		}
		return res;
	}
}
