import java.util.ArrayList;

public class GeeksMain {
    public static void main(String[] args) {
//        String[] s1 = {"jrjiml", "tchetn", "ucrhye", "ynayhy", "cuhffd", "cvgpoiu", "znyadv"};
//        String[] s2 = {"jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc", "geheqe", "uglxagyl", "uyxdroj"};
//        System.out.println(prefixSuffixString(s1, s2));

        int[] numbers = {6,1,2,8,3,4,7,10,5};
        System.out.println(missingNumber(numbers, numbers.length));
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

}
