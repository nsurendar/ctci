import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Surendar on 10/14/2015.
 */
public class ArrayGG {


    // Q4 print a matrix in spiral order.
    static void spiralPrint() {
        int[][] a = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        spiralPrint(a.length, a[0].length, a);
    }

    static void spiralPrint(int m, int n, int[][] a) {
        int i, k = 0, l = 0;

    /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
    */

        while (k < m && l < n) {
        /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

        /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

        /* Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

        /* Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    //Q3 Given a matrix of 1’s and 0’s, where 1 represents an island and 0 water, find the number of islands formed.


    // A function to check if a given cell (row, col) can be included in DFS
    static int isSafe(int[][] M, int row, int col, boolean[][] visited) {
        if ((row >= 0) && (row < M.length) &&     // row number is in range
                (col >= 0) && (col < M[0].length) &&     // column number is in range
                (M[row][col] == 1 && !visited[row][col]))
            return 1;
        else
            return 0;// value is 1 and not yet visited
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers
// the 8 neighbors as adjacent vertices
    static void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column numbers of 8 neighbors
        // of a given cell
        int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) == 1)
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }


    // The main function that returns count of islands in a given boolean
// 2D matrix
    static int countIslands(int[][] M) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        int row = 5;
        int col = 5;
        boolean[][] visited = new boolean[row][col];


        // Initialize count as 0 and travese through the all cells of
        // given matrix
        int count = 0;
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with value 1 is not
                {                              // visited yet, then new island found
                    DFS(M, i, j, visited);     // Visit all cells in this island.
                    ++count;                   // and increment island count
                }

        return count;
    }


    static void countIsland() {
        int[][] M = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println("Number of islands is: " + countIslands(M));
    }


    //Q5 Write a program to find the element which is common in all the rows in a two-dimensional array.

    static int matCommon(int[][] arr, Map<Integer, Integer> mp, Set<Integer> st) {
        int ans=-1;

        for (int i = 0; i < arr.length; i++) {
            // clear set for new row
            st.clear();
            for (int j = 0; j < arr[0].length; j++) {
                //If it is already counted in row ignore
                if (st.contains(arr[i][j]))
                    continue;
                else {
                    st.add(arr[i][j]);
                    int value =0;
                    if(mp.containsKey(arr[i][j]))
                        value = mp.get(arr[i][j]);
                    mp.put(arr[i][j], value+1);
                    if (mp.get(arr[i][j]) == arr.length)
                        ans = arr[i][j];
                }


            }
        }
return ans;

    }


    static void matCommon()
    {
        int[][] arr = {{2,3,0},{3,4,5},{4,5,6}};
        System.out.println(matCommon(arr, new LinkedHashMap<Integer, Integer>(),new LinkedHashSet<Integer>()));

    }


    //Q 6 Given an array, you can only ROTATE the array as many times you want. Return the maximum of summation of (i*A[i]).
    static int maxSum(int arr[])
    {
        // Find array sum and i*arr[i] with no rotation
        int arrSum = 0;  // Stores sum of arr[i]
        int currVal = 0;  // Stores sum of i*arr[i]
        int n = arr.length;
        for (int i=0; i<n; i++)
        {
            arrSum = arrSum + arr[i];
            currVal = currVal+(i*arr[i]);
        }

        // Initialize result as 0 rotation sum
        int maxVal = currVal;

        // Try all rotations one by one and find
        // the maximum rotation sum.
        for (int j=1; j<n; j++)
        {
            currVal = currVal + arrSum-(n*arr[n-j]);
            if (currVal > maxVal)
                maxVal = currVal;
        }

        // Return result
        return maxVal;
    }

    static void maxSum()
    {
        int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(maxSum(arr));
    }


    //Q7 Given an array, divide it into two subsets such that the difference between the sum of subsets is minimized. Also, return the subsets
// A utility function that returns true if there is a subset of arr[]
// with sun equal to given sum
    static boolean isSubsetSum (int arr[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n-1] > sum)
            return isSubsetSum (arr, n-1, sum);

   /* else, check if sum can be obtained by any of the following
      (a) including the last element
      (b) excluding the last element
   */
        return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]);
    }

    // Returns true if arr[] can be partitioned in two subsets of
