package com.task3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Device> div=new ArrayList<>();
        div.add(new Device("шмурдик",1990, 3.0, Color.BLACK,"дубаратор"));
        div.add(new Device("грымзик",2010, 10.0, Color.BLUE,"мухропендия"));
        div.add(new Device("запырка",1990, 8.0, Color.BLACK,"дубаратор"));
        div.add(new Device("охлотушка",2010, 12.0, Color.GREEN,"мухропендия"));
        div.add(new Device("бздыш болотный",2015, 7.0, Color.YELLOW,"бурдылька"));
        Optional<String> str=div.stream().map(d->d.name).reduce((p,n)->p+", "+n);
        System.out.println("Все устройства: "+str.orElse("отсутствуют"));
        str=div.stream()
                .filter(d->d.color==Color.BLACK)
                .map(d->d.name)
                .reduce((p,n)->p+", "+n);
        System.out.println("Все устройства чёрного цвета: "+str.orElse("отсутствуют"));
        str=div.stream()
                .filter(d->d.year==2010)
                .map(d->d.name)
                .reduce((p,n)->p+", "+n);
        System.out.println("Все устройства 2010 года: "+str.orElse("отсутствуют"));
        str=div.stream()
                .filter(d->d.price>5.0)
                .map(d->d.name)
                .reduce((p,n)->p+", "+n);
        System.out.println("Все устройства дороже 5 у.е.: "+str.orElse("отсутствуют"));
        str=div.stream()
                .filter(d-> d.type.equals("дубаратор"))
                .map(d->d.name)
                .reduce((p,n)->p+", "+n);
        System.out.println("Все устройства типа \"дубараторы\": "+str.orElse("отсутствуют"));
        str=div.stream()
                .filter(d-> d.year>=2000 && d.year<=2020)
                .map(d->d.name)
                .reduce((p,n)->p+", "+n);
        System.out.println("Все устройства 2000-2020гг: "+str.orElse("отсутствуют"));
    }
}
