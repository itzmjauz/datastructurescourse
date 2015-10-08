class Untitled {
	
	private static int getK(int size_x, int size_y) {

		int size = size_y;
		if (size_y<size_x) {
			size = sizex;
		}
	
		//int k = (size_y* + size_x^2)^0.5;
		return size;

	}
		
	private static int[] singleRow(int transformX, int transformY, int x, int y, int[][] input) {
		int[] output = new int[size];
		int counter = 0;
		
		int size_x = input[0].length;
		int size_y = input.length;
		
		int k = getK(size_x-x, size_y-y);
		
		for (int i = 0; i < k; i++) {
			x+=transformX;
			y+=transformY;
			
			output[counter] = input[y][x];
			counter+=1;
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
			int[] row =  singleRow(transformX, transformY, x, y, input);
			output[count] = row;
			count+=1;
			y+=1;
		}
		
		y = 0;
		for (int i = 0; i < input[0].length; i++) {
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
		
		//KADANE'S ALGORITHM + COMPARRISON
				
	}

	public static int kadane(int[] a) {
		//apply kadane's algorithm
		int max_so_far = 0;
		int max_ending_here = 0;


		for(int i = 0 ; i < a.length ; i++ ) {
			max_ending_here = max_ending_here + a[i];

			if(max_ending_here < 0) {
				max_ending_here = 0;
			}

			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}

		return max_so_far;
	}
}
