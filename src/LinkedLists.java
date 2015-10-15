import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Surendar on 9/19/2015.
 */
public class LinkedLists {


    static LinkedListNode circularDetect(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

// sum of digits
    static void gen()
    {
        for(long i=100;i< Long.MAX_VALUE;i++)
        {
            String s = new Long(i).toString();
            boolean match =true;
            for(int j=0;j<s.length();j++)
            {
                char ch = new Integer(j).toString().charAt(0);
                int curr = Integer.parseInt(""+s.charAt(j));
                if(!(curr == getCount(s,ch)))
                {
                    match=false;
                    break;
                }
            }
            if(match)
                System.out.println(s);

        }
    }

    static int getCount(String s,char ch)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==ch)
                count++;
        }
        return count;
    }

    //end sum of digits


    //question 1


    static LinkedListNode removeDup(LinkedListNode head)
    {
        LinkedListNode prev = null;
        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode n = head;
        while(n!=null)
        {
            if(set.contains(n.data))
            {
                prev.next= n.next;
            }
            else
            {
                set.add(n.data);
                prev = n;
            }
            n=n.next;
        }



        return head;
    }
    //end 1


    //question 2
    static int kthtolast(LinkedListNode head,int k)
    {
        if(head == null) {
            return 0;
        }

        int index = kthtolast(head.next,k)+1;

        if(index == k)
        {
            System.out.print(head.data);
        }

        return index;

    }
    //end 2


    //question 3
    static LinkedListNode deletelMiddle(LinkedListNode head)
    {
        LinkedListNode s = head;
        LinkedListNode f = head;

        while(f==null)
        {
            f=f.next.next;
            s=s.next;
        }

        s = s.next.next;


        return head;
    }
    //end 3


//Q5
    static LinkedListNode sum(LinkedListNode l1, LinkedListNode l2, int value)
    {

        int res=0;
        LinkedListNode result = new LinkedListNode(res);

        if(l1==null&&l2==null&&value==0)
        {
            return null;

        }

        res+=value;

        if(l1!=null)
        res+=l1.data;

        if(l2!=null)
        res+=l2.data;
        result.data=res%10;

        result.next =  sum(l1==null?null:l1.next,l2==null?null:l2.next,(int)(res/10));


        return result;

    }
   // end 5



    //Q6
    static LinkedListNode reverse(LinkedListNode head)
    {
        if(head==null||head.next==null)
            return head;

        LinkedListNode next = head.next;
        head.next = null;

        LinkedListNode res = reverse(next);

        next.next = head;

        return res;
    }

    //end 6

    //
    static void rev() {


        LinkedListNode node1 = new LinkedListNode(1);

        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedListNode print = node1;
        while (print != null) {
            System.out.println(print.data);
            print = print.next;
        }

        LinkedListNode rev = LinkedLists.reverse(node1);
        System.out.println();
        while (rev != null) {
            System.out.println(rev.data);
            rev = rev.next;
        }
    }
    //


    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }



    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    static void permutation(String prefix, String str, Set<String> set) {
        int n = str.length();
        if (n == 0) set.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),set);
        }
    }
}

class LinkedListNode
{
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data)
    {
        this.data = data;
    }
}
