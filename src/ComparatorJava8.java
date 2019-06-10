
// prior to java 8 Comparator has only two methods compare() & equals() .
// But in java 8 it is changed to Functional Iterface ,compare as abstract() (that we can use Lambda) and other 18 methods also
// In java8 Comparator provides multiple methods for sorting , that we can do multiple sorting also

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    private String empName;
    private Integer empAge;

    public Employee(String empName, Integer empAge) {
        this.empName = empName;
        this.empAge = empAge;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public Integer getEmpAge() {
        return empAge;
    }
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee{" + "empName='" + empName  + ", empAge=" + empAge + '}';
    }
}

public class ComparatorJava8 {
    public static void main(String[] args) {
        // creating a list of Employee Objects
        List<Employee> employeeList = Arrays.asList(
                new Employee("Tom Jones", 45),
                new Employee("Harry Major", 35),
                new Employee("Ethan Hardy", 65),
                new Employee("Harry Major", 25),
                new Employee("Nancy Smith", 15),
                new Employee("deborah Sprightly", 29),
                new Employee("Deborah Sprightly", 29)
        );

        // in java8 compartor class have several methods .
        // 1. compare(T ob1,T ob2) : compares two objects and returns int (-1,0,1) ;
        // it is also functional interface so we can use lambda expression
        Comparator<Employee> employeeComparator= (Employee e1,Employee e2)->{
            return e1.getEmpName().compareTo(e2.getEmpName());  // comapring on basis of empNames
        };   // since lambda so returning Functional Interface
        Collections.sort(employeeList,employeeComparator);   // sorting based on our comparator ,as it can't sort Employee objects
        employeeList.forEach(System.out::println);
        System.out.println("------------------------");

        // now these all are static methods
        // 2. comparing(key as Functional Interface instance) : compares the objects based on sort key
        Comparator<Employee> employeeComparator1 = Comparator.comparing((Employee e)->e.getEmpName()); // getting key using lambda
       //or Comparator<Employee> employeeComparator2 = Comparator.comparing(Employee::getEmpName); // getting key using method refrence
        Collections.sort(employeeList,employeeComparator1);
        employeeList.forEach(System.out::println);
        System.out.println("------------------------");

        // 3. comparing(key as Functional Interface instance,key Comparator) : compares the objects based on sort key and a comparator for key
        Comparator<Employee> employeeComparator2 = Comparator.comparing(Employee::getEmpName,String.CASE_INSENSITIVE_ORDER); // getting key using method refrence
        Collections.sort(employeeList,employeeComparator2);
        employeeList.forEach(System.out::println);  // not depends on case
        System.out.println("------------------------");

        // 4. comparingInt(Integer key as FI): sort on the basis of integer values
        // like this other methods are comparingLong() , comparingDouble()
        Comparator<Employee> employeeComparator3 = Comparator.comparingInt(Employee::getEmpAge);
        Collections.sort(employeeList,employeeComparator3);
        employeeList.forEach(System.out::println);
        System.out.println("------------------------");

        //5. thenComparing(other Comparator): this  method then does the second level sort, if the first level sort is indecisive
        // it is useful when we have to do multiple sortings at once like first sort name basis if same then on babis of age
        Comparator<Employee> employeeComparator4 = Comparator.comparing(Employee::getEmpName,String.CASE_INSENSITIVE_ORDER).thenComparing(Employee::getEmpAge);
        Collections.sort(employeeList,employeeComparator4);
        employeeList.forEach(System.out::println);
        System.out.println("------------------------");
        // like this some other methods thenComparing(other Comparator,key comparator) , thenComparingInt(other Comparator) etc

        //6. naturalOrder(): sort keys in natural order , no need to write own logic
        //   reverseOrder() : sort in reverse of natural order
        // since these methods will ot work directly on Employee obj so extracting names using stream into list<String>
        // extracting keys as map then collect them as list
        List<String> empList = employeeList.stream().map(Employee::getEmpName).collect(Collectors.toList());
        empList.sort(Comparator.naturalOrder()); // or
        //empList.sort(Comparator.reverseOrder());  // sorting in reverse order
        empList.forEach(System.out::println);
        System.out.println("------------------------");

        // 7. reversed() : want to sort reverse of sorting order
        Comparator<Employee> employeeComparator6 = Comparator.comparing(Employee::getEmpName,String.CASE_INSENSITIVE_ORDER).reversed();
        Collections.sort(employeeList,employeeComparator6);
        employeeList.forEach(System.out::println);
         System.out.println("------------------------");

        // 8. nullFirst() & nullLast() : useful when we have null vaules
        // Comparator<Employee> empNameComparator7 = Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo));

    }
}
