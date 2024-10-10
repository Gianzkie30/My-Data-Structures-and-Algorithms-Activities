 import java.util.LinkedList;

 public class Linkedlist {
     public static void main(String[] args) {
         // Create a LinkedList of Integers
         LinkedList<Integer> numbers = new LinkedList<>();

         // Adding elements to the LinkedList
         numbers.add(10);
         numbers.add(20);
         numbers.add(30);

         // Printing all elements of the LinkedList
         System.out.println("LinkedList elements:");
         for (int number : numbers) {
             System.out.println(number);
         }

         // Removing an element and adding at the end
         numbers.remove(1);  // Remove the element at index 1 (20)
         numbers.addLast(40); // Add 40 at the end

         System.out.println("\nAfter modification:");
         System.out.println(numbers);
     }
}