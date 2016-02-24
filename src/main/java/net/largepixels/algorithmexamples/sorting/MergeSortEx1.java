package net.largepixels.algorithmexamples.sorting;

import java.util.Arrays;

/**
 * This is a sort of failed attempt at implementing mergesort, I wussed out and did a bubble sort on the final step.  It's a good overview of how it works though
 */
public class MergeSortEx1 {


    public static void main(String a[]){

        int[] arr = {33, 23, 54, 13, 84, 23, 87, 42, 39, 84};

        MergeSortEx1 mergeSortEx1 = new MergeSortEx1();

        System.out.println(Arrays.toString(arr));

        mergeSortEx1.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if ( start == end) {
            return;
        }

        int mid =  ( end - start ) / 2;
        mid = start + mid;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        sortThem(arr, start, end);
    }

    private void sortThem(int[] arr, int start, int end) {
        int runner = start;
        int[] temp = new int[(end - start) + 1];

        for ( int i = start; i <= end; i++ ) {
            int smallest = arr[i];
            int position = i;
            for ( int x = i; x <=end; x++ ) {
                if ( arr[x] < smallest ) {
                    smallest = arr[x];
                    position = x;
                }
            }

            int temper = arr[position];
            arr[position] = arr[i];
            arr[i] = temper;
        }

    }

}
