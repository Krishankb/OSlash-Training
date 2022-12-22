package org.example;

import java.util.Scanner;

public class factorial {

    public static int recursiveCall(int num) {
        if (num>=1) {
            return num * recursiveCall(num-1);
        }
        else {
            return 1;
        }
    }

    public static void  iterativeCall(int num) {
        int res = 1;
        while(num>0) {
            res *= num;
            num--;
        }
        System.out.println("The iterative call "+res);
    }

    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        iterativeCall(number);
        int res = recursiveCall(number);
        System.out.println("The recursive call "+res);
    }

}
