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
      h = max(h, kadane(m[i]));
    }

    for(int j = 0 ; j < size ; j++) {
      int[] vlist = new int[size];

      for(int i = 0 ; i < size ; i++) {
        vlist[i] = m[i][j];
      }
      v = max(v, kadane(vlist));
    }

    //diagonals here
    int[] dlist;
    for(int slice = 0 ; slice < 2 * size - 1 ; slice++) {
      int z = (slice < size)? 0 : slice - size + 1;
      dlist = new int[slice - z + 1];
      for(int j = z ; j <= slice - z ; j++) {
        dlist[j] = m[j][slice - j];
      }
      d = max(d, kadane(dlist));
    }
    
    int[] adlist;
    for(int slice = 0 ; slice < 2 * size - 1 ; slice++) {
      int z = (slice < size)? 0 : slice - size + 1;
      adlist = new int[slice - z + 1];
      for(int j = z ; j <= slice - z ; j++) {
          adlist[j] = m[j][size - 1 - (slice - j)];
      }
      c = max(c, kadane(adlist));
    }
    return h + v + d + c;
  }

  private static int getMaxAdjSum(int[] a) {
    return 0;
  }

	public static int kadane(int[] a) {
		//apply kadane's algorithm
		int max_so_far = 0;
		int max_ending_here = 0;


		for(int i = 0 ; i < a.length ; i++ ) {
			max_ending_here = max_ending_here + a[i];

			if(max_ending_here < 0) {
				max_ending_here = 0;
			}

			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}

		return max_so_far;
	}
}


