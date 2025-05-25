class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);

                if (i == 1)
                    continue;

                String prevEmail = account.get(i - 1);
                graph.computeIfAbsent(prevEmail, x -> new ArrayList<>());
                graph.computeIfAbsent(email, x -> new ArrayList<>());

                graph.get(prevEmail).add(email);
                graph.get(email).add(prevEmail);
            }

        }

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        for (String email : emailToName.keySet()) {
            if (!visited.contains(email)) {
                List<String> connectedEmails = new ArrayList<>();

                dfs(email, graph, visited, connectedEmails);

                Collections.sort(connectedEmails);

                connectedEmails.add(0, emailToName.get(email));

                result.add(connectedEmails);
            }
        }
        return result;
    }

    private void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> result) {
        visited.add(email);
        result.add(email);
        if (!graph.containsKey(email))
            return;
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, result);
            }
        }
    }
}