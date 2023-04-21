import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GeeksMain {
    public static void main(String[] args) {
        /*String[] s1 = {"jrjiml", "tchetn", "ucrhye", "ynayhy", "cuhffd", "cvgpoiu", "znyadv"};
        String[] s2 = {"jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc", "geheqe", "uglxagyl", "uyxdroj"};
        System.out.println(prefixSuffixString(s1, s2));

        int[] numbers = {6,1,2,8,3,4,7,10,5};
        System.out.println(missingNumber(numbers, numbers.length));


        int[] items = {0, 2, 1, 2, 0};
        sort012(items, items.length);
        System.out.println(Arrays.toString(items));
         */

        int[] numbers = {1,2,3,4,0};
        System.out.println(leaders(numbers, numbers.length));
    }

    public static int prefixSuffixString(String s1[],String s2[]) {

        int count = 0;
        for (String str2 : s2) {
            for (String str1 : s1) {
                if (str1.startsWith(str2) || str1.endsWith(str2)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    //Function to find a continuous sub-array which adds up to a given number.
    public static ArrayList<Integer> findSubarray(int[] A, int S) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        int sum = 0;
        boolean found = false;

        while (right < A.length) {
            sum += A[right];
            while (sum > S) {
                sum -= A[left];
                left++;
            }
            if (sum == S) {
                result.add(left + 1);
                result.add(right + 1);
                found = true;
                break;
            }
            right++;
        }

        if (!found) {
            result.add(-1);
        }

        return result;
    }

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // {1,2,3,7,5} N = 5, S = 12
        int start = 0, end = 0, curr = 0;

        ArrayList<Integer> ans = new ArrayList<>(2);
        if (s == 0) {
            ans.add(-1);
            return ans;
        }
        for (end = 0; end < n; end++) {
            curr += arr[end];
            while (curr > s) {
                curr -= arr[start];
                start++;
            }
            if (s == curr) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    static int missingNumber(int array[], int n) {
        //{1,2,3,5}
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int item : array) {
            numbers.add(item);
        }
        int missing = 0;

        for (int i = 1; i <= n; i++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }

        return missing;
    }

    public static int findMissing(int[] arr) {
        //{1,2,3,5}
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        return expectedSum - actualSum;
    }

    public static void sort012(int a[], int n) {
        int zeros = 0, ones = 0, twos = 0;
        for (int i = 0; i < n; i++) {
            switch (a[i]) {
                case 0:
                    zeros++;
                case 1:
                    ones++;
                case 2:
                    twos++;
            }
        }
        Arrays.fill(a, 0, zeros, 0);
        Arrays.fill(a, zeros, ones, 1);
        Arrays.fill(a, ones, twos, 2);
    }

    public static void sort012DutchNationalFlagAlgorithm(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp2;
                    high--;
                    break;
            }
        }
    }

    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < arr.length; j++) {
                isLeader = arr[i] >= arr[j];
                if (!isLeader) {
                    break;
                }
            }
            if (isLeader) {
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<Integer>();
        int maxSoFar = arr[arr.length - 1];
        leaders.add(maxSoFar);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxSoFar) {
                maxSoFar = arr[i];
                leaders.add(maxSoFar);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
