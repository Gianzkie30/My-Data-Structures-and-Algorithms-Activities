import java.util.Scanner;

public class LinearSearch{
public static int linearSearch(int array[], int b) {
    int n = array.length;

      for (int a = 0; a < n; a++) {
      if (array[a] == b)
        return a;
    }
    return -1;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    // input size
    System.out.print("Enter the number of elements: ");
    int n = sc.nextInt();

    int array[] = new int[n];
    //input elements
    System.out.println("Enter " + n + " the elements of the array: ");
    for (int a = 0; a < n; a++) {
      array[a] = sc.nextInt();
    }


    System.out.println("Enter the target element to search: ");
    int b = sc.nextInt();
      //perform linear
    int result = linearSearch(array, b);

    if (result == -1)
      System.out.println("Element not found");
    else
      System.out.println("Element found at index: " + result);
  }
}