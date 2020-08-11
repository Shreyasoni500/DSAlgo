import java.util.HashMap;
import java.util.Map;

public class FindTotalSubarrayWithTargetSum {

	public static void main(String[] args) {
		int arr[] = {10, 5, 7, 1, 2, 5, 3};
		int target = 15;
		int count = findNumberOfSubarray(arr, target);
		System.out.println(count+" ");
	}
	
	/*private static int findNumberOfSubarray(int arr[], int target) {
		int sum, count=0;
		for(int i=0;i<arr.length;i++) {
			sum = 0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum==target) {
					count++;
					break;
				}
			}
		}
		return count;
	}*/
	
	private static int findNumberOfSubarray(int arr[], int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, count=0;
		map.put(0,1);
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(map.containsKey(sum-target)) {
				count+=map.get(sum-target);
			} 
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}

}
