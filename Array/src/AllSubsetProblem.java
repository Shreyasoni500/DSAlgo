import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetProblem {
	
	//Permutation: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> list = subsets(nums);
		for(List<Integer> res:list) {
			System.out.println(res.toString());
		}
	}
	
	//DFS
	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.length;i++) {
			tempList.add(nums[i]);
			System.out.println(" add: "+nums[i]+" start: "+start +" index: "+i+ " tempList: "+tempList.toString());
			backtrack(list,tempList,nums,i+1);
			System.out.println("remove :"+(tempList.get(tempList.size()-1)));
			tempList.remove(tempList.size()-1);
		}
	}
	
	//BFS
	/*private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for(int num:nums) {
			int size = result.size();
			for(int i=0;i<size;i++) {
				List<Integer> subset = new ArrayList<Integer>(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}
		return result;
	}*/

}
