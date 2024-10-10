import java.util.Arrays;
import java.util.Scanner;

class BinarySearch{
	//binary search method
    public static int binarySearch(int array[], int b) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == b)
                return mid;

            if (array[mid] < b)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         //input a size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int array[] = new int[n];

        System.out.println("Enter " + n + " a number of elements: ");
        for (int a = 0; a < n; a++) {
            array[a] = sc.nextInt();
        }

        Arrays.sort(array);
        System.out.println("Array after entering the elements: " + Arrays.toString(array));

        System.out.print("Enter the target element to search: ");
        int b = sc.nextInt();
        //perform binary search
        int result = binarySearch(array, b);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}