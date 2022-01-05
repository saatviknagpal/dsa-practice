class Solution {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image.length - 1;

            while (start <= end) {
                if (image[i][start] == 0) {
                    image[i][start] = 1;
                } else {
                    image[i][start] = 0;
                }
                start++;
            }
        }
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image.length - 1;

            while (start < end) {
                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;
                start++;
                end--;
            }
        }
        return image;
    }
}
