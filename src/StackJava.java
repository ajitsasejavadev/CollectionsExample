import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackJava {

    public static void main(String[] args) {

      //  java.util.Stack extends Vector implements List, Collection ,RandomAccess
        //  It is a LIFO list.
        // it is Serializable and Cloneble also

        Stack stack = new Stack<Integer>();

        stack.push(100);
        stack.push(10);
        stack.push(234);
        stack.push(50);
        stack.push(111);

        System.out.println(stack);  // print stack
        System.out.println(stack.pop());  // remove last entered item
        System.out.println(stack);
        System.out.println(stack.peek()); // returns top item on stack
       // System.out.println(stack.isEmpty()); // check empty or not
        System.out.println(stack.size()); // returns size

        System.out.println(stack.contains(10));
        System.out.println(stack.search(234));


        // Arrays to stack
        Integer[] arr = { 1001,1002,1003,1004};
        Stack<Integer> stack1 = new Stack<>();
        for(Integer i : arr){
            stack1.push(i);
        }
        System.out.println("Non-Empty stack : "  + stack1);

        // List to Stack
        List<Integer> l = new ArrayList<>();
        Collections.addAll(l,10,20,3,5);  // adding all elements to list

        Stack<Integer> stack2 = new Stack<>();
        stack2.addAll(l);   // add all list elements to stack
        System.out.println(stack2);

    }

}
