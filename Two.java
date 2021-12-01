/* 

This program will read a .txt file and determine if there are any duplicate integers within the file. 

The file used, "in.txt", must be created with the desired integers list within. 
This program may need to be adjusted based on the location of in.txt within your computer. 
On line 69: FileReader("in.txt"); <---- may need to adjust file path. 
*/


import java.io.FileReader;
import java.util.Scanner;

class Two {
    Node head;

    // Node Object
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method for adding nodes to the Linked List
    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = new Node(data);
            return;
        }

        newNode.next = null;
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    // Recursive Algorithm for finding duplicate integers
    static Boolean check(Node reference, Node rest) {
        // Base Case
        if(rest == null) {
            reference = reference.next; // Move reference one node to the right
            rest = reference.next; // Move rest to the right of the reference node
            if(rest == null) { // Check to see if we are, indeed, at the end
                return false;
            }
        }
        // If we have a match
        if(reference.data == rest.data) {
            return true;
        }  
        // Recursive check
        return check(reference, rest.next);
    }


    public static void main(String[] args) throws Exception {
        // Create new list
        Two newList = new Two();

        // Read File
        FileReader file = new FileReader("in.txt"); 
        Scanner reader = new Scanner(file);
        int number;
        // Input file integers into linked list
        while(reader.hasNextInt()) {
            number = reader.nextInt();
            newList.add(number);
            System.out.print(number + " "); // Debugging
        }
        // Recursive check() call
        if(check(newList.head, newList.head.next)) {
            System.out.println("Yes!");
        } else {
            System.out.println("No.");
        }
    }
}
