
class Solution {
    HashMap<Integer, String> map;
    HashMap<String, Integer> memo;

    public int numDecodings(String s) {
        // Populate hashmap
        this.map = new HashMap<>();
        this.memo = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c - 'A' + 1, String.valueOf(c));
        }

        return dfs(s);
    }

    public int dfs(String s) {
        System.out.println("String is - " + s);

        // Base case
        if (s.isEmpty()) {
            return 1;
        }

        // Check memo
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int res = 0;

        // Decode one char
        if (s.length() > 0) {
            String one = s.substring(0, 1);

            if (map.containsKey(Integer.parseInt(one))) {
                String remaining = s.substring(1);
                res += dfs(remaining);
            }
        }

        // Decode two char
        if (s.length() > 1) {
            String two = s.substring(0, 2);

            if (two.charAt(0) != '0' && map.containsKey(Integer.parseInt(two))) {
                String remaining = s.substring(2);
                res += dfs(remaining);
            }
        }

        // Store result in memo
        memo.put(s, res);

        return res;
    }
}
