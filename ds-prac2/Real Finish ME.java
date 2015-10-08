import java.util.Arrays;

class Untitled {
	
	private static int getK(int size_x, int size_y) {

		int size = size_y;
		if (size_y<size_x) {
			size = size_x;
		}
	
		//int k = (size_y* + size_x^2)^0.5;
		return size;

	}
		
	private static int[] singleRow(int transformX, int transformY, int x, int y, int[][] input) {
		
		int size_x = input[0].length;
		int size_y = input.length;
		
		int k = getK(size_x-x, size_y-y);
		System.out.println(k);
		
		int[] output = new int[getK(size_x-x, size_y-y)];
		int counter = 0;
		
		for (int i = 0; i < k; i++) {
			
			System.out.println(""+x+","+y);
		
			output[counter] = input[y][x];
			counter+=1;
			
			x+=transformX;
			y+=transformY;
			if(x<0 || y<0){
				break;
			}
		}
		
		return output;
	}
	
	// This function returns an array of Arrays that contain the lines of the
	
	public static int[][] getRows(int transformX, int transformY, int[][] input) {
		int x = 0;
		int y = 0;
		
		int size = input.length+input[0].length - 1;
		int [][] output = new int[size][getK(input[0].length, input.length)]; // FIX GET K
		int count = 0;
		
		
		for (int i = 0; i < input.length; i++) {
			System.out.println("START ROW:"+x+","+y);
			int[] row =  singleRow(transformX, transformY, x, y, input);
			output[count] = row;
			count+=1;
			y+=1;
		}
		
		y = input.length-1;
		x = 1;
		for (int i = 0; i < input[0].length-1; i++) {
			System.out.println("START ROW:"+x+","+y);
			int[] row =  singleRow(transformX, transformY, x, y, input);
			output[count] = row;
			x+=1;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{4,5,6}, {7,8,9}};
		
		// Each method has the transforms : [transformX, transformY]
		int[] antiD = {-1,1};
		int[] diago = {1,1};
		int[] verti = {0,1};
		int[] horiz = {1,0};
		
		int[][] rows = getRows(antiD[0], antiD[1], m);
		
		for (int i = 0; i < rows.length; i++) {
			System.out.println(Arrays.toString(rows[i]));
		}
		
		
		//KADANE'S ALGORITHM + COMPARRISON
		
	}
}