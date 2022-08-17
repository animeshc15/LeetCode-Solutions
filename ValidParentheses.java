import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        if(s.length()==1){
            return false;
        }
        
        for(char c: s.toCharArray()){
            char rev = getReverseBracket(c);
            
            if(isLeftBracket(c)){
                stack.push(rev);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(!isLeftBracket(c) && stack.peek()!=c){
                return false;
            }
            
            else if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public boolean isLeftBracket(char c){
        if(c=='[' || c=='{' || c=='('){
            return true;
        }
        return false;
    }
    
    public char getReverseBracket(char c){
        if(c=='['){
            return ']';
        }
        else if(c=='{'){
            return '}';
        }
        else{
            return ')';
        }
    }
}