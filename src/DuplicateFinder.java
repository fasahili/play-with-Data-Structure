import java.util.HashMap;
import java.util.Map;

class DuplicateFinder {
    static HashMap<Integer, Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> duplicates = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5, 3, 4, 5, 4};
        HashMap<Integer, Integer> duplicates = findDuplicates(nums);

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate numbers found.");
        } else {
            System.out.println("Duplicate numbers and their counts:");
            for (Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
                System.out.println("Number " + entry.getKey() + " appears " + entry.getValue() + " times.");
            }
        }
    }
}