import java.util.Arrays;

class Heap {
	
	//General
	
	public static int parent(int index){
		int x = index-1;
		return (int) x/2;
	}
	
	public static int leftChild(int index){
		int left = index*2;
		return left;
	}

	public static int[] swap(int a, int b, int[] list){
		int x = list[a];
		int y = list[b];
		list[b] = x;
		list[a] = y;
		return list;
	}
	
	public static int[] append(int[] input, int item){
		int index = input.length+1;
		int[] list = new int[index];
		
		for (int i = 0; i < index-1; i++) {
			list[i] = input[i];
		}
		list[index-1] = item;
		return list;
	}
	
	public static int[] pop(int[] input){
		int index = input.length-1;
		int[] list = new int[index];
		for (int i = 0; i < index; i++) {
			list[i] = input[i];
		}
		return list;
	}

	//Additions
	
	public static int[] addItem(int[] input, int item){
		int[] list = append(input, item);
		int index = list.length-1;
		
		return recurseAdd(list, index);
	}

	public static int[] recurseAdd(int[] list, int index){
		if (index == 0) {
			return list;
		}
		else {
			int x = parent(index);
			
			if (list[x]>list[index]) {
				list = swap(x, index, list);
				return recurseAdd(list, x);
			} 
			else {
				return list;
			}
		}
	}
	
	//Removal
	
	public static int[] removeItem(int[] input, int index){
		input[0] = input[input.length-1];
		input = pop(input);
		
		return recurseSift(input, index);
	}
	
	public static int[] recurseSift(int[] list, int index) {
		int left = leftChild(index);
		int right = left+1;
		if (left>=list.length && right>=list.length) {
			//System.out.println(Arrays.toString(list));
			return list;
		}
		if (list[left-1]<list[right-1]) {
			list = swap(left-1, index-1, list);
			return recurseSift(list, left);
		} else {
			list = swap(right-1, index-1, list);
			return recurseSift(list, right);
		}
	}
	
	//Sorting
	
	public static int[] heapsort(int[] in){
		int[] input = {in[0]};
		for (int i = 1; i < in.length; i++) {
			//System.out.println(in[i]);
			
			input = addItem(input, in[i]);
		}
		
		int[] sort = {input[0]};
		
		while (input.length!=1) {
			input = removeItem(input, 1);
			sort = append(sort, input[0]);
		}
		//System.out.println(Arrays.toString(sort));
		return sort;
	}
	
	//Main
	
	public static void main(String[] args) {
		int[] input = {8, 7, 10, 2, 9, 3, 4, 6, 5, 1};
		int[] sort = heapsort(input);
		System.out.println(Arrays.toString(sort));;
	}
}

