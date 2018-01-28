package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author Abhishek Garg
 */
public class EaseTheArray
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();

        while( noOfTestCases-- > 0 ){
            int arraySize = sc.nextInt();
            String arrayInputString = sc.next();
            String[] arrayString = arrayInputString.split(" ");
            int[] inputArray = new int[arraySize];
            for(int i=0;i<arrayString.length;i++){
                inputArray[i] = Integer.parseInt(arrayString[i]);
            }
            modifyAndPrintArray(arraySize, inputArray);
        }
    }

    private static void modifyAndPrintArray(int size, int[] inputArray){
        for(int i=0;i<size-1;i++){
            if(inputArray[i]!=0 && inputArray[i+1]!=0 && inputArray[i]==inputArray[i+1]){
                inputArray[i] *= 2;
                inputArray[i+1] = 0;
            }
        }
        int count=0;
        for(int k=0;k<=size-1;k++) {
            if(inputArray[k]!=0) {
                inputArray[count++] = inputArray[k];
            }
        }
        while(count<=size-1){
            inputArray[count++]=0;
        }
        for(int i=0;i<inputArray.length;i++){
            System.out.print(String.valueOf(inputArray[i])+" ");
        }
    }

    /**
     * Input:
     2
     5
     2 2 0 4 4
     5
     0 1 2 2 0
     Output:
     4 8 0 0 0
     1 4 0 0 0
     */
}
