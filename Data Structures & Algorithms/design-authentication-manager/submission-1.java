//leetcode - https://leetcode.com/problems/design-authentication-manager/
//solution from discussion
class AuthenticationManager {    
    int timeLive;
    Map<String,Integer> map;
    public AuthenticationManager(int timeToLive) {
        timeLive = timeToLive;
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime+timeLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId))
        {
            if(map.get(tokenId)>currentTime)
            map.put(tokenId,currentTime+timeLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Integer value : map.values())
        {
              if(value > currentTime)count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
