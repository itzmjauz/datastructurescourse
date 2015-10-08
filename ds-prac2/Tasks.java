package prac2;

public class Tasks {

  /* DATASTRUCTURES AND ALGORITHMS 2015-2016
  * Programming assignment 2
  * Deadline: Thursday October 8, 2015, before or at 23:59
  * 
  * Name(s) : Antoni Stevenet
  *           David Gall
  * VUid(s) : ast247
  *           dgl800
  */

  // --------------------------------------------------------
  //   METHODS FOR TASK 1 BELOW THIS LINE
  // --------------------------------------------------------
	
  public static int task1 (int[] a) {   
    return cut_rod1(a, a.length - 1);
  }

  private static int cut_rod1(int[] p, int n) {
    if(n == 0 ) {
      return 0;
    }

    int q = Integer.MIN_VALUE;
    
    for(int i = 1 ; i <= n ; i++) {
      q = max(q, p[i] + cut_rod1(p, n - i));
    }

    return q;
  }

  private static int max(int a, int b) {
    return (a > b)? a : b;
  }
  // --------------------------------------------------------
  //   METHODS FOR TASK 2 BELOW THIS LINE
  // --------------------------------------------------------
   
  public static int task2 (int[] a) { 
    return cut_rod2(a, a.length - 1);
  }

  private static int cut_rod2(int[] p, int n) {
    int[] val = new int[n+1];
    val[0] = 0;
    int i, j;

    for(i = 1 ; i <= n ; i++) {
      int max_value = Integer.MIN_VALUE;
      for(j = 0 ; j < i ; j++) {
        max_value = max(max_value, p[j] + val[i-j-1]);
        val[i] = max_value;
      }
    }

    return val[n];
  }
  
  // --------------------------------------------------------
  //   METHODS FOR TASK 3 BELOW THIS LINE
  // --------------------------------------------------------
  
  public static int task3 (int[][] m) { // m has size n x n (i.e. it is square)
    int h = Integer.MIN_VALUE;
    int v = Integer.MIN_VALUE;
    int d = Integer.MIN_VALUE;
    int c = Integer.MIN_VALUE;

    int size = m.length;

    for(int i = 0 ; i < size ; i++) {
      h = max(h, getMaxAdjSum(m[i]));
    }

    for(int j = 0 ; j < size ; j++) {
      int[] vlist = new int[size];

      for(int i = 0 ; i < size ; i++) {
        vlist[i] = m[i][j];
      }
      v = max(v, getMaxAdjSum(vlist));
    }

    int[] dlist;
    for(int k = 0 ; k < size * 2 ; k++) {
      if(k > size) {
        dlist = new int[size - (k - size)];
      } else {
        dlist = new int[k];
      }
      for(int j = 0 ; j <= k ; j++) {
        int i = k - j;
        if( i < size && j < size) {
          dlist[j] = m[i][j];
        }
      }
    }
      
    return h + v + d + c;
  }

  public static int[] reduce(int[] p) {
    int size = 0;
    int sum = 0;
    boolean positive = true;

    for(int i = 0 ; i < p.length ; i++) {
      if(i == 0 ) {
        size = 1;
        if(p[i] > 0) {
          positive = true;
        } else positive = false;
      }

      if(p[i] > 0 != positive) {
        size += 1;
        positive = !positive;
      }
    }

    int[] result = new int[size];
    sum = 0;
    int index = 0;

    for(int i = 0 ; i < p.length ; i++) {
      if(p[i] > 0 == positive) {
        sum += p[i];
        result[index] = sum;
      } else {
        index++;
        positive = !positive;
        sum = p[i];
      }
    }

    result[index] = sum;
    return result;
  }
}
