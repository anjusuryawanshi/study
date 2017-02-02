package com.anju.misssingelement;

/**
 * Created by mystique on 4/15/16.
 */
public class MissingElement {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int arr2[] = {1,3,4};

        int sumArray = 0;
        int sumArray2 = 0;

        for(int i = 0; i < arr.length; i++) {
            sumArray = sumArray + arr[i];
        }

        for(int i = 0; i < arr2.length; i++) {
            sumArray2 = sumArray2 + arr2[i];
        }

        int missingElement = Math.abs(sumArray - sumArray2);

        System.out.println("Missing element = " + missingElement);

    }
}
