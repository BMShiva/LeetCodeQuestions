import java.util.*;

public class LongestConsecutiveSequence {
    public static List<Integer> longestConsecutiveSubarray(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        List<Integer> longestSeq = new ArrayList<>();

        for (int num : set) {
            if (!set.contains(num - 1)) { // start of a sequence
                List<Integer> currentSeq = new ArrayList<>();
                int currentNum = num;
                while (set.contains(currentNum)) {
                    currentSeq.add(currentNum);
                    currentNum++;
                }
                if (currentSeq.size() > longestSeq.size()) {
                    longestSeq = currentSeq;
                }
            }
        }

        Collections.sort(longestSeq); // to keep sequence ordered
        return longestSeq;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        List<Integer> result = longestConsecutiveSubarray(nums);
        System.out.println("Longest consecutive subarray: " + result);
    }
}


//Time: Every number is visited at most twice (once in the for-loop, once in the while-loop).
//Space: Uses a HashSet to store unique elements (O(n) extra space).