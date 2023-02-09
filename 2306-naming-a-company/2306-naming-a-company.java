class Solution {
       public long distinctNames(String[] ideas) {
       List<String> list[] = new ArrayList[26];
       long possiblePair = 0;
       for(int i = 0; i < 26; i++)
           list[i] = new ArrayList<>();
       for(String s : ideas)
           list[s.charAt(0) - 'a'].add(s.substring(1));
       for(int i = 0; i < 25; i++) {
           for(int j = i + 1; j < 26; j++) {
               Set<String> set = new HashSet<>();
               set.addAll(list[i]);
               set.addAll(list[j]);
               possiblePair += (list[i].size() - set.size()) * (list[j].size() - set.size());
           }
       }
       return possiblePair * 2;
   }
}