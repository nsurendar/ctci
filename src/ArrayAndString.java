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
        String str = "abc d e f";
        int spaces = 3;
        int excess = 7;
        char[] arr = new char[str.length() + spaces * 2 + 1 + excess];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        for (int i = str.length(); i < arr.length; i++) {
            arr[i] = ' ';
        }
        changeString(arr, str.length());
        System.out.println("\"" + new String(arr) + "\"");
    }

    public static void changeString(char[] arr,int len)
    {

        int j=0;
        int space =0;
        for(int i=0;i<len;i++) {
            if(arr[i]==' ')
                space++;
        }
        int z = len + space * 2;

        for(int i=len -1;i>=0;i--) {

            if(arr[i] >= 'a' && arr[i] <= 'z' || arr[i] >= 'A' && arr[i] <= 'Z' )
            {
                arr[z--] = arr[i];
            }
            else
            {
                arr[z--] = '0';
                arr[z--] = '2';
                arr[z--] = '%';
            }
        }


    }


    //end 1.3

    //Q 1.4
    public static void palindromePermutation() {
        String pali = "Rats live on no evil star";
        System.out.println(palindromePermutation(pali));
    }

    public static boolean palindromePermutation(String str) {

        // ascii value of space is 32 -> z 's 122 - 32= 90
        int[] arr = new int[90];
        str = str.toLowerCase();

        for(int i=0;i<str.length();i++)
        {
           // if(str.charAt(i)!=' ') since we subtract with ' '
            arr[((int)str.charAt(i)-(int)' ')]++;
        }
        boolean isEven = (str.length()%2)==0;
        int count=0;
        boolean oneOdd=false;
        for(int i=0;i<90;i++)
        {
            if(isEven)
            {
                if(arr[i]%2!=0)
                    return false;
            }
            else
            {
                if(arr[i]%2==1 && !oneOdd)
                {
                    oneOdd = true;
                }
                else if (arr[i]%2==0)
                {

                }
                else
                {
                    return false;
                }
            }
        }

        return true;

    }
    //end 1.4

    //Q 1.5
    enum changeType{Insert,Remove,Replace}

    public static void oneWay() {
        String a = "pale";
        String b = "bake";
        boolean isOneEdit = oneWay(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }

     static boolean oneWay(String str1,String str2) {

        int i=0;
        int j=0;
        int count=0;
        if(Math.abs(str1.length()-str2.length())>1)
            return false;

        while(i<str1.length() && j<str2.length())
        {
            if(str1.charAt(i)==str2.charAt(j))
            {
                i++;
                j++;

            }
            else if(count <1)
            {
                count++;

                if(i+1 < str1.length() && str1.charAt(i+1)==str2.charAt(j)) i++;
                else if(j+1 < str2.length() && str1.charAt(i)==str2.charAt(j+1)) j++;
                else
                {
                    i++;
                    j++;
                }
            }
            else
            {
                return false;
            }

        }
        return true;

    }
    //end 1.5

// Q 1.6
    public static void stringCompression() {
    }

    //end 1.6
}
