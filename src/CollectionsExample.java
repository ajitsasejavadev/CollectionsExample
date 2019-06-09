// example for java8 Collections class

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {

        // Collections have three fields -  EMPTY_LIST, EMPTY_SET, EMPTY_MAP

        // 1. add all
        List list = new ArrayList();
        Collections.addAll(list,"abc","sdf","fds","abc","x","jkl");  // add all data once in collection
      //  list.forEach(System.out::println);


        //2 . sort
        Collections.sort(list);  // sort in assending order
        //list.forEach(System.out::println);

        // 3. sort in reverse order
        Collections.sort(list, Comparator.reverseOrder());
        //list.forEach(System.out::println);

        //4 binary search  for this the list must be sorted as assending order
      //  System.out.println(Collections.binarySearch(list,"x"));

        // 5. copy Collection
        List fruit = new ArrayList();
        Collections.addAll(fruit, "Apples", "Oranges", "Banana","q","e","q");  // for copy des size should not be less than src
        Collections.copy(list,fruit);  //(des,src) copy fruit to list . all the data will be overlaped according to indexes
        //fruit.forEach(System.out::println);

        // 6 . check if two list are same or not if same false and return true if no element are common
      //  System.out.println(Collections.disjoint(list,fruit)); // false as both are same

        List vegetables = new ArrayList();
        Collections.addAll(vegetables, "Potato", "Cabbage");
      //  System.out.println(Collections.disjoint(vegetables, fruit)); // true as no element is common

        //7 . count frequency of an element
       // System.out.println(Collections.frequency(list,"q")); //2

        // 8 find max
        System.out.println(Collections.max(list));

        // 8 find min
        System.out.println(Collections.min(list));

    }

}
