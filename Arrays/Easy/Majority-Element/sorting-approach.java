// just sort the array and print the middle element as majority element will always be at middle.
// Time Complexity : O(nlogn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
