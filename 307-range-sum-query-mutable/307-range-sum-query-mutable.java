class NumArray {
    private int segmentTree[];
    private int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            segmentTree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int nums[]) {
        for (int i = n, j = 0; i < 2 * n; i++, j++) segmentTree[i] = nums[j];
        for (int i = n - 1; i > 0; --i) segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
    }

    public void update(int index, int val) {
        index += n;
        segmentTree[index] = val;
        while (index > 0) {
            int left = index, right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            segmentTree[index / 2] = segmentTree[left] + segmentTree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += segmentTree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += segmentTree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}
