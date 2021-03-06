package br.com.dev.thiagomds.datastructure.Vectors.unordered;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class VectorUnordered {

    private static int[] vector;
    private static int lastPosition;
    private static int capacity;

    // Big O = O(n)
    public int[] createVector(int size){
        lastPosition = -1;
        capacity = size;
        return vector = new int[size];
    }

    // BIG O =  O(1) - O(2)
    public void insertVector(int number){
        if (lastPosition == (capacity - 1)){
            System.out.println( "Maximum Capacity Reached" );
        }
        else {
            lastPosition++;
            vector[lastPosition] = number;
        }
    }

    // BIG O = O(n)
    public int search(int number){
        int result = -1;

        for (int i=0; i < vector.length; i++){
            if(number == vector[i]) result = i;
        }
        return result;
    }

    public int delete(int number){
        int position = search(number);

        if(position == -1) return position;
        else{
            for (int i=position; i < lastPosition; i++){
                vector[i] = vector[i+1];
                vector[i+1] = 0;
            }
            lastPosition -= 1;
        }
        return position;
    }

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
