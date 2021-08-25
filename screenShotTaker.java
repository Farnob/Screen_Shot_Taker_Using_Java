package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class screenShotTaker {
    public static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        try{
            Thread.sleep(20);
            Robot r = new Robot();

            //It saves screenshot to desired path;
            String path = "/home/fahmidur/screenShot.jpg";

            //used to get screensize and capture image
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = r.createScreenCapture(capture);
            ImageIO.write(Image, "jpg", new File(path));
            System.out.println("Screen Shot saved");
        }
        catch(AWTException | IOException | InterruptedException ex){
            System.out.println(ex);
        }
    }

    static void printArray(int arr[], int size){
        int i;
        for(i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //This function converts any positive int to negative int;and if the given int is alerady in int than it prints that negative int;
    static int makeNegative(int number){
        if(number <= 0){
            return number;
        }
        return number - (number * 2);
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    public static long gcd(long a, long b) {
        if (a > b)
            a = (a + b) - (b = a);
        if (a == 0L)
            return b;
        long gcd = gcd(b % a, a);
        return gcd;
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
        public String next;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
