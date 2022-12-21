package org.example;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {

    public static void main(String[] args) {
        String fname;
        File f;
        Scanner sc=null;
        String currentLine;
        for(int i=1;i<= 5;i++){
            fname = "testFile" + i + ".txt";
            try {
                f = new File(fname);
                sc = new Scanner(f);
            } catch (FileNotFoundException e) {
                System.out.println("Problem opening the file.");
                e.printStackTrace();
                return;
            }

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                currentLine = sc.nextLine();
                Pattern pattern = Pattern.compile("te");
                Matcher matcher = pattern.matcher(currentLine);
                if(matcher.find()) {
                    System.out.println(fname + ": " + currentLine);
                }
            }



       
        }





    }
}
