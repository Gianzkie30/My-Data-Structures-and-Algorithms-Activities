import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rev = "";

        System.out.println("Enter any word ");
        String word = sc.nextLine();

        for(int a = word.length()-1; a >= 0; a--){
            rev += word.charAt(a);
        }
        if(rev.equals(word)){
             System.out.println("PALINDROME");
        }
        else{
            System.out.println("NOT A PALINDROME");
          }

    }
}