// Copyright (c) 2018 Boomi, Inc.
package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author Abhishek Garg
 */
public class TrimorphicNumber
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();

        while( noOfTestCases-- > 0 ){
            int number = sc.nextInt();
            int remainder = (number * number * number)%divisor(number);
            System.out.println(remainder == number ? "1" : "0");
        }
    }

    private static int divisor(int number)
    {
        int pow = 0;
        while(number!=0)
        {
            number /= 10;
            pow++;
        }
        return (int) Math.pow(10,pow);
    }

    //fixme for number greater than 5625
}
