import java.util.PriorityQueue;

public class kthLargestElementInSortedArray {

	public static void main(String[] args) {
		int mat[][] = {{10, 20, 30, 40}, 
                		  {15, 25, 35, 45}, 
                		  {25, 29, 37, 48}, 
                		  {32, 33, 39, 50}};
		int k = 7;
		findElement(mat, k);
	}

	private static void findElement(int[][] mat, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				queue.offer(mat[i][j]);
			}
		}
		int count = 0;
		while(!queue.isEmpty()) {
			int element = queue.poll();
			if(count==k) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

}
