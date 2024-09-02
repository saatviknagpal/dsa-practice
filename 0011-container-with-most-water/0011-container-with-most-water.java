class Solution {
    public int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int h = Math.min(height[right], height[left]);
            maxArea = Math.max(width * h, maxArea);

            if(height[left] < height[right]){
                left += 1;
            } else {
                right -=1;
            }
        }

        return maxArea;
    }
}