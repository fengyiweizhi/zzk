package com.zzk.demo;

import java.util.Scanner;

/**
 * 人工智障
 * @author 风亦未止
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String q;
        while (true){
            q=scanner.next();
            q=q.replace("吗？","!");
            System.out.println(q);
        }
    }
}
