import java.util.*;
class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int val = sc.nextInt();
        RemoveElement obj = new RemoveElement();
        int k = obj.removeElement(nums, val);
        System.out.println(k);
        for(int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}