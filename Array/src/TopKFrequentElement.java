import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElement {

	public static void main(String[] args) {
		int arr[] = {1,2,1,2,1,3,4,2};
		int k = 2;
		int result[] = topKFrequent(arr,k);
		for(int val:result) {
			System.out.print(val+" ");
		}
	}
	
	//O(n) 
	private static int[] topKFrequent(int[] arr, int k) {
		if(k<=0) {
            return new int[]{};
        }
        if(arr.length<=k) {
            return arr;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
        	map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        List<Integer> bucket[] = new ArrayList[arr.length+1];
        for(int key:map.keySet()) {
        	int frequency = map.get(key);
        	if(bucket[frequency]==null) {
        		bucket[frequency] = new ArrayList<Integer>();
        	}
        	bucket[frequency].add(key);
        }
        int result[] = new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0;i--) {
        	if(bucket[i]!=null) {
        		for(int num:bucket[i]) {
            		result[index++]=num;
        			if(index==k) {
        				return result;
        			}
            	}
        	}
        }
        return null;
	}
	/*private static int[] topKFrequent(int[] arr, int k) {
		if(k<=0) {
            return new int[]{};
        }
        if(arr.length<=k) {
            return arr;
        }
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			int key = arr[i];
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		Map<Integer,List<Integer>> treeMap = new TreeMap<Integer,List<Integer>>(Collections.reverseOrder());
		for(int key:map.keySet()) {
			int frequency=map.get(key);
			if(!treeMap.containsKey(frequency)) {
				treeMap.put(frequency, new ArrayList<Integer>());
			}
			treeMap.get(frequency).add(key);
		}
		int result[] = new int[k];
		int index=0;
		for(int resKey:treeMap.keySet()) {
				List<Integer> value = treeMap.get(resKey);
				for(int res:value) {
					result[index++]=res;
					if(index==k) {
						return result;
					}
				}
			}
		return null;
	}
	
	//Heap Method
	//TC: O(nlogk) SC: O(n)
	private static int[] topKFrequent(int[] arr, int k) {
		if(k<=0) {
            return new int[]{};
        }
        if(arr.length<=k) {
            return arr;
        }
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0) +1);
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->map.get(a)-map.get(b));
		for(int val:map.keySet()) {
			queue.offer(val);
		}
		for(int val:map.keySet()) {
			queue.offer(val);
			if(queue.size()>k) {
				queue.poll();
			}
		}
		int result[] = new int[k];
		for(int i=0;i<k;i++) {
			result[i] = queue.poll();
		}
		return result;
	}
	
	//Using Comparator
	private static int[] topKFrequent(int[] arr, int k) {
		Map<Integer,Element> map = new HashMap<Integer,Element>();
		List<Element> list = new ArrayList<Element>();
		
		for(int i=0;i<arr.length;i++) {
			int key = arr[i];
			if(map.containsKey(key)) {
				Element existingElement = map.get(key);
				existingElement.count+=1;
				map.put(key, existingElement);
			} else {
				Element element = new Element(key,1);
				map.put(key, element);
				list.add(element);
			}
		}
		Collections.sort(list, new SortByCount());
		int result[] = new int[k];
		for(int i=0;i<k;i++) {
			result[i] = list.get(i).key;
		}
		return result;
	}*/
}

/*class SortByCount implements Comparator<Element>{

	@Override
	public int compare(Element e1, Element e2) {
		return e2.count-e1.count;
	}
	
}

class Element {
	int key;
	int count;
	public Element(int key, int count) {
		this.key=key;
		this.count=count;
	}
	
	@Override
	public String toString() {
		return "Element [key=" + key + ", count=" + count + "]";
	}
}*/
