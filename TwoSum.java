import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSumValues(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int complement = target - num;
            
            if (map.containsKey(complement)) {
                return new int[] { complement, num };
            }
            
            map.put(num, 1);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = twoSumValues(nums, target);
        System.out.println("Values: " + result[0] + ", " + result[1]);
    }
}

//Time Complexity: O(n) – single pass through the array
//Space Complexity: O(n) – storing seen numbers in the map
//Avoids nested loops (which would make it O(n²))
