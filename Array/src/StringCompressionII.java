import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringCompressionII {

	public static void main(String[] args) {
		String str="aaabcccd";
		int k = 2;
		int result = getLengthOfOptimalCompression(str,k);
		System.out.print(result+" ");
	}

	private static int getLengthOfOptimalCompression(String s, int k) {
		int n = s.length();
        String res = "";
        for(int i=0;i<n;i++) {
            int count = 1;
            char ch = s.charAt(i);
            while(i<n-1 && s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
            }
            if(count==1) {
                res+=ch;
            } else {
                res+=(ch+""+count);
            }
        }
        Map<Character,Integer> map = new HashMap<>();
        int reslen = res.length();
        for(int i=0;i<reslen;i++) {
            if(i<reslen-1 && !Character.isLetter(res.charAt(i+1))) {
                map.put(res.charAt(i), Integer.parseInt(String.valueOf(res.charAt(i+1))));
                i++;
            } else {
            	map.put(res.charAt(i), 1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
        for(char ch:map.keySet()) {
        	queue.offer(new int[] {ch,map.get(ch)});
        }
        int count = 0;
        while(!queue.isEmpty()) {
        	if(count<k) {
        		int temp[] = queue.poll();
        		count++;
            	//System.out.println(temp[0]+ " "+temp[1]+" "+ count);
        		if(--temp[1]>0) {
        			System.out.println("sds");
        			queue.add(temp);
        		}
        	} else {
        		break;
        	}
        	
        }
        //int size = queue.size();
        //System.out.println("size: "+size+" ");
        int result = 0;
        while(!queue.isEmpty()) {
        	int temp[] = queue.poll();
        	System.out.println(temp[0]+ " "+temp[1]);
        	if(temp[1]==1) {
        		result++;
        	} else {
        		result+=2;
        	}
        }
		return result;
	}

}
