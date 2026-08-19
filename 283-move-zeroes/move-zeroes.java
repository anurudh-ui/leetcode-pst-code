class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0; // Pointer for the next non-zero element's position
        
        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
                left++; 
            }
        }
    }
}