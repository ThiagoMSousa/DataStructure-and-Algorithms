package br.com.dev.thiagomds.datastructure.Vectors.ordered;

public class VectorOrdered {

    private static int[] vector;
    private static int lastPosition;
    private static int capacity;

    // Big O = O(n)
    public int[] createVector(int size){
        lastPosition = -1;
        capacity = size;
        return vector = new int[size];
    }

    // Big O = O(n)
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

    public int search(int number){
        int result = -1;
        for ( int i=0; i < vector.length; i++ ){
            if (vector[i] == number){
                result = i;
                break;
            }
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
