// Copyright (c) 2018 Boomi, Inc.
package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author Abhishek Garg
 */

class Isogram {
    public static void main (String[] args) {
        //code

        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();

        while( noOfTestCases-- > 0 ){
            String inputStr = sc.next();
            if(inputStr.length() > 27 ){
                System.out.println('0');
                continue;
            }
            System.out.println(processString(inputStr.toCharArray()));
        }
    }

    private static String processString(char[] charArray){
        int[] count = new int[27];
        for(char c : charArray){
            int index = (int)c%97;
            count[index]++;
        }
        for(int i=0;i<27;i++){
            if(count[i]>1){
                return "0";
            }
        }
        return "1";
    }
}
