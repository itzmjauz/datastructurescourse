package prac1;

class HeapSorter {

  /** @students info 
    * @names            : Antoni stevenet , David Gall
    * @vuIDs            : ast257          , dgl800
    * @details 
    * start method called from Main, checks if we should handle the
    * toSorted array as binary or ternary
    * mod is the modifier that maxheapify needs in order to know how to maxheap the array
    *
    * the sorting itself consists of the four simple calls , within the while loop
    * the while loop simply loops once for every element in toSort
    * maxheapify, grabs the max heap, then we move the root to the sorted array
    * we decrease the sortedIndex so that we dont edit the same element all the time
    * then we remove the root from toSort and return the result after the loop
    *
    * @time complexity since we want the runtime complexity I dont do the full formulas all the time. 
    *
    * the amount of executions (operations?) are commented after each statement.
    *
    * result : 
    *
    * N * O(maxHeapify) + N * O(removeRoot)
    * N * O(N / 2 * M * 3) + N * O(N)
    * N * O(N / 2 * M) + N * O(N)
    *
    *   equals
    *
    * O(M * N² + N²)  
    * 
    * But since M can only be two or three the worst case scenario (3) would have a time complexity of :
    *
    * O(3 * N² + N²) 
    *  results in
    * O(N²) 
    * 
    * Comment on Ternary vs Binary HeapSort:
    * 
    * Since the complexity is independent of mode, however the implimentation is far more complex, 
    * Ternary HeapSort can be more efficient in very specific use cases, however for a general 
    * sorting use Binary is more useful. 
    **/

  static int[] start(int[] toSort, boolean binaryHeap) {
    int[] sorted = new int[toSort.length];                        // 1 operation executed once
    int sortedIndex = toSort.length - 1;                          // 2 operations ..   
    int mod = binaryHeap? 2 : 3; // binary or ternary *modulo*    // 2 operations ..

    while(sortedIndex >= 0) {                                     // N times 
      toSort = maxHeapify(toSort, mod);                           // 1 * N * O(maxheapify)
      sorted[sortedIndex] = toSort[0];                            // 1 * N 
      sortedIndex--;                                              // 2 * N
      toSort = removeRoot(toSort);                                // 1 * N * O(removeRoot)
    }

    return sorted;                                                // 1 operation
  }

  /** @details
    * remove index 0 , decrease array size by 1
    * result is one smaller than toRemoveFrom since we decrease the size by 1
    * with the for loop we map through all elements in result which are empty
    * at the start of the loop, and we move all elements but the first from
    * toRemoveFrom to result. after the loop we return result
    *
    * @time complexity
    *
    * the executions are commented after each statement
    *
    * result : 
    * O(N)
    **/

  private static int[] removeRoot(int[] toRemoveFrom) {
    int[] result = new int[toRemoveFrom.length - 1];              // 2 operations executed once

    for(int x = 0 ; x < result.length ; x++) {                    // N times ( n being length of result )
      result[x] = toRemoveFrom[x + 1];                            // N * 2 operations
    }

    return result;                                                // 1 operation
  }

  /** @details 
    * edits array ~ swaps the two given indexes
    * saves index1 in temp, index1 becomes the same as index2
    * then index2 becomes temp.
    *
    * @time complexity
    *
    * the executions are commented after each line
    *
    * result :
    * O(3)
    **/
  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];                                     // 1 operation
    array[index1] = array[index2];                                // 1 operation
    array[index2] = temp;                                         // 1 operation
  }

  /** @details
    * maxheapifies the given array using swap()
    * we estimate the iterations needed for better performance
    * the second for loop increases offset , depending on the moda parent
    * might have multiple children, this loop makes sure every child gets compared
    * to the parent, and if needed , swapped.
    *
    * @time complexity
    * 
    * the executions are commented after each line
    *
    * result :
    *
    * N/2 * M * O(swap)
    *   equals
    * N/2 * M * O(3)
    **/
  private static int[] maxHeapify(int[] toHeapify, int mod) {
    int iterations = toHeapify.length / mod;                      // 2 operations ( notice we do length /2  ( N / 2 ) )

    for(int x = iterations ; x >= 0 ; x--) {                      // N/2 times
      for(int offset = 1 ; offset <= mod ; offset++) {            // N/2 * M times (mod is user input = M)
        int index = (x * mod) + offset;                           // N/2 * M * 3 operations

        if(index < toHeapify.length) {                            // N/2 * M * 1 operation
          if(toHeapify[index] > toHeapify[x]) {                   // N/2 * M * 1 operation
            swap(toHeapify, x, index);                            // N/2 * M * O(swap)
          }
        }
      }
    }
    return toHeapify;                                             // 1 operation
  }
}
