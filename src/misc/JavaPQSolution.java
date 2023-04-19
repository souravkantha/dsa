package misc;

// Problem - https://www.hackerrank.com/challenges/java-priority-queue/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */

class Priorities {
    
    private PriorityQueue<Student> queue = new PriorityQueue<>();
    
    public  List<Student> getStudents(List<String> events) {
        
        final List<Student> result = new ArrayList<>();
        
        for (String event : events) {
            if (event.startsWith("ENTER")) {
                final String [] tmp = event.split(" ");
                final Student s = new Student(Integer.parseInt(tmp[3]),
                 tmp[1], Double.parseDouble(tmp[2]));
                queue.add(s);
                
            } else if (event.startsWith("SERVED")) {
                //  System.out.println(queue);
                queue.poll();
               // System.out.println("Served::" + servedStudent);
                
            }
          //  System.out.println(queue);
            
        }
        
       
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        return result;
        
    }
    
}


class Student implements Comparable<Student> {
    
    int id;
    String name;
    double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getID() {
        return this.id;
    }
    
    public double getCGPA() {
        return this.cgpa;
    }
    
    @Override
    public int compareTo(Student other) {
     //  System.out.println(this.name);
     //  System.out.println(other.name);
       
        if(this.cgpa > other.cgpa) {
           // System.out.println("-1");
            return -1;
        } else if (this.cgpa < other.cgpa) {
           // System.out.println("1");
            return 1;
        } else if(this.cgpa == other.cgpa) {
            if(!this.name.equals(other.name)) {
                return this.name.compareTo(other.name);
            } else {
                if (this.id < other.id) {
                    return -1;
                } else if (this.id > other.id) {
                    return 1;
                } else {
                    return 0;
                }
            }
            
        }
        return 0;
        
        
    }
}


public class JavaPQSolution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}