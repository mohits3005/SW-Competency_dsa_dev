package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node
{
    int data;
    char c;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class Flatten {

    // Function to flatten the linked list
    static Node flatten(Node root) {

        Stack<Node> st = new Stack();
        Node cur = root;

        while (cur != null && cur.next != null) {
            st.push(cur);
            cur = cur.next;
        }

        while (st.isEmpty() == false) {
            Node prev = st.pop();

            cur = merge(cur, prev);
        }

        return cur;
    }

    public static Node merge(Node head1, Node head2) {

        // A dummy first node to store the result list
        Node dummy = new Node(-1);

        // Tail points to the last result node to add new
        // nodes to the result
        Node tail = dummy;

        // Iterate till either head1 or head2 does not reach
        // null
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {

                // Append head1 to the result
                tail.bottom = head1;
                head1 = head1.bottom;
            }
            else {

                // Append head2 to the result
                tail.bottom = head2;
                head2 = head2.bottom;
            }

            // Move tail pointer to the next node
            tail = tail.bottom;
        }

        // Append the remaining nodes of the non-null list
        if (head1 != null)
            tail.bottom = head1;
        else
            tail.bottom = head2;

        return dummy.bottom;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 5 -> 10 -> 19 -> 28
        // |    |     |
        // V    V     V
        // 7    20    22
        // |          |
        // V          V
        // 8          50
        // |
        // V
        // 30

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        // Function call
        head = flatten(head);

        printList(head);
    }
}
