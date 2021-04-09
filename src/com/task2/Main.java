package com.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String counters(long count){
        if(count%100>11 && count%100<15) return "раз";
        else if(count%10>1 && count%10<5) return "раза";
        else return "раз";
    }
    public static void main(String[] args) {
        List<String> prod=new ArrayList<>();
        prod.add("лук");
        prod.add("малина");
        prod.add("яблоко");
        prod.add("сыр");
        prod.add("лук");
        prod.add("лук");
//        prod.add("лук");
        prod.add("мандарин");
        prod.add("апельсин");
        prod.add("лук");
        System.out.println("Все продукты: "+prod.stream().reduce((p,n)->p+", "+n).get());
        System.out.println("Все продукты с названием короче 5 символов: "+
                prod.stream().filter(p->p.length()<5).distinct().reduce((p,n)->p+", "+n).get());
        System.out.print("Введите название продукта: ");
        Scanner sc=new Scanner(System.in);
        String str= sc.nextLine();
        sc.close();
        var count=prod.stream().filter(p-> p.equals(str)).count();
        System.out.println("Этот продукт в списке встречается "+count+" "+counters(count));
        System.out.println("На букву \"м\" начинаются: "+
                prod.stream().filter(p->p.startsWith("м")).distinct().reduce((p,n)->p+", "+n).get());
    }
}
