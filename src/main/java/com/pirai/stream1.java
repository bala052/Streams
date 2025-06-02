package com.pirai;

import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class stream1
{
    public static void main(String[] args) {
        //1 - find even numbers in given integer list
//        List<Integer> l= Arrays.asList(23,56,89,70,54,78,34,87);
//        l.stream()
//                .filter(n->n%2 == 0)
//                .sorted()
//                .forEach(k-> System.out.println(k));

//        //2 - make all string to uppercase
//        List<String> l1=Arrays.asList("hi","loki","yuta","thorfinn","eren");
//        l1.stream()
//                .map(s->s.toUpperCase())
//                .sorted()
//                .toList()
//                .forEach(k-> System.out.println(k));

        //3 - print only strings that greater than given string length
//        List<String> l2=Arrays.asList("arun","madan","kalia","loki","thorfinn");
//        l2.stream()
//                .filter(len->len.length()>=5)
//                .toList()
//                .forEach(k-> System.out.println(k));

//        //4 - square of each number
//        List<Integer> l3=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//      List<Integer> l4 = l3.stream()
//                .map(m->m*m)
//                .toList();
//        System.out.println(l4);

        //5 - only print first letter as capital
//        List<String> l5=Arrays.asList("eren","agutami","jinwoo","luffy","naruto","akira");
//        l5.stream()
//                .sorted()
//                .map(n->n.substring(0,1).toUpperCase() + n.substring(1).toLowerCase())
//                .forEach(k-> System.out.println(k));

        //6 - find large number in given array
//        List<Integer> l6 = Arrays.asList(25, 89, 789, 54, 890, 1001, 25000);
//        Optional<Integer> h = l6.stream()
//                .max(Comparator.naturalOrder());
//        h.ifPresent(k -> System.out.println(k));

        //7 - remove duplicate values
//        List<Integer> l7 = Arrays.asList(5, 78, 5, 98, 89, 6, 5, 7, 99, 99, 98);
//        l7.stream()
//                .distinct()
//                .sorted()
//                .forEach(k-> System.out.println(k));

        //8 find sum of all odd numbers
//        List<Integer> l8=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
//        int k=l8.stream()
//                .filter(s->s%2 != 0)
//                .reduce(0,(a,b)->a+b);
//        System.out.println(k);

        //9 - get employee name based on thier salary
//        List<Employee> emp=new ArrayList<>();
//        emp.add(new Employee(1,"arun",50000));
//        emp.add(new Employee(2,"aravind",56000));
//        emp.add(new Employee(3,"rohan",75000));
//        emp.add(new Employee(4,"jihan",25000));
//        emp.stream()
//                .filter(s->s.getSalary()>50000)
//                .forEach(k-> System.out.println(k.getName()));

        //10 - group strings by thier first letter
//        List<String> l10=Arrays.asList("arun","aravind","balaji","bharat","chris","dolphin");
//        Map<Character,List<String>> lk=l10.stream()
//                .collect(Collectors.groupingBy(s->s.charAt(0)));
//        lk.forEach((key,value)-> System.out.println(key + ":" + value));

        //11 - split it into words and count the frequency of each word using Stream
//        String sentence="hi hello hi hello program java";
//        Map<String,Long> map= Arrays.stream(sentence.split("\\s+"))
//                .collect(Collectors.groupingBy(n->n,Collectors.counting()));
//        map.forEach((key,value)-> System.out.println(key +":" + value));

        //12 -  Flatten a list of lists into a single list using flatMap().(e.g., List<List<Integer>> → List<Integer>)
//        List<List<Integer>> listList=Arrays.asList(
//                Arrays.asList(1,2,3,4,5,6),
//                Arrays.asList(7,8,9,10,11,12),
//                Arrays.asList(13,14,15,16,17,18)
//        );//or we can use List.of().we can use new Arraylist<>()
//       List<Integer> k= listList.stream()
//                .flatMap(s-> s.stream())
//               .toList();
//        System.out.println(k);
//
//        //13 -  Partition a list of integers into two groups: even and odd. (Hint: use Collectors.partitioningBy) // partitionby means split stream into 2 groups like odd or even
//        List<Integer> oddeven=Arrays.asList(1,45,67,89,80,42,66,22,98,100);
//        Map<Boolean,List<Integer>> mbl=oddeven.stream() //Collectors.partitioningBy works with Map<Boolean,List<Integer>> because key value must be Boolean
//                .collect(Collectors.partitioningBy(n->n%2==0));
//        System.out.println("Even : "+mbl.get(true));
//        System.out.println("odd : "+mbl.get(false));
//
//        //14 - Find the second highest number in a list using Stream
//        List<Integer> sh=Arrays.asList(1,2,3,4,5,6,7,99,1001,180);
//       Optional<Integer> o= sh.stream()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst();
//        o.ifPresent(l-> System.out.println(l));

        //15 - Group a list of strings by their length and sort the map by length ascending
        List<String> str=Arrays.asList("hello","hi,","arul","arun","balaji");
         Map<Integer,List<String>> p=str.stream()
                .collect(Collectors.groupingBy(n->n.length(),
                        () -> new TreeMap<>(), // takes no input and returns a new TreeMap & Stores key-value pairs.Keeps keys sorted in natural order (or using a custom comparator)
                        Collectors.toList()));
       p.forEach((key,value)-> System.out.println(key +":"+value));
    }
}
