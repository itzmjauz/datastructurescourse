import java.util.Arrays;

class Heap {

  //General

  /*
  This function implements the algorithm to determine the parent of any node
  in an Array representation of Heaps.
  */
  public static int parent(int index) {
    int x = index - 1;
    return (int) x / 2;
  }

  /*
  This Function returns the index of the first child of any node. The value
  returned needs to have 1 subtracted to reflect the Java representation of
  Array Index.
  */
  public static int leftChild(int index) {
    int left = index * 2;
    return left;
  }

  /*
  This function swaps two indexes in an array and returns the modified array
  */
  public static int[] swap(int a, int b, int[] list) {
    int x = list[a];
    int y = list[b];
    list[b] = x;
    list[a] = y;
    return list;
  }


  /*
  This function appends an item to an array, as this is a feature of Java
  that needs to be imported.
  */
  public static int[] append(int[] input, int item) {
    int index = input.length + 1;
    int[] list = new int[index];

    for (int i = 0 ; i < index - 1 ; i++) {
      list[i] = input[i];
    }
    list[index - 1] = item;
    return list;
  }

  /*
  This function removes the final element of an array and returns an array
  with the correct size memory allocation.
  */
  public static int[] pop(int[] input) {
    int index = input.length - 1;
    int[] list = new int[index];
    for (int i = 0 ; i < index ; i++) {
      list[i] = input[i];
    }
    return list;
  }

  //Additions

  /*
  This function performs the addition of elements to the heap. This function
  sets the correct initialization variables which are then passed to a
  recursive function. The new element is added to the end of the Heap-Array
  and is then properly swapped until the heap property is satisfied.
  */
  public static int[] addItem(int[] input, int item) {
    int[] list = append(input, item);
    int index = list.length - 1;
    return recurseAdd(list, index);
  }

  /*
  Using the parent() function this function recursively swaps the newly added
  element to satisfy the Heap-Property. Each iteration determines whether the
  parent is greater in value than the element and based on this swaps the
  values using the swap() function. The function then calls itself to perform
  the same action for the new position of the added element.

  Time Complexity:


  */
  public static int[] recurseAdd(int[] list, int index) {
    if (index == 0) {
      return list;
    }
    else {
      int x = parent(index);
      if (list[x] > list[index]) {
        list = swap(x, index, list);
        return recurseAdd(list, x);
      }
      else {
        return list;
      }
    }
  }

  //Removal

  /*
  This function defines the initialization parameters for the recursive
  function that removes an element from the Heap and afterwards corrects
  to maintain the Heap-Property.
  */
  public static int[] removeItem(int[] input, int index){
    input[0] = input[input.length - 1];
    input = pop(input);

    return recurseSift(input, index);
  }

  /*
  This function uses the leftChild() function to determine the children
  of an element in the heap and based on this recursively adjusts to
  preserve Heap-Property. Once it has found the children of a node it
  compares their values and recursively calls itself to perform the
  same actions for all children nodes until the entire heap has been
  corrected.

  Time Complexity:


  */
  public static int[] recurseSift(int[] list, int index) {
    int left = leftChild(index);
    int right = left + 1;
    if (left >= list.length && right >= list.length) {
      return list;
    }
    if (list[left - 1] < list[right - 1]) {
      list = swap(left - 1, index - 1, list);
      return recurseSift(list, left);
    } else {
      list = swap(right - 1, index - 1, list);
      return recurseSift(list, right);
    }
  }

  //Sorting

  /*
  Using the addItem() and removeItem() functions this implements the
  heapsort. The input array int[] in is added using the addItem()
  function iteratively. Following this each root is removed and the
  heap property is corrected using removeItem().

  Time Complexity:
  */
  public static int[] heapsort(int[] in) {
    int[] input = {in[0]};
    for (int i = 1 ; i < in.length ; i++) {
      //System.out.println(in[i]);
      input = addItem(input, in[i]);
    }
    int[] sort = {input[0]};
    while (input.length != 1) {
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
