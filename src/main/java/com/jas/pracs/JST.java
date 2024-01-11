package com.jas.pracs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JST {


    public void ResColType()
    {

        List ss= new ArrayList(0);

        ss.add("siva");
        ss.add(10);
        ss.add(20);
        ss.add(false);
        ss.add('y');
        ss.add(100);

        //ss.stream().forEach(System.out::println);

        ss.stream().filter(
               new Predicate(){

                    public boolean test(Object k)
                    {
                        if(k instanceof String)
                        {
                           return true;
                        }
                        return false;
                    }
                }
        ).forEach(System.out::println);


        //ss.stream().filter(input -> input instanceof Integer).forEach(System.out::println);

        ss.stream().distinct().forEach(System.out::println);
    }

    private void pracs1()
    {
        String[] strs= {"adidas","puma","woodlands","leecopper","liveis","nike"};

        List<String> ls= new ArrayList<>(Arrays.asList(strs));

        Stream ss= ls.stream();
        ss.forEach(System.out::println);
        //ss.forEach(System.out::println);

        System.out.println("*****************************");
        ls.parallelStream().forEach(System.out::println);

        List lss=Stream.of(strs).filter(input -> input.equalsIgnoreCase("puma")).collect(Collectors.toList());
        System.out.println(lss);
        Stream.of(strs).filter(input -> input.equalsIgnoreCase("puma")).forEach(System.out::println);

        ls.stream().sorted((String s1, String s2)-> -s1.compareTo(s2)).forEach(System.out::println);




    }

    public static void main(String[] args) {


        JST obj1= new JST();
        //obj1.ResColType();

        obj1.pracs1();

    }
}
