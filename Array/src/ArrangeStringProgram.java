import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ArrangeStringProgram {

	public static void main(String[] args) {
		String str = "vvvlo";
		//o/p: "vlvov" //"vol"
		String finalStr = rearrange(str);
		System.out.print(finalStr);
	}

	private static String rearrange(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			int count = map.getOrDefault(ch, 0)+1;
			if(count>(str.length()+1)/2) 
			{
				return "";
			}
			map.put(ch,count);
			
		}
		//ch -> count
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)->(b[1]-a[1])); 
		for(char c:map.keySet()) {
			queue.add(new int[] {c,map.get(c)});
		}
		//v -> 2 
		//vo
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int first[] = queue.poll();
			System.out.println((char)first[0]+" "+first[1]);
			if(sb.length()==0 || first[0]!=sb.charAt(sb.length()-1)) {
				sb.append((char)first[0]);
				if(--first[1]>0) {
					queue.add(first);
				}
			} else {
				int second[] = queue.poll();
				System.out.println("ok"+(char)second[0]+" "+second[1]);
				sb.append((char)second[0]);
				if(--second[1]>0) {
					queue.add(second);
				}
				queue.add(first);
			}
		}
		return sb.toString();
	}

}
