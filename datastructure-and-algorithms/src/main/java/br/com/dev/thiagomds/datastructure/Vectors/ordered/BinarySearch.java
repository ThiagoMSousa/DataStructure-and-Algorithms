package br.com.dev.thiagomds.datastructure.Vectors.ordered;

public class BinarySearch {

    private static int[] vector;
    private static int lastPosition;
    private static int capacity;

    // Big O = O(n)
    public int[] createVector(int size){
        lastPosition = -1;
        capacity = size;
        return vector = new int[size];
    }

    public void insertVector(int number){
        if(lastPosition == (capacity-1)){
            System.out.println( "Maximum Capacity Reached" );
        }

        int position = 0;
        for (int i=0; i <= lastPosition+1; i++){
            position = i;
            if (vector[i] > number) {
                break;
            }
            if(i == lastPosition){
                position += 1;
            }
        }

        int auxiliaryPosition = lastPosition;
        while (auxiliaryPosition >= position){
            vector[auxiliaryPosition+1] = vector[auxiliaryPosition];
            auxiliaryPosition -=1;
        }
        vector[position] = number;
        lastPosition += 1;
    }

    // Big O = Log(n)
    public static int binarySearchIterative(int number) {
        int begin = 0;
        int end = vector.length - 1;
        while (begin <= end) {
            //Calculate the mean
            int middle = (begin + end) / 2;
            if (number == vector[middle]) {
                return middle; //Element was found
            } else if (number > vector[middle]) {
                begin = middle + 1;//Search will continue in the right subarray
            } else {
                end = middle - 1; //search will continue in the left subarray
            }
        }
        return -1;//Element is not in the array
    }

    // Big O = O(n)
    public void printVector(){
        if (lastPosition == -1)
            System.out.println("Vector is Empty !!!");
        else {
            for (int i=0; i < vector.length; i++) {
                System.out.printf("%sº Position: %s \n", (i), vector[i]);
            }
        }
    }
}
