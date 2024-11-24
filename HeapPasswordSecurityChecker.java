import java.util.Scanner;

public class HeapPasswordSecurityChecker {

    private static class MaxHeap {
        private String[] heap;
        private int size;

        // The constructor to initialize the heap with a given capacity.
        public MaxHeap(int capacity) {
            heap = new String[capacity];
            size = 0;
        }

        // If the heap is full, it resizes automatically.
        public void add(String password) {
            if (size == heap.length) {
                resize();
            }
            heap[size] = password;
            heapifyUp(size);
            size++;
        }
         //To checks if the given password exists in the heap.
        public boolean contains(String password) {
            for (int a = 0; a < size; a++) {
                if (heap[a].equals(password)) {
                    return true;
                }
            }
            return false;
        }
         // This funtion displays all the unavailable passwords
        public void display() {
            if (size == 0) {
                System.out.println("No passwords available.");
                return;
            }
            for (int a = 0; a < size; a++) {
                System.out.println(heap[a]);
            }
        }
         //It compares the element with its parent and swaps them.
        private void heapifyUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap[index].length() <= heap[parentIndex].length()) {
                    break;
                }
                swap(index, parentIndex);
                index = parentIndex;
            }
        }

        private void swap(int a, int b) {
            String temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
        // This method is used to resize the heap array when the heap reaches its capacity.
        private void resize() {
            String[] newHeap = new String[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }
     // Define a main method.
    public static void main(String[] args) {
        MaxHeap passwordHeap = new MaxHeap(10);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Password Security Checker");

        // To loop with the four options continously.
        while (!exit) {
            System.out.println("\nSelect Options:");
            System.out.println("1. Add Password");
            System.out.println("2. Verify Password");
            System.out.println("3. Show All Passwords");
            System.out.println("4. Exit");
            System.out.print("Enter the number of option(1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // To add passwords.
                    System.out.print("Enter a password to add: ");
                    String password = scanner.nextLine();
                    passwordHeap.add(password);
                    System.out.println("Password added.");
                    break;

                case 2: //To verify the password.
                    System.out.print("Enter a password to verify: ");
                    String toVerify = scanner.nextLine();
                    if (passwordHeap.contains(toVerify)) {
                        System.out.println("Password verified successfully!!");
                    } else {
                        System.out.println("Password not found.");
                    }
                    break;

                case 3: //To display inorder the passwords.
                    System.out.println("Passwords in the system in order:");
                    passwordHeap.display();
                    break;

                case 4: // To exit the programm.
                    System.out.println("Thank you for trusting this system. Try again if you want");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
