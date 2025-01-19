class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> ls;

    public RandomizedSet() {
        map = new HashMap<>();
        ls = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        ls.add(val);
        map.put(val, ls.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int idx = map.get(val); // access index which we have to remove;
        int lastElement = ls.get(ls.size() - 1);

        ls.set(idx, lastElement);
        map.put(lastElement, idx);

        ls.remove(ls.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(((ls.size()-1) - 0) + 1) + 0;
        return ls.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */