import java.util.*;

public class HashFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of table :");
        int size = sc.nextInt(); // size of hash table
        
        int hashTable[] = new int[size];
        Arrays.fill(hashTable, -1); // -1 means empty

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            int index = key % size; // simple hash function

            // Linear probing for collision handling
            while (hashTable[index] != -1)
                index = (index + 1) % size;

            hashTable[index] = key;
        }

        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++)
            System.out.println(i + " --> " + hashTable[i]);

            sc.close();
    }
}
