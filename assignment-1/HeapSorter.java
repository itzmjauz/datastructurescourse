import java.util.Arrays; //temporary

class HeapSorter {

  //start method called from Main, checks if we should handle the
  //toSorted array as binary or ternary
  public int[] start(int[] toSort, boolean binaryHeap) {
      if(binaryHeap) {
      return binaryHeapSort(toSort);
    } else {
      //return ternaryHeapSort(toSort);
      return toSort;
    }
  }

  private int[] binaryHeapSort(int[] toSort) {
    System.out.println(toSort.toString());
    return toSort;
  }

  private void swap(int[] array, int index1, int index2) {
    int x = array[index1];
    array[index1] = array[index2];
    array[index2] = x;
  }

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

    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    new HeapSorter().test();
  }
}
