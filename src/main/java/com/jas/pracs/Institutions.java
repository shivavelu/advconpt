package com.jas.pracs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Institutions {


    String name;
    List<String> location;

    public Institutions(String name, List<String> location)
    {
        this.name= name;
        this.location=location;
    }

    public String getName()
    {
        return name;
    }
    public List<String> getLocation()
    {
        return location;
    }
}

class Inspros{

  static List<Institutions> instituteList= new ArrayList<>();

    public static void main(String[] args)
    {
        instituteList.add(new Institutions("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institutions("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institutions("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        List<String> insName = instituteList.stream().map(Institutions::getName).collect(Collectors.toList());
        Set<String> insLocation = instituteList.stream().flatMap(i -> i.getLocation().stream()).collect(Collectors.toSet());
        System.out.println(insName);
        System.out.println(insLocation);

        instituteList.stream().map(Institutions::getLocation).forEach(System.out::println);



    }


}