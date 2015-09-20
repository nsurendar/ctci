/**
 * Created by Surendar on 9/19/2015.
 */
public class LinkedLists {
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

    
    //end 1

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
