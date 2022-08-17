/*20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/



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
