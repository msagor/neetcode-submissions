// LeetCode: Design Authentication Manager
// https://leetcode.com/problems/design-authentication-manager/

class AuthenticationManager {

    // How long each token remains valid after being generated or renewed
    int timeLive;

    // Map:
    // Key   -> tokenId
    // Value -> expiration time of that token
    //
    // Example:
    // "abc" -> 8
    // This means token "abc" expires at time 8.
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        timeLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {

        // A newly generated token expires at:
        //
        // currentTime + timeToLive
        //
        // Example:
        // timeToLive = 5
        // currentTime = 3
        // expirationTime = 8
        map.put(tokenId, currentTime + timeLive);
    }

    public void renew(String tokenId, int currentTime) {

        // First, check whether this token exists in the map
        if (map.containsKey(tokenId)) {

            // Check whether the token is still unexpired.
            //
            // Important:
            // expirationTime > currentTime
            //
            // If expirationTime == currentTime,
            // the token is already expired.
            if (map.get(tokenId) > currentTime) {

                // Renew the token by assigning it a new expiration time.
                //
                // Example:
                // currentTime = 10
                // timeLive = 5
                // new expirationTime = 15
                map.put(tokenId, currentTime + timeLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {

        int count = 0;

        // Iterate through all expiration times stored in the map
        for (Integer expirationTime : map.values()) {

            // A token is unexpired only if:
            //
            // expirationTime > currentTime
            //
            // Example:
            // expirationTime = 10
            // currentTime = 7
            // 10 > 7 -> token is still valid
            if (expirationTime > currentTime) {
                count++;
            }
        }

        return count;
    }
}
