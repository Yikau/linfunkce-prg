package com.company;

import java.util.ArrayList;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<LinearFunction> arrFunctions = new ArrayList<>();

        try {
                BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
                String nextLine = br.readLine();
            while (nextLine != null) {
                    LinearFunction function = new LinearFunction();
                String[] we = nextLine.substring(3).split(" " + (char) 42 + " ");


                    function.a = Integer.parseInt(we[1].substring(0, we[1].length() - 1) ) ;
                    function.b = Integer.parseInt(we[3]);

                arrFunctions.add(function);
                    nextLine = br.readLine();
            }
        }   catch (FileNotFoundException e) {
                e.printStackTrace();
        }   catch (IOException e) {
                e.printStackTrace();
        }

        int poc = arrFunctions.size();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
                    bw.write(poc + "");
                    bw.close();
        }   catch (IOException e) {
                System.out.println(e);
        }

        int stejny = 0;
            int srv = 0;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("count_distinct.txt"));

            for (int i = 0; i < arrFunctions.size(); i++) {
                int dup = 0;

                int wa = arrFunctions.get(i).a;
                    int wr = arrFunctions.get(i).b;

                for (LinearFunction arrFunction : arrFunctions) {
                        int wa2 = arrFunction.a;
                        int brm = arrFunction.b;

                    if (wa == wa2 && wr == brm) {
                            dup++;
                    }
                }
                    if (dup >= 2) {
                        stejny++;
                }
            }
                srv = arrFunctions.size() - stejny;

                bw.write(String.valueOf(srv));

            bw.close();
        }       catch (IOException e) {
                    System.out.println(e);
        } }
}