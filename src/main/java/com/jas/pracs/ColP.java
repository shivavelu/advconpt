package com.jas.pracs;

import java.util.*;
import java.util.stream.Collectors;

public class ColP {

     static List<Student> studentList;


    public ColP()
    {
        studentList=new ArrayList<Student>();
        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));
    }




    public static void main(String[] args) {
        ColP obj1= new ColP();
        //Collectors.toList()
        List<Student> top3Performer = studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
        //Collector.toSet()
        Set<String> sub = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
        System.out.println(sub);
        //Colector.toMap()
        Map<String, Double> namePer = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println(namePer);
        namePer.entrySet().stream().filter(e -> e.getValue() >=80).forEach(System.out::println);
        //Collector.joining()
        String joinName = studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(joinName);
        studentList.stream().forEach(student -> {System.out.print(student.getName()+ ", ");});
        //Collector.counting()
        System.out.println();
        Long size = studentList.stream().collect(Collectors.counting());
        System.out.println(size);

        // Collectors.maxBy()
        Optional<Double> maxPer = studentList.stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(maxPer);

        //Collectors.minBy()
        Optional<Double> minPer = studentList.stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minPer);

        //summingInt(), summingLong(), summingDouble()
        Double sumofAll = studentList.stream().collect(Collectors.summingDouble(student -> student.getPercentage()));
        System.out.println(sumofAll);

        //averagingInt(), averagingLong(), averagingDouble()
        Double avgofPer = studentList.stream().collect(Collectors.averagingDouble(s -> s.getPercentage()));
        System.out.println(avgofPer);

        //summingInt(), summingLong(), summingDouble()
        DoubleSummaryStatistics summary = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
        System.out.println(summary.getMax());
        System.out.println(summary.getMin());
        System.out.println(summary.getAverage());
        System.out.println(summary.getSum());

        //groupby
        Map<String, List<Student>> groups = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(groups);

        // Collectors.partitioningBy()
        Map<Boolean, List<Student>> partiona = studentList.stream().collect(Collectors.partitioningBy(Student -> Student.getPercentage() > 80));
        System.out.println(partiona);
        System.out.println(partiona.get(true));



    }
}
