package com.cloud.leetcode.matrix.spiral.order;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new int[]{};
        int column = matrix[0].length;
        int total = row * column;
        boolean[][] visited = new boolean[row][column];
        int startX = 0, startY = 0;
        Direction currDirection = Direction.E;
        int[] result = new int[total];
        for (int index = 0; index < total; index++) {
            visited[startX][startY] = true;
            result[index] = matrix[startX][startY];
            int tempX = startX + currDirection.row;
            int tempY = startY + currDirection.column;
            if (tempX > row - 1 || tempX < 0
                    || tempY > column - 1 || tempY < 0
                    || visited[tempX][tempY]) {
                currDirection = currDirection.next();
            }
            startX += currDirection.row;
            startY += currDirection.column;
        }
        return result;
    }

    enum Direction {
        E(0, 1), S(1, 0), W(0, -1), N(-1, 0);
        private int row;
        private int column;

        Direction(int x, int y) {
            this.row = x;
            this.column = y;
        }

        public Direction next() {
            Direction[] directions = Direction.values();
            int index = this.ordinal();
            return directions[(index + 1) % directions.length];
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.spiralOrder(input);
    }
}
