import java.util.Scanner;
public class InsertionSort{
	//Method to perform Insertion Sort
    public static void InsertionSort(int[] array){
        for(int a = 0; a < array.length; a++){
            int key = array[a]; //The elements to be inserted
            int b = a - 1;
            while(b >= 0 && array[b] > key){
                array[b+1] = array[b];
                b--;
            }
            array[b+1] = key;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //input the size of the array
        System.out.print("Enter size of an array: ");
        int size = sc.nextInt();
        int array[] = new int [size];
        //input the elements of the array
        System.out.println("Enter an elements of an array:");
        for(int a = 0; a < size; a++){
            array[a] = sc.nextInt();
        }
        //Perform insertion sort
        InsertionSort(array);

        //Output of the Sorted Array
        System.out.print("Sorted Array: ");
        for(int a = 0; a < size; a++){
            System.out.print(array[a] + " ");
        }
        //new line
        System.out.println();
    }
}
