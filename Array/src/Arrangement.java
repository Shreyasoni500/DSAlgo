import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Arrangement {

	public static void main(String[] args) {
		String str[] = {"mango", "apple", "apple", "Banana", "Apple", "mango", "banana"};
		String res= rearrange(str);
		System.out.print(res);
		/*for(int i=0;i<res.length;i++) {
			System.out.print(res[i]);
		}*/
	}

	private static String rearrange(String[] str) {
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<str.length;i++) {
			String temp = str[i];
			int count = map.getOrDefault(temp.toLowerCase(), 0)+1;
			if(count>(str.length+1)/2) {
				return null;
			} 
			map.put(temp.toLowerCase(), count);
		}
		PriorityQueue<String> queue = new PriorityQueue<String>((a,b) -> map.get(b)-map.get(a)); 
		for(String st:map.keySet()) {
			queue.offer(st);
		}
		StringBuilder sb = new StringBuilder();
		//String res[] = new String[str.length];
		List<String> al = new ArrayList<String>();
		//int k = 0;
		String lastVal = "";
		while(!queue.isEmpty()) {
			String first = queue.poll();
			int firstCount = map.get(first);
			System.out.println(first +" "+firstCount);
			if(al.size()==0 || first!=al.get(al.size()-1)) {
				System.out.print(first+" ");
				al.add(first);
				if(--firstCount>0) {
					queue.offer(first);
				}
			} else {
				String second = queue.poll();
				int secondCount = map.get(second);
				if(second!=al.get(al.size()-1)) {
					sb.append(second);
					if(--secondCount>0) {
						queue.offer(second);
					}
				}
				queue.offer(first);
			}
		}
		return sb.toString();
	}

}
