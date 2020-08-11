
public class ContinuousOneByReplacing0 {

	public static void main(String[] args) {
		int arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int k=1;
		int windowSize = maxOnesIndex(arr,k);
		//System.out.print(windowSize+" ");
	}
	
	//counting max number of one 
	/*private static int maxOnesIndex(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int start = 0, max=0;
		for(int end=0;end<arr.length;end++) {
			if(arr[end]==1) {
				max = Math.max(max, end-start+1);
			} else {
				start=end+1;
			}
		}
		return max;
	}*/
	
	private static int maxOnesIndex(int[] arr, int k) {
		int start = 0; //start of window 
		int count = 0; //count of zeros 
		int window = 0; //Largest number of 1 including k 0's 
		int leftIndex = -1;
		for(int end=0;end<arr.length;end++) {
			if(arr[end]==0) {
				count++;
			}
			while(count>k) {
				//System.out.print("start: "+start+" count "+count+" ");
				if(arr[start]==0) {
					//System.out.println("check: "+arr[start]);
					count--;
				}
				start++;
			}
			//System.out.println("start: "+ start+ " window:" +(end-start-1) +"end: "+end);
			if((end-start+1)>window) {
				//System.out.println("bhais "+ start+" "+end+" gobar ");
				window = end-start+1;
				leftIndex = start;
			}
		}
		System.out.println("win: "+window);
		for(int i=leftIndex;i<(leftIndex+window-1);i++) {
			if(arr[i]==0) {
				System.out.print("i: "+i );
				return i;
			}
		}
		return 0;
	}

}
