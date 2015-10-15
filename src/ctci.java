import java.util.*;

/**
 * Created by Surendar on 9/18/2015.
 */
public class ctci {
    static Scanner in;
    //class for main function

    static void chap1() {

        //question 1.1
        //ArrayAndString.isUnique();

        //question 1.2
        //ArrayAndString.isPermutation();

        //question 1.3
        //ArrayAndString.changeString();

        //question 1.4
        //ArrayAndString.palindromePermutation();

        //question 1.5
        //ArrayAndString.oneWay();

        //question 1.6
        //ArrayAndString.stringCompression();

        //question 1.8
        // ArrayAndString.zeroMatrix();

        //question 1.9
        // ArrayAndString.isSubString();


        // LinkedLists.gen();

    }

    static void chap2() {
//        Set<Integer> mySet = new HashSet<Integer>();
//        mySet.add(1);
//        mySet.add(2);
//        mySet.add(3);
//        for (Set<Integer> s : LinkedLists.powerSet(mySet)) {
//            System.out.println(s);
//        }

        ArrayList<String> list = LinkedLists.getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("");
        Set<String> set = new TreeSet<String>();
        LinkedLists.permutation("", "abc", set);
        for (String s : set) {
            System.out.println(s);
        }
    }

    static void printit() {
        String str = "chillout";

        int len = str.length();
        double sqrt = ((Math.sqrt(len)));

        int row = sqrt - (double) (int) sqrt > 0.5 ? ((int) sqrt) + 1 : (int) sqrt;
        //int column = (int) Mathceil((double) len / sqrt);

        int column=0;
        char[][] map = new char[row][column];

        int i, j;

        int n = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {

                if (n < len)
                    map[i][j] = str.charAt(n++);

            }
        }

        for (i = 0; i < column; i++) {
            for (j = 0; j < row; j++) {

                System.out.print(map[j][i]);
            }
            System.out.print(" ");
        }

    }


    static void xorCompare() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 99;
        }

        arr[7] = 14;

        System.out.println(xorCompare(arr));
    }

    static int xorCompare(int arr[]) {
        int match = 0;
        int offset = 1;
        int ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }


        return ones;
    }



    public static void arrayGG()
    {
        //printit();
       // ArrayGG.spiralPrint();
       // ArrayGG.countIsland();
        //ArrayGG.matCommon();
       // ArrayGG. maxSum();
        //ArrayGG.findPartiion();
        //ArrayGG.minCost();
       // ArrayGG.maxCost();
       // ArrayGG.maXContinuesSum();
       // ArrayGG.maXContinuesSum();
       // ArrayGG.findMin();
        ArrayGG.rearrange();
    }

    public static void main(String[] args) {
        arrayGG();
    }

}
