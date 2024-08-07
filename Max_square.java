// Time Complexity : O(m*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//TC O(m*n)^2 / SC O(1)
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         if(matrix == null || matrix.length == 0){
//             return -1;
//         }
//         int m = matrix.length; //row
//         int n = matrix[0].length; //col
//         int max = 0;

//         for(int i = 0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(matrix[i][j] == '1'){
//                     int curr = 1;
//                     boolean flag = true; 
//                     while(i+curr < m && j+curr < n && flag == true){
//                         //check row for same column
//                         for(int k = i+curr; k >= i; k--){
//                             if(matrix[k][j+curr] != '1')
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         //check column for same row
//                         for(int k = j+curr; k >= j; k--){
//                             if(matrix[i+curr][k] != '1')
//                             {
//                                 flag = false;
//                                 break;
//                             }
//                         }
//                         if(flag == true){
//                             curr++;
//                         }
//                     }
//                     max = Math.max(max, curr);
//                 }
//             }
//         }
//         return max * max;
//     }
// }
// TC O(m*n) / SC O(m*n)
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         if(matrix == null || matrix.length == 0){
//             return -1;
//         }
//         int m = matrix.length; //row
//         int n = matrix[0].length; //col
//         int[][] dp = new int[m+1][n+1];
//         int max = 0;
//         for(int i =1; i<m+1; i++){
//             for(int j = 1; j<n+1; j++){
//                 if(matrix[i-1][j-1] == '1'){
//                     dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//                     max = Math.max(max, dp[i][j]);
//                 }
//             }
//         }
//         return max * max;
//     }
// }
//TC O(m*n) / SC O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return -1;
        }
        int m = matrix.length; //row
        int n = matrix[0].length; //col
        int[] dp = new int[n+1];
        int max = 0;
        for(int i =1; i<m+1; i++){
            int temp = dp[0];
            for(int j = 1; j<n+1; j++){
                int prev = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], temp));
                    max = Math.max(max, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                temp = prev;
            }
        }                      
        return max * max;
    }
}