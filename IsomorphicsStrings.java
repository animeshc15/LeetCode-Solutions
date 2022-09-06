public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        HashMap<Character,Character> hp = new HashMap<Character,Character>();
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if(hp.containsKey(a))
                if(hp.get(a).equals(b))
                    continue;
                else
                    return false;
            if(!hp.containsKey(a) && !hp.containsValue(b)){
                hp.put(a,b);
                continue;
            }
            else if(!hp.containsKey(a) && hp.containsValue(b)){
                return false;
            }
        }
        return true;
    }
}