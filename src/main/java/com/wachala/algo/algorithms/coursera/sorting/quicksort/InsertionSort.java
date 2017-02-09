package com.wachala.algo.algorithms.coursera.sorting.quicksort;

public class InsertionSort {

    public static void sort(Comparable array[]){
        sort(array, 0, array.length-1);
    }

    public static void sort(Comparable array[], int start, int end){
        for(int i=start+1;i<=end;i++){
            int j=i;

            while(j>start && array[j].compareTo(array[j-1])<0){
                Comparable tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;

                j--;
            }
        }
    }
}
