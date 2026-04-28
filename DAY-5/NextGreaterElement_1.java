class NextGreaterElement_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int ans = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    ans = j;
                    break;
                }
            }
            int nextGreater = -1;
            for (int j = ans + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            res[i] = nextGreater;
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement_1 obj = new NextGreaterElement_1();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = obj.nextGreaterElement(nums1, nums2);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}