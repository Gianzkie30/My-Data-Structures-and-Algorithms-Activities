import java.util.Scanner;
public class Selection{
	//Method to perform Selection Sort
public static void Selection(int[] array) {
	//The elements to be selected
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
     public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	         //input the size of the array
	        System.out.print("Enter size of an array: ");
	        int size = sc.nextInt();
	        int array[] = new int [size];
	        System.out.println("Enter an elements of an array:");
	        for(int i = 0; i < size; i++){
	            array[i] = sc.nextInt();
	        }
	        //Perform selection sort
	        Selection(array);
	                //Output of the Sorted Array
			        System.out.print("Sorted Array: ");
			        for(int a = 0; a < size; a++){
			            System.out.print(array[a] + " ");
			        }
			        //newline
			        System.out.println();
			    }
			}


