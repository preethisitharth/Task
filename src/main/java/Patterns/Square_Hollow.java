package Patterns;
import java.util.*;
public class Square_Hollow {
    public static void printpattern(int n) {
        int i;
        int j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
            {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
                {
                    System.out.println("*");
                }
                else
                {
                    System.out.println("");
                }
            }
        }
    }
        public static void main (String[]args)
        {
            int n = 6;
            printpattern(n);
        }
    }

