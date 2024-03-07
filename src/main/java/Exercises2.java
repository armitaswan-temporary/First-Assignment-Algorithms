import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int[] answer = new int[2];
        boolean con = true;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    con = false;
                    break;
                }
            }
            if (!con)
                break;
        }
        return answer;
    }

    public int romanToInt(String s) {
        int answer = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'I') {
                if (i < size - 1) {
                    if (s.charAt(i + 1) == 'V') {
                        answer += 4;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'X') {
                        answer += 9;
                        i++;
                    }
                    else
                        answer++;
                }
                else
                    answer++;
            }
            else if (s.charAt(i) == 'V') {
                answer += 5;
            }
            else if (s.charAt(i) == 'X') {
                if (i < size - 1) {
                    if (s.charAt(i + 1) == 'L') {
                        answer += 40;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'C') {
                        answer += 90;
                        i++;
                    }
                    else
                        answer += 10;
                }
                else
                    answer += 10;
            }
            else if (s.charAt(i) == 'L') {
                answer += 50;
            }
            else if (s.charAt(i) == 'C') {
                if (i < size - 1) {
                    if (s.charAt(i + 1) == 'D') {
                        answer += 400;
                        i++;
                    }
                    else if (s.charAt(i + 1) == 'M') {
                        answer += 900;
                        i++;
                    }
                    else
                        answer += 100;
                }
                else
                    answer += 100;
            }
            else if (s.charAt(i) == 'D') {
                answer += 500;
            }
            else if (s.charAt(i) == 'M') {
                answer += 1000;
            }
        }
        return answer;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int size = nums.length;
        if (size == 1) {
            List<Integer> thePermutations = new ArrayList<>();
            thePermutations.add(nums[0]);
            answer.add(thePermutations);
            return answer;
        }
        int[] newNums = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            newNums[i] = nums[i];
        }
        List<List<Integer>> alterAnswer = permute(newNums);
        for (List<Integer> list : alterAnswer) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> ans = new ArrayList<>(list);
                ans.add(i, nums[nums.length - 1]);
                answer.add(ans);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // test me here.
    }
}