package Lab__01;

import java.util.Scanner;
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        double average = (double) sum / n;

        Arrays.sort(a);

        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}