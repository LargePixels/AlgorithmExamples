package net.largepixels.algorithmexamples.sorting;

import java.util.Arrays;

/**
 * Created by johnminchuk on 2/24/16.
 *
 * My implementation of mergesort
 */
public class MergeSortEx2 {

    public static void main(String a[]){

        int[] arr = {33, 23, 54, 13, 84, 23, 87, 42, 39, 84};
        //int[] arr = {33, 23, 54};

        MergeSortEx2 mergeSortEx2 = new MergeSortEx2();

        System.out.println(Arrays.toString(arr));

        int[] sorted = mergeSortEx2.sort(arr);

        System.out.println(Arrays.toString(sorted));

    }

    public int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }

    private int[] mergeSort(int[] arr, int start, int end) {
        if ( start == end) {
            return new int[]{arr[start]};
        }

        int mid =  ( end - start ) / 2;
        mid = start + mid;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);

        return sortThem(left, right);
    }

    private int[] sortThem(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];

        int ls = 0;
        int rs = 0;
        int runner = 0;

        while ( ls < left.length && rs < right.length ) {
            if ( left[ls] < right[rs] ) {
                temp[runner] = left[ls];
                ls++;
            }
            else {
                temp[runner] = right[rs];
                rs++;
            }
            runner++;
        }

        //throw what's remaining of left or right array onto temp
        while (runner < temp.length) {
            if ( ls < left.length ) {
                temp[runner] = left[ls];
                ls++;
            }
            else {
                temp[runner] = right[rs];
                rs++;
            }
            runner++;
        }

        return temp;
    }

}
