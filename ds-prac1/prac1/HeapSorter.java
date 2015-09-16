package prac1;

class HeapSorter {

  /** start method called from Main, checks if we should handle the
    * toSorted array as binary or ternary
    * mod is the modifier that maxheapify needs in order to know how to maxheap the array
    *
    * the sorting itself consists of the four simple calls , within the while loop
    * the while loop simply loops once for every element in toSort
    * maxheapify, grabs the max heap, then we move the root to the sorted array
    * we decrease the sortedIndex so that we dont edit the same element all the time
    * then we remove the root from toSort and return the result after the loop
    **/

  static int[] start(int[] toSort, boolean binaryHeap) {
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

  /** remove index 0 , decrease array size by 1
    * result is one smaller than toRemoveFrom since we decrease the size by 1
    * with the for loop we map through all elements in result which are empty
    * at the start of the loop, and we move all elements but the first from
    * toRemoveFrom to result. after the loop we return result
    **/

  private static int[] removeRoot(int[] toRemoveFrom) {
    int[] result = new int[toRemoveFrom.length - 1];

    for(int x = 0 ; x < result.length ; x++) {
      result[x] = toRemoveFrom[x + 1];
    }

    return result;
  }

  /** edits array ~ swaps the two given indexes
    * saves index1 in temp, index1 becomes the same as index2
    * then index2 becomes temp.
    **/
  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  /** maxheapifies the given array using swap()
    * we estimate the iterations needed for better performance
    * the second for loop increases offset , depending on the moda parent
    * might have multiple children, this loop makes sure every child gets compared
    * to the parent, and if needed , swapped.
    **/
  private static int[] maxHeapify(int[] toHeapify, int mod) {
    int iterations = toHeapify.length / mod;

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
