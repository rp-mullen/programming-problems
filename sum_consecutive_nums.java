// given an integer num, return three integers as a sorted array
//that sum to num. If no such integers exist, return an empty array.

public class sum_consecutive_nums {
  public static void main(String[] args) {
    long[] inputs = new long[]{33,4,123,456234,89995483};

    for (int i = 0; i < inputs.length; i++) {
      System.out.print("N: " + inputs[i] + "------- Output: ");
      print(sumOfThree(inputs[i]));
    }
  }

  public static long[] sumOfThree(long num) {
    long n = 0;
    long[] result = new long[]{};

    // if this number exists, it must satisfy num == n + (n+1) + (n+2)
    n = (num/3) - 1;

    // verify (some results could be lossy due to integer division)
    if ((n + (n+1) + (n+2)) == num) {
        result = new long[]{n, n+1, n+2};
        return result;
    }
    else {
        return result;
    }
  }

  // printer function
  public static void print(long[] lst) {
    if (lst.length == 0) {
      System.out.print("[]\n");
    }
    else {
      System.out.print("[");
      for (int i = 0; i<lst.length-1; i++) {
          System.out.print(lst[i] + ", ");
      }
      System.out.print(lst[lst.length-1] + "] \n");
    }
  }
}
