package prac1;

class HeapSorter {

  //start method called from Main, checks if we should handle the
  //toSorted array as binary or ternary
  public int[] start(int[] toSort, boolean binaryHeap) {
    int[] sorted = new int[toSort.length];
    int sortedIndex = toSort.length - 1;
    int mod = binaryHeap? 2 : 3; // binary or ternary ,, mod 2 | 3

    while(sortedIndex >= 0) {
      toSort = maxHeapify(toSort, mod);
      sorted[sortedIndex] = toSort[0];
      sortedIndex--;
      toSort = removeRoot(toSort);
    }

    return sorted;
  }

  private int[] removeRoot(int[] toRemoveFrom) {
    int[] result = new int[toRemoveFrom.length - 1];

    for(int x = 0 ; x < result.length ; x++) {
      result[x] = toRemoveFrom[x + 1];
    }

    return result;
  }

  // edits array ~ swaps the two given indexes
  private void swap(int[] array, int index1, int index2) {
    int x = array[index1];
    array[index1] = array[index2];
    array[index2] = x;
  }

  // maxheapifies the given array using swap() (binary)
  private int[] maxHeapify(int[] toHeapify, int mod) {
    int iterations = ((toHeapify.length + 1) / mod);

    for(int x = iterations ; x >= 0 ; x--) {
      for(int offset = 1 ; offset <= mod ; offset++) {
        int index = (x * mod) + offset;

        if(index < toHeapify.length) {
          if(toHeapify[index] > toHeapify[x]) {
            swap(toHeapify, x, index);
          }
        }
      }
    }
    return toHeapify;
  }
}
