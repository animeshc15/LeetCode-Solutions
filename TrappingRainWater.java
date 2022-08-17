/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.
 
Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/

class Solution {
    public int trap(int[] height) {
        
        int i=0, j= height.length-1, area= 0;
        
        int leftMax =height[i], rightMax = height[j];
        
        while(i<j){
            if(height[i] < height[j]){
                i++;
                leftMax = Math.max(height[i], leftMax);
                area+= leftMax- height[i];
            }
            else{
                j--;
                rightMax = Math.max(height[j],rightMax);
                area+= rightMax - height[j];
            }
        }
        return area;
        
    }
}