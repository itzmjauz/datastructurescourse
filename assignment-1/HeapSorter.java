import java.util.Arrays; //temporary

class HeapSorter {

  //start method called from Main, checks if we should handle the
  //toSorted array as binary or ternary
  public int[] start(int[] toSort, boolean binaryHeap) {
    int[] sorted = new int[toSort.length];
    return toSort;
  }

  private int[] removeRoot(int[] toRemoveFrom) {
    int[] result = new int[toRemoveFrom.length - 1];

    for(int x = 0 ; x < result.length ; x++) {
      result[x] = toRemoveFrom[x + 1];
    }

    return result;
  }

  private int[] shift(int[] toShift) {
    int temp = toShift[toShift.length - 1];

    for(int i = (toShift.length - 1) ; i > 0 ; i--) {
      toShift[i] = toShift[i - 1];
    }

    toShift[0] = temp;
    return toShift;
  }

  private int[] binaryHeapSort(int[] toSort) {
    System.out.println(toSort.toString());
    return toSort;
  }

  // edits array ~ swaps the two given indexes
  private void swap(int[] array, int index1, int index2) {
    int x = array[index1];
    array[index1] = array[index2];
    array[index2] = x;
  }

  // maxheapifies the given array using swap() (binary)
  private int[] binaryMaxHeapify(int[] toHeapify) {
    int iterations = (toHeapify.length / 2);

    for(int x = iterations ; x >= 0 ; x--) {
      for(int offset = 1 ; offset <= 2 ; offset++) {
        int index = (x * 2) + offset;

        if(index < toHeapify.length) {
          if(toHeapify[index] > toHeapify[x]) {
            swap(toHeapify, x, index);
          }
        }
      }
    }
    return toHeapify;
  }

  // maxheapifies the given array using swap() (ternary)
  private int[] ternaryMaxHeapify(int[] toHeapify) {
    int iterations = ((toHeapify.length + 1) / 3);

    for(int x = iterations ; x >= 0 ; x--) {
      for(int offset = 1 ; offset <= 3 ; offset++) {
        int index = (x * 3) + offset;

        if(index < toHeapify.length) {
          if(toHeapify[index] > toHeapify[x]) {
            swap(toHeapify, x, index);
          }
        }
      }
    }
    return toHeapify;
  }

// temporary testing code
  public void test() {
    int[] input = {8, 7, 10, 2, 9, 3, 4, 6, 5, 1};
    int[] result = binaryMaxHeapify(input);

    System.out.println(Arrays.toString(removeRoot(result)));
  }

  public static void main(String[] args) {
    new HeapSorter().test();
  }
}
