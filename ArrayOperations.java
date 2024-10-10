import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Linear Search
        System.out.print("Enter the value to search using Linear Search: ");
        int target = sc.nextInt();
        int linearResult = linearSearch(array, target);
        System.out.println("Linear Search result: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));

        // Binary Search (Sorted Array)
        Arrays.sort(array);
        System.out.println("Sorted array for binary search: " + Arrays.toString(array));
        System.out.println("Enter the value to search using Binary Search: ");
        target = sc.nextInt();
        int binaryResult = binarySearch(array, target, 0, array.length - 1);
        System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));

        // Sorting
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
        int choice = sc.nextInt();

        int[] sortedArray = Arrays.copyOf(array, array.length);
        switch (choice) {
            case 1:
             bubbleSort(sortedArray);
             break;
            case 2:
             insertionSort(sortedArray);
             break;
            case 3:
             selectionSort(sortedArray);
             break;
            case 4:
             mergeSort(sortedArray, 0, sortedArray.length - 1);
             break;
            case 5:
             quickSort(sortedArray, 0, sortedArray.length - 1);
             break;
            default:
            System.out.println("Invalid choice");
             break;
        }

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
     }

    // 1. Linear Search
    public static int linearSearch(int[] array, int target) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1; // Placeholder
    }

    // 2. Binary Search (works only on sorted arrays)
    public static int binarySearch(int[] array, int target, int low, int high) {
        if(low <= high){
            int mid = (low + high)/2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target){
                return binarySearch(array, target, low, mid-1);
            }
            else{
                return binarySearch(array,target,mid+1,high);
            }
        }
        return -1; // Placeholder
    }

    // 3. Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // 4. Insertion Sort
    public static void insertionSort(int[] array) {
        for(int i = 0; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    // 5. Selection Sort
    public static void selectionSort(int[] array) {
        for(int i = 0; i < array.length-1; i++){
            int gian = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[gian]){
                    gian = j;
                }
            }
            int temp = array[gian];
            array[gian] = array[i];
            array[i] = temp;
        }
    }

    // 6. Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] Left = new int[n1];
        int[] Right = new int[n2];

        System.arraycopy(array,left,Left,0,n1);
        System.arraycopy(array,mid+1,Right,0,n2);

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(Left[i] <= Right[j]){
                array[k++] = Left[i++];
            }
            else{
                array[k++] = Right[j++];
            }
        }
        while(i < n1){
            array[k++] = Left[i++];
        }
        while(j < n2){
            array[k++] = Right[j++];
        }
    }

    // 7. Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if(low < high){
            int pi = partition(array,low,high);
            quickSort(array,low,pi-1);
            quickSort(array,pi + 1,high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int partition = array[high];
        int i = (low - 1);
        for(int j = low; j < high; j++){
            if(array[j] < partition){
                i++;
                int c = array[i];
                array[i] = array[j];
                array[j] = c;
            }
        }
        int c = array[i + 1];
        array[i + 1] = array[high];
        array[high] = c;

        return -1; // Placeholder
    }
}