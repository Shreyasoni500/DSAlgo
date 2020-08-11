import java.util.LinkedList;
import java.util.Queue;

public class RotOrange {
	static int R=3,C=5;
	public static void main(String[] args) {
		int arr[][] = { {2, 1, 0, 2, 1},
                		{1, 0, 1, 2, 1},
                		{1, 0, 0, 2, 1}};
		int ans = findNumberOfTimeFrames(arr);
		if(ans==-1) {
			System.out.print("All oranges cannot be rotten");
		} else {
			System.out.print("Time required to rot all the oranges: "+ans);
		}
	}

	/*private static int rotOranges(int[][] arr) {
		int k = 2;
		boolean changed = false;
		while(true) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]==k) {
						if(isSafe(i+1,j) && arr[i+1][j]==1) {
							System.out.print(arr[i][j]+" ");
							arr[i+1][j] = arr[i][j]+1;
							changed = true;
						}
						if(isSafe(i,j+1) && arr[i][j+1]==1) {
							arr[i][j+1] = arr[i][j]+1;
							changed = true;
						}
						if(isSafe(i-1,j) && arr[i-1][j]==1) {
							arr[i-1][j] = arr[i][j]+1;
							changed = true;
						}
						if(isSafe(i,j-1) && arr[i][j-1]==1) {
							arr[i][j-1] = arr[i][j]+1;
							changed = true;
						}
					}
				}
			}
			if(!changed) {
				break;
			}
			changed = false;
			k++;
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==1) {
					return -1;
				}
			}
		}
		return k-2;
	}*/
	
	//Each element is inserted into queue only once. TC:O(R*C) SC:O(R*C)
	private static int findNumberOfTimeFrames(int[][] arr) {
		int row=arr.length, col = arr[0].length;
		Queue<Element> queue = new LinkedList<Element>();
		Element temp;
		int ans = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j]==2) {
					queue.add(new Element(i,j));
				}
			}
		}
		queue.add(new Element(-1,-1));
		while(!queue.isEmpty()) {
			boolean flag = false;
			while(!isDelimeter(queue.peek())) {
				temp = queue.peek();
				if(isSafe(temp.x+1,temp.y,row,col) && arr[temp.x+1][temp.y]==1) {
					if(!flag) {
						flag=true;
						ans++;
					}
					arr[temp.x+1][temp.y]=2;
					temp.x++;
					queue.add(new Element(temp.x,temp.y));
					temp.x--;
				}
				if(isSafe(temp.x-1,temp.y,row,col) && arr[temp.x-1][temp.y]==1) {
					if(!flag) {
						flag=true;
						ans++;
					}
					arr[temp.x-1][temp.y]=2;
					temp.x--;
					queue.add(new Element(temp.x,temp.y));
					temp.x++;
				}
				if(isSafe(temp.x,temp.y+1,row,col) && arr[temp.x][temp.y+1]==1) {
					if(!flag) {
						flag=true;
						ans++;
					}
					arr[temp.x][temp.y+1]=2;
					temp.y++;
					queue.add(new Element(temp.x,temp.y));
					temp.y--;
				}
				
				if(isSafe(temp.x,temp.y-1,row,col) && arr[temp.x][temp.y-1]==1) {
					if(!flag) {
						flag=true;
						ans++;
					}
					arr[temp.x][temp.y-1]=2;
					temp.y--;
					queue.add(new Element(temp.x,temp.y));
				}
				queue.remove();
			}
			//pop the delimeter
			queue.remove();
			if(!queue.isEmpty()) {
				queue.add(new Element(-1,-1));
			}
		}
		return (checkAll(arr))? -1: ans;
	}

	private static boolean isSafe(int i, int j,int row,int col) {
		if(i>=0 && i<row && j>=0 && j<col) {
			return true;
		}
		return false;
	}
	
	private static boolean isDelimeter(Element temp) {
		return (temp.x==-1 && temp.y==-1); 
	}
	
	public static boolean checkAll(int arr[][]) {
		int R = arr.length;
		int C = arr[0].length;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}
}

class Element {
	int x=0;
	int y=0;
	public Element(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
