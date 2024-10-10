import java.util.Arrays;
import java.util.Scanner;
public class BubbleSort{
	//initialize bubble sort method
	public static void bubbleSort(int[] array) {
		        int size = array.length; //input size of array length
		        //Then, add nested loop
		        for(int i = 0; i < size-1; i++){
		            for(int j = 0; j < size-i-1;j++){
		                if(array[j] > array[j+1]){
		                    int temp = array[j];
		                    array[j] = array[j+1];
		                    array[j+1] = temp;
		                }
		            }
		        }
		}
		//Define another method to call the bubble sort method
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a size of elements: ");
		//input size from the user to store array.@length
		int size = sc.nextInt();
		int array[] = new int [size];
		System.out.println("Enter " + size + " elements ");
		for(int a = 0; a < size; a++){
			array[a] = sc.nextInt();
		}
         int[] sortedArray = Arrays.copyOf(array,array.length);
         //initialize this method to form an ascending order
         bubbleSort(sortedArray);
         System.out.println("Ascending Order: " + Arrays.toString(sortedArray));
     }
  }
