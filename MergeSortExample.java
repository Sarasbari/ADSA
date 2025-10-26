import java.util.Scanner;

public class MergeSortExample
{

    // Recursive function to perform Merge Sort
    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) // Base condition: if the subarray has more than one element
        {
            int mid = (left + right) / 2; // Find the middle index

            // Recursively sort the first half
            mergeSort(arr, left, mid);

            // Recursively sort the second half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays into a single sorted subarray
    public static void merge(int[] arr, int left, int mid, int right)
    {
        // Temporary array to store merged result
        int[] temp = new int[right - left + 1];
        
        int i = left;     // Pointer for first half
        int j = mid + 1;  // Pointer for second half
        int k = 0;        // Pointer for temp array

        // Merge both halves by comparing elements one by one
        while (i <= mid && j <= right)
        {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        // Copy remaining elements from the first half, if any
        while (i <= mid)
        {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the second half, if any
        while (j <= right)
        {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements from temp[] back into arr[]
        for (int m = 0; m < temp.length; m++)
        {
            arr[left + m] = temp[m];
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input: Number of elements in the array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Array creation
        int[] arr = new int[n];

        // Input: Array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Display array before sorting
        System.out.println("Before sorting:");
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
        System.out.println();

        // Call merge sort function
        mergeSort(arr, 0, arr.length - 1);

        // Display array after sorting
        System.out.println("After sorting:");
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close(); // Close scanner to avoid resource leaks
    }
}
