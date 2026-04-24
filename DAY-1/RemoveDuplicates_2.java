import java.util.*;
class RemoveDuplicates_2 {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[k - 2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        RemoveDuplicates_2 obj = new RemoveDuplicates_2();
        int k = obj.removeDuplicates(nums);
        System.out.println(k);
        for(int i = 0; i < k; i++){
            System.out.print(nums[i] + " ");
        }
    }
}