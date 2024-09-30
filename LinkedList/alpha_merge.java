package LinkedList;

public class alpha_merge {

    class Node
    {
        char data;
        Node next;
        Node bottom;

        Node(char d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    class Solution {

        public Node arrangeCV(Node head) {
            // write code here and return the head of changed linked list

            if (head == null)
                return head;

            Node nhead = new Node(' ');
            Node ntail = nhead;
            Node cur = new Node(' ');

            cur.next = head;
            Node next = null;
            char ch = ' ';

            while (cur.next != null) {

                next = cur.next;
                ch = Character.toLowerCase(next.data);

               if ( (ch == 'a') || (ch == 'e') ||(ch == 'i') ||(ch == 'o') ||(ch == 'u') ) {

                   ntail.next = next;
                   ntail = ntail.next;
                   cur.next = next.next;
                   ntail.next = null;

               } else {

                   cur = cur.next;
               }
            }

            if (ntail != nhead) {
                ntail.next = head;
                head = nhead.next;
            }


            return head;
        }
    }

    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code

        int hs[] = new int[100000];

        for (int i = 0; i < k; i++) {
            if (hs[arr[i]] == 1) {
                hs[arr[i]]++;
            } else {
                hs[arr[i]] = 1;

            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (hs[arr[i]] > 1) {
                return true;
            }

            hs[arr[i]]--;

            if (i + k < arr.length) {
                hs[arr[i + k]]++;
            }
        }

        return false;
    }


    public int minEnergy(int a[]) {

        int minEnergy = 0;
        int currentEnergy = 0;

        // Traverse through each checkpoint
        for (int energy : a) {
            currentEnergy += energy;

            // If current energy goes below 1, calculate the required extra energy
            if (currentEnergy < 1) {
                // Calculate how much more energy is required to keep energy >= 1
                minEnergy += 1 - currentEnergy;
                currentEnergy = 1; // Reset the current energy to 1 after adding the extra
            }
        }

        return minEnergy > 0 ? minEnergy : 1;
    }






















}