// equal sum, otherwise false
    static boolean findPartiion (int arr[])
    {
        int n = arr.length;
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets with equal sum
        if (sum%2 != 0)
            return false;

        // Find if there is subset with sum equal to half of total sum
        return isSubsetSum (arr, n, sum/2);
    }

    static void findPartiion()
    {
        int arr[] = {1, 2, 3, 4, 11};

        if (findPartiion(arr) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");


    }


    //Q9 go from 0,0 to m,n in a 2d matrix. find the maximum possible sum of your path. you can only move down or right.


    /* Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]*/
    static int minCost(int[][] cost, int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + min( minCost(cost, m-1, n-1),
                    minCost(cost, m-1, n),
                    minCost(cost, m, n-1) );
    }

   static int minCostMem(int[][] cost, int m, int n)
    {
        int i, j;

        // Instead of following line, we can use int tc[m+1][n+1] or
        // dynamically allocate memoery to save space. The following line is
        // used to keep te program simple and make it working on all compilers.
        int[][] tc = new int[cost.length][cost[0].length];

        tc[0][0] = cost[0][0];

     /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

     /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

     /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];

        return tc[m][n];
    }

    /* A utility function that returns minimum of 3 integers */
    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    static void  minCost()
    {
        int[][] cost = { {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3} };
        System.out.println( minCost(cost, 1, 1));
    }


    static int maxCost(int[][] cost, int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + max(maxCost(cost, m - 1, n - 1),
                    maxCost(cost, m - 1, n),
                    maxCost(cost, m, n - 1));
    }

    /* A utility function that returns minimum of 3 integers */
    static int max(int x, int y, int z)
    {
        if (x > y)
            return (x > z)? x : z;
        else
            return (y > z)? y : z;
    }

    static void maxCost()
    {
        int[][] cost = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        System.out.println( maxCost(cost, 2, 1));
    }




        //Q8 Given an array with -ve as well as +ve elements find target continues sum.


    static int  maxContiNeg(int[] arr)
    {
        int prev =0;
        int max =0;
        for(int i=0;i<arr.length;i++)
        {

            if(prev < prev + arr[i])
            {
                prev+=arr[i];
            }
            else
            {
                if(prev > max)
                    max = prev;
                prev=0;
            }
        }

        return Math.max(prev,max);
    }

    // Q9Given an array having positive integers, how do I find a continuous subarray which sums to a given number?
    static void maXContinuesSum(int[] A,int target)
    {


        for(int i = 0, j = 0, sum = 0; i < A.length; i++) {
            for(; j < A.length && sum < target; j++) sum += A[j];
            if(sum > target) {
                target = sum;
                System.out.println(i + " " + j);
            }
            sum -= A[i];
        }
    }

    static void maXContinuesSum()
    {
        int[] a = {1,2,3,2,-4,3,2,1};

        //maXContinuesSum(a,6);

        System.out.print(maxContiNeg(a));

    }

    // Q12 find the maximum element in a sorted rotated array.O(logn)
    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }

    static void findMin()
    {
        int arr1[] =  {5, 6, 1, 2, 3, 4};

        System.out.println("The minimum element is "+ findMin(arr1, 0, arr1.length - 1));

        int arr2[] =  {1, 2, 3, 4};

        System.out.println("The minimum element is "+ findMin(arr2, 0, arr2.length - 1));

        int arr3[] =  {1};

        System.out.println("The minimum element is "+ findMin(arr3, 0, arr3.length - 1));

        int arr4[] =  {1, 2};

        System.out.println("The minimum element is "+ findMin(arr4, 0, arr4.length - 1));

        int arr5[] =  {2, 1};

        System.out.println("The minimum element is "+ findMin(arr5, 0, arr5.length - 1));

        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};

        System.out.println("The minimum element is "+ findMin(arr6, 0, arr6.length - 1));

        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};

        System.out.println("The minimum element is "+ findMin(arr7, 0, arr7.length - 1));

        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};

        System.out.println("The minimum element is "+ findMin(arr8, 0, arr8.length - 1));

        int arr9[] =  {3, 4, 0, 2};

        System.out.println("The minimum element is "+ findMin(arr9, 0, arr9.length - 1));
    }


    //Q13 & Q14
    // The main function that rearranges elements of given array.  It puts
// positive elements at even indexes (0, 2, ..) and negative numbers at
// odd indexes (1, 3, ..).
    static void rearrange(int arr[],  boolean isAler)
    {
        // The following few lines are similar to partition process
        // of QuickSort.  The idea is to consider 0 as pivot and
        // divide the array around it.
        int i = -1;
        for (int j = 0; j < arr.length; j++)
        {
            if (arr[j] < 0)
            {
                i++;
                swap(arr,i,j);
            }
        }

        if(!isAler)
            return ;

        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i+1, neg = 0;

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < arr.length && neg < pos && arr[neg] < 0)
        {
            swap(arr,neg,pos);
            pos++;
            neg += 2;
        }
    }

    static void swap(int [] arr ,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void rearrange()
    {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

        rearrange(arr,true);
        printArray(arr);

    }


    // A utility function to print an array
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+ " ");
        System.out.println("");
    }

}

