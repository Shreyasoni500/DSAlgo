
public class MaxSumOfKElementsInSlidingWindow {

	public static void main(String[] args) {
		int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k = 4;
		int res=findMaxSum(arr,k);
		System.out.println(res+" ");
	}

	/*private static int findMaxSum(int[] arr, int k) {
		if(arr.length<k) {
			System.out.print("Invalid");
			return -1;
		}
		int maxSum = 0;
		for(int i=0;i<k;i++) {
			maxSum+=arr[i];
		}
		int window_sum = maxSum;
		for(int i=k;i<arr.length;i++) {
			window_sum += arr[i] - arr[i - k]; 
			maxSum = Math.max(maxSum, window_sum);
		}
		//System.out.print(maxSum+" ");
		return maxSum;
	}*/
	private static int findMaxSum(int[] arr, int k) {
		if(arr.length<k) {
			System.out.print("Invalid");
			return -1;
		}
		int sum = 0, maxSum=0;
		for(int i=0;i<arr.length-k+1;i++) {
			sum = 0;
			for(int j=i;j<k+i;j++) {
				sum+=arr[j];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
