class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            mp.put(arr1[i], mp.getOrDefault(arr1[i], 0) + 1);
        }

        int firstPointer = 0;

        for (int num : arr2) {
            int count = mp.get(num);
            for (int i = 0; i < count; i++) {
                arr1[firstPointer++] = num;
            }
            mp.remove(num); 
        }

        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(entry.getKey());
            }
        }

        Collections.sort(remaining);
        for (int num : remaining) {
            arr1[firstPointer++] = num;
        }

        return arr1;
    }
}