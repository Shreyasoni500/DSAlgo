import java.util.HashMap;
import java.util.Map;

public class SubarrayWithEqualNoOf0and1 {
	
	public static void main(String[] args) {
		int arr[] = {1,0,0,1,0};
		int n = arr.length;
		subarray(arr,n);

	}

	/*private static void subarray(int[] arr, int n) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maxLength = 0, endIndex = 0, sum=0; 
		map.put(0, -1);
		for(int i=0;i<arr.length;i++) {
			sum+=(arr[i]==0?-1:1);
			if(map.get(sum)==null) {
				map.put(sum, i);
			} else {
				int prevIndex = map.get(sum);
				if(maxLength<(i-prevIndex)) {
					maxLength = i-prevIndex;
					endIndex = i;
				}
			}
		}
		System.out.print("start: "+(endIndex-maxLength+1)+" end: "+endIndex+ " maxLength: "+maxLength);
	}*/
	private static void subarray(int[] arr, int n) {
		int sum = 0, maxLength=0, startIndex = 0, endIndex=0;
		for(int i=0;i<arr.length-1;i++) {
			sum = (arr[i] == 0) ? -1 : 1; 
			for(int j=i+1;j<arr.length;j++) {
				if (arr[j] == 0) 
                    sum += -1; 
                else
                    sum += 1; 
  
                // If this is a 0 sum subarray, then 
                // compare it with maximum size subarray 
                // calculated so far 
  
                if (sum == 0 && maxLength < j - i + 1) { 
                	maxLength = j - i + 1; 
                    startIndex = i; 
                } 
			}
		}
		endIndex = startIndex+maxLength-1;
		System.out.print(" Start: "+startIndex+ " End: "+endIndex+" Maxlength: "+maxLength);
	}

}
