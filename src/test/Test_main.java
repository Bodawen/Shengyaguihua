package test;

import DB_handle.DB_basic_handle;

import java.io.*;
import java.util.ArrayList;

public class Test_main {
    public static void main(String arg[]){
        int[][] a = new int[3][3];
        a = new int[][]{{1, 2, 3},
                        {6, 5, 4},
                        {10, 8, 9}};
        int col_number = 0;
        int row_number = 0;
        for (int i = 0; i < a.length; i++) {
            int b = a[i][0];
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]<=b){
                    b = a[i][j];
                    col_number = j;
                }
            }
            for (int k = 0; k < a.length; k++) {
                if (b < a[k][col_number]){
                    break;
                }else {
                    row_number = k;
                }
            }

        }
        System.out.println(row_number+" " +col_number);
    }
}
