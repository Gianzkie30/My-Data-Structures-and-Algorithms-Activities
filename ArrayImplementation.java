public class ArrayImplementation{
    public static void main(String[] args) {
        // Initialize an array of size
        int[] numbers = new int[5];

        // Assign values to the array
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Print the array elements
        System.out.println("Array elements are:");
        for (int a = 0; a < numbers.length; a++) {
            System.out.println("Element at index " + a + ": " + numbers[a]);
        }
    }
}