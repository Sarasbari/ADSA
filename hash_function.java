
import java.util.Scanner;

public class hash_function {

    public static int asciivalue(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sum += (int) c;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String userinput = sc.nextLine();

        int hashvalue = asciivalue(userinput);
        System.out.println("acii value: " + hashvalue);
    }
}
