package com.example.prj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc {

    static String ar1="";
    static int size;
    static int flag=0;
    static String stre="";

    public void scan(String bath) throws FileNotFoundException {

        File file = new File(bath);
        Scanner scan = new Scanner(file);
        int c=0;
        size = scan.nextInt();

        while (scan.hasNextInt() && c <= size){
          ar1 += scan.nextInt() + " ";
          c++;
        }

        if (c != size){
            flag = 1;
        }

    }

    public String fun() throws FileNotFoundException {

        int arr1[] = new int[size + 1];

        String str;
        int space, num, max;
        if (flag == 0){
            for (int c = 1; c <= size; c++) {

                space = ar1.indexOf(" ");

                if (c <= size) {
                    str = ar1.substring(0, space);
                    ar1 = ar1.substring(space + 1);
                    num = Integer.parseInt(str);
                } else {

                    num = Integer.parseInt((ar1.trim()));
                }

                arr1[c] = num;

            }

            for (int i=1;i<=size;i++){

                for (int y=1;y<=size;y++){

                    if (i == arr1[y]){
                        y=size+1;
                    }
                    else if (i != arr1[y] && y==size) {
                        flag = 1;
                    }
                }
            }
            if (flag == 1){
                return "y";
            }


        String arr[][] = new String[size + 1][size + 1];


        for (int i=0;i<=size;i++){
            arr[0][i] = 0+" e";
        }
        for (int i=0;i<=size;i++){
            arr[i][0] = 0+" e";
        }
        int n,n1;
        for (int i = 1; i <= size; i++) {
            for (int g = 1; g <= size; g++) {
                int spacee;
                if (arr1[i] == g) {

                     spacee = arr[i - 1][g - 1].indexOf(" ");
                    n = Integer.parseInt(arr[i - 1][g - 1].substring(0,spacee));

                    n++;
                    arr[i][g] = n+" a";

                } else {
                    spacee = arr[i - 1][g ].indexOf(" ");
                    n = Integer.parseInt(arr[i - 1][g].substring(0,spacee));
                    spacee = arr[i][g - 1].indexOf(" ");
                    n1 = Integer.parseInt(arr[i][g - 1].substring(0,spacee));
                    if (n >= n1) {
                        arr[i][g] = n +" b";
                    } else {
                        arr[i][g] = n1+" c";
                    }

                }

            }
        }

        for (int i=0;i<arr.length;i++){
            for (int y=0;y<arr[i].length;y++){
                stre += arr[i][y]+"|";
            }
            stre += "\n";
        }

        int f=0;
        int i=size;
        int x = size;
        int arr2[] = new int[size+1];

        for (int z=1;z<= size;z++){
            arr2[z]=z;

        }
        String ans="";
        int d=0;
            while(i != 0 && x != 0){
                    int space1 = arr[x][i].indexOf(" ");
                if ( (arr[x][i].substring(space1+1)).equalsIgnoreCase("b") ){
                    x--;
                }
                else if ( (arr[x][i].substring(space1+1)).equalsIgnoreCase("c") ){
                    i--;
                }
                else{
                   ans += arr2[i] +" ";
                   d++;
                    i--;
                    x--;
                }
            }
            ans +=d;
            return ans;
    }
        else{
            return "y";
        }

    }


}

