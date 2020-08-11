import java.util.ArrayList;
import java.util.List;

public class PancakeSort {

	public static void main(String[] args) {
		int A[] = {3,2,4,1};
		//O/P: {4,2,4,3}
		List<Integer> res = pancakeSort(A);
		System.out.print(res.toString());
	}
	
	private static void flip(int[] arr, int k) {
        for(int i = 0; i <= (k/2); ++i) {
            int t = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = t;
        }
    }

    private static int findMaxI(int[] a, int k) {
        int max = a[0], maxI = 0;
        for(int i = 0; i < k; ++i) {
            if(max < a[i]) {
                max = a[i];
                maxI = i;
            }
        }
        System.out.println("max: "+max+" maxI: "+maxI);
        return maxI;
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        for(int i = A.length - 1; i > 0; --i) {
            int maxI = findMaxI(A, i + 1);
            if(maxI != i) { // If the element is at the right index you don't need to flip. 
                flip(A, maxI);
                flips.add(maxI + 1);
                flip(A, i);
                flips.add(i + 1);
            }
        }
        return flips;
    }

}
