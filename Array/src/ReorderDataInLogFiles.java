import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderDataInLogFiles {

	public static void main(String[] args) {
		String logs[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		
		//O/P: Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
		
		String ans[] = reorderLogFiles(logs);
		for(String res:ans) {
			System.out.print(res+" ,");
		}
	}

	/*private static String[] reorderLogFiles(String[] logs) {
	 	if(logs==null || logs.length<=1) {
            return logs;
        }
		PriorityQueue<String> queue = new PriorityQueue<String>((a,b) ->  {
			String worda[] = a.split(" ",2);
			String wordb[] = b.split(" ",2);
			if(worda[1].equals(wordb[1])) {
				return worda[0].compareTo(wordb[0]);
			}
			return worda[1].compareTo(wordb[1]);
		});
		
		List<String> numbers = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		for(String log:logs) {
			String temp = log.split(" ",2)[1];
			if(temp.charAt(0)-'a'>=0) {
				queue.offer(log);
			} else {
				numbers.add(log);
			}
		}
		
		while(!queue.isEmpty()) {
			result.add(queue.poll());
		}
		result.addAll(numbers);
		
		return result.toArray(new String[logs.length]);
	}*/
	
	private static String[] reorderLogFiles(String[] logs) {
		if(logs==null || logs.length<=1) {
            return logs;
        }
		List<String> letters = new ArrayList<String>(), digits = new ArrayList<String>();;
		for(String log:logs) {
			if(isDigit(log)) {
				digits.add(log);
			} else {
				letters.add(log);
			}
		}
		
		Collections.sort(letters,new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				int logCompare = getWords(s1).compareTo(getWords(s2));
				if(logCompare!=0) {
					return logCompare;
				}
				return getDigits(s1).compareTo(getDigits(s2));
			}
		});
		
		String result[] = new String[logs.length];
		int k=0;
		for(String letter:letters) {
			result[k] = letter;
			k++;
		}
		for(String digit:digits) {
			result[k]=digit;
			k++;
		}
		return result;
	}
	
	private static boolean isDigit(String str) {
		return Character.isDigit(str.split(" ",2)[1].charAt(0));
	}
	
	private static String getWords(String str) {
		return splitAndGet(str,1);
	}
	
	private static String getDigits(String str) {
		return splitAndGet(str,0);
	}

	private static String splitAndGet(String str, int index) {
		return str.split(" ",2)[index];
	}
}
