import java.util.Arrays;

class Untitled {
	private static int max(int a, int b) {
	  return (a > b)? a : b;
	}
	
	private static int[] chomp(int[] a, int size){
		int[] output = new int[size];
		for (int i = 0; i < size; i++) {
			output[i] = a[i];
		}
		return output;
	}
	
	public static void main(String[] args) {
		int m[] = {0,3,-3,-1,5,10,12,-5,-9,-2,14};
		int size = 0;
		int section = m[0];
		int[] output = new int[m.length];
		
		for (int i = 1; i < m.length; i++) {
			System.out.println(section);
			if (m[i-1]>=0 && m[i]>0 || m[i-1]<0 && m[i]<0) {
				section+=m[i];
			}
			else {
				System.out.println("Flip!");
				output[size] = section;
				size+=1;
				section = m[i];
			}
		}
		output[size]=;
		System.out.println(Arrays.toString(chomp(output, size)));
	}
}

public int maxSequenceSum(int[] arr)
    {        
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }   