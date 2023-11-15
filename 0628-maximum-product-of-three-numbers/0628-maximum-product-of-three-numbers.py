class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        nums.sort()
        
        if nums[0] >= 0:
            return nums[-1] * nums[-2] * nums[-3]
        else:
            return max(nums[0] * nums[1] * nums[-1],  nums[-1] * nums[-2] * nums[-3])
        