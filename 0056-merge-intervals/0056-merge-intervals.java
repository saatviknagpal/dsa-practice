class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(b -> b[0]));   
        // List<List<Integer>> list = new ArrayList<>();

        // for(int i = 0; i < a.length; i++){
        //     List<Integer> temp = new ArrayList<>();
        //     for(int j = 0; j < a[0].length; j++){
        //         if(a[i][1] > a[i+1][0]){
        //             a[i][1] = max(a[i+1][1], a[i][1];
        //             temp.add(a[i][1]);
        //             i++;
        //         } else {
        //             temp.add(a[i][j]);
        //         }
        //     }
        //     list.add(temp);
        // }

        // int[][] array2D = new int[a.length][2];
        
        // for (int i = 0; i < a.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         array2D[i][j] = list.get(i).get(j);
        //     }
        // }

        int n = intervals.length;
        int[][] result = new int[n][2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (index == 0 || result[index - 1][1] < intervals[i][0]) {
                result[index++] = intervals[i];
            } else {
                result[index - 1][1] = Math.max(result[index - 1][1], intervals[i][1]);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}