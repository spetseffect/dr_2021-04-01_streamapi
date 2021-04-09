package com.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static List<Integer> RandList(int count, int max){
        Random rnd=new Random(System.currentTimeMillis());
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(rnd.nextInt(max));
        }
        return list;
    }
    private static List<Integer> RandList(int count){
        Random rnd=new Random(System.currentTimeMillis());
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(rnd.nextInt());
        }
        return list;
    }
    private static boolean Polindrom(Integer value){
        int rev=value%10;
        int tmp=value/10;
        while (tmp!=0){
            rev=rev*10+tmp%10;
            tmp/=10;
        }
        return rev==value;
    }

    public static void main(String[] args) {
        List<Integer> arr=RandList(10);
        var str=arr.stream()
                .map((v)->v.toString())
                .reduce((s1,s2)->s1 + ", " + s2)
                .get();
        System.out.println("arr1: "+str);
        System.out.println("v>0 => "+arr.stream().filter((v)->v>0).count());
        System.out.println("v<0 => "+arr.stream().filter((v)->v<0).count());
        List<Integer> arr2=RandList(10,200);
        str=arr2.stream()
                .map((v)->v.toString())
                .reduce((s1,s2)->s1 + ", " + s2)
                .get();
        System.out.println("arr2: "+str);//только положительные числа
        System.out.println("9<v<100 => "+arr2.stream().filter((v)->v>9 && v<100).count());
        System.out.println("polindrom => "+arr2.stream().filter(Main::Polindrom).count());
    }
}
