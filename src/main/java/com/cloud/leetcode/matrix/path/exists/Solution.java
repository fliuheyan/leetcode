package com.cloud.leetcode.matrix.path.exists;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length - 1;
        int column = board[row].length - 1;
        int wordIndex = 0;//the index of the word
        for (int currColumn = 0; currColumn < column; currColumn++) {
            for (int currRow = 0; currRow < row; currRow++) {
                char current = word.charAt(wordIndex);
                if (board[currRow][currColumn] == current) {
                    if (dfs(currRow, currColumn, word, wordIndex, board)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int column, String word, int wordIndex, char[][] board) {
        //终止条件，1.越界或者不相等
        if (row < 0 || row > board.length - 1
                || column < 0 || column > board[row].length - 1
                || board[row][column] != word.charAt(wordIndex)
        ) return false;
        // 2. 当已经搜索完所有字符串
        if (wordIndex == word.length() - 1) return true;
        // 当前访问过的标记为\0
        board[row][column] = '\0';
        // dfs 搜索四周
        boolean result = dfs(row - 1, column, word, wordIndex + 1, board)
                || dfs(row + 1, column, word, wordIndex + 1, board)
                || dfs(row, column - 1, word, wordIndex + 1, board)
                || dfs(row, column + 1, word, wordIndex + 1, board);
        // 把当前位置改回来
        board[row][column] = word.charAt(wordIndex);
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input1 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean result1 = solution.exist(input1, "ABCCED");
        Preconditions.checkArgument(result1);
    }
}
