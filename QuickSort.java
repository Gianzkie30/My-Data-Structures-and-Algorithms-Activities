import java.util.Scanner;

public class QuickSort {

    // Method to swap two elements
    static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    // Partition method for Quick Sort
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int a = (low - 1);     // Index of smaller element

        for (int b = low; b < high; b++) {
            // If  element is smaller than or equal to the pivot
            if (arr[b] <= pivot) {
                a++;
                swap(arr, a, b);
            }
        }

        swap(arr, a + 1, high);
        return (a + 1);
    }

    // define quick sort method
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);        // Sort elements before partition
            quickSort(arr, pi + 1, high);       // Sort elements after partition
        }
    }

    // Method to print the array
    static void printArray(int[] arr, int size) {
        for (int a = 0; a < size; a++) {
            System.out.print(arr[a] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get a size of the user for array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        // Get a user input for array elements
        System.out.println("Enter the elements of the array:");
        for (int a = 0; a < size; a++) {
            arr[a] = scanner.nextInt();
        }
        quickSort(arr, 0, size - 1);

        // Function to the sorted array
        System.out.println("Sorted array:");
        printArray(arr, size);
    }
}