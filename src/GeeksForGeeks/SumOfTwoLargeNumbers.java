// Copyright (c) 2018 Boomi, Inc.
package GeeksForGeeks;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Abhishek Garg
 */
public class SumOfTwoLargeNumbers
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTest = sc.nextInt();

        while(numberOfTest-- > 0){
            BigInteger x = sc.nextBigInteger();
            BigInteger y = sc.nextBigInteger();
            BigInteger sum = x.add(y);
            if(String.valueOf(sum).length() == String.valueOf(x).length()){
                System.out.println(sum);
            }else{
                System.out.println(x);
            }
        }
    }
}
