import java.util.HashMap;
import java.util.Map;

public class TotalSubarrayWithTargetSumInTree {
	static Node root;
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.left.left = new Node(3);
		root.left.right = new Node(2);
		root.left.right.right = new Node(1);
		root.right = new Node(-3);
		root.right = new Node(11);
		
		int target = 8;
		int count = pathSum(root, target);
		System.out.println(count+" ");
	}
	//O(n^2)
	/*static int count = 0;
	private static int pathSum(Node root, int target) {
		if(root==null) {
			return 0;
		}
		pathSumUtil(root,target,0);
		pathSum(root.left,target);
		pathSum(root.right, target);
		
		return count;
	}
	
	private static void pathSumUtil(Node root, int target, int currentSum) {
		if(root==null) {
			return;
		}
		currentSum+=root.val;
		if(target==currentSum) {
			count++;
		}
		pathSumUtil(root.left,target,currentSum);
		pathSumUtil(root.right,target,currentSum);
	}*/
	
	static int count = 0;
	private static int pathSum(Node root, int target) {
		Map<Integer, Integer> map=new HashMap<>();
		map.put(0, 1);
		pathSumUtil(root,target,map,0);
		return count;
	}
	private static void pathSumUtil(Node node, int target, Map<Integer, Integer> map, int currentSum) {
		if(node==null) {
			return;
		}
		currentSum+=node.val;
		if(map.containsKey(currentSum-target)) {
			count+=map.get(currentSum-target);
		}
		map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
		pathSumUtil(node.left,target,map,currentSum);
		pathSumUtil(node.right,target,map,currentSum);
		map.put(currentSum, map.get(currentSum)-1);
		return;
	}
}
