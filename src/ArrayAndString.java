import java.util.Arrays;

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
    //check permutation
    static void isPermutation()
    {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    static boolean isPermutation(String str1,String str2)
    {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(new String(arr1).equals(new String(arr2)))
            return true;
        else
            return false;

    }



    //end 1.2


    //question 1.3
    public static void changeString() {
        
    }
    //end 1.3
}
