import java.util.Scanner;
class BubbleSort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
class TapeStorage {
    public double calculateOptimalTime(int[] programLengths) {
        // Step 1: Sort the program lengths in non-decreasing order using Bubble Sort
        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(programLengths);

        // Step 2: Calculate the sum of all prefix sums
        int n = programLengths.length;
        int totalTime = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += programLengths[i];
            totalTime += prefixSum;
        }

        // Step 3: Calculate the average retrieval time
        return (double) totalTime / n;
    }
}


public class tape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of programs: ");
        int n = scanner.nextInt();

        int[] programLengths = new int[n];
        System.out.println("Enter the length of each program:");
        for (int i = 0; i < n; i++) {
            programLengths[i] = scanner.nextInt();
        }

        TapeStorage tapeStorage = new TapeStorage();
        double optimalTime = tapeStorage.calculateOptimalTime(programLengths);

        System.out.println("\nProgram lengths sorted in optimal order:");
        for (int length : programLengths) {
            System.out.print(length + " ");
        }
        
        System.out.println("\n\nMinimum average retrieval time: " + optimalTime);
        scanner.close();
    }
}