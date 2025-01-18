class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String line){
            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalidResults = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            
            boolean isInvalid = false;
            
            if(t.amount > 1000) {
                isInvalid = true;
            }

            List<Transaction> relatedTransactions = map.getOrDefault(t.name, new ArrayList<>());
            for(Transaction other : relatedTransactions) {
                if(Math.abs(other.time - t.time) <= 60 && !other.city.equals(t.city)) {
                    isInvalid = true;
                    break;
                }
            }

            if(isInvalid) {
                invalidResults.add(transaction);
            }
        }

        return invalidResults;
    }
}
