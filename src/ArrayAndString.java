/**
 * Created by Surendar on 9/18/2015.
 */
public class ArrayAndString {

//question 1.1
    //is given string is unique;


    static void isUnique()
    {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
    static boolean isUnique(String str)
    {
        int[] arr = new int[26];

        str = str.toLowerCase();

        for(int i=0;i<str.length();i++)
        {
            int a =  str.charAt(i) - 'a';
            if(arr[a]!= 1)
            {
                arr[a]=1;
            }
            else
            {

                return false;
            }
        }
        return true;
    }

    //end 1.1


    //Q 1.2
    

    //end 1.2
}
