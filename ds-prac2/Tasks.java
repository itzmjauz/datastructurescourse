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

    for(int i = 0 ; i < (m.length - 1) ; i++) {
      for(int j = 0 ; j < (m.length - 1); j++) {
        h = max(h, m[i][j] + m[i][j+1]);
      }
    }
    return 0;
  }

}
