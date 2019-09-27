class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        // 情况1: 碰到 M ，直接翻转，然后return就完事了
        if(board[x][y] == 'M' || board[x][y] == 'X') {
            board[x][y] = 'X';
            return board;
        }
        // 情况2：当前碰到需要 E -> '0 -> 9' 的情况，此时翻转，然后直接return就完事了
        if(board[x][y] == 'E' && countPeriMine(x, y, board) > 0) {
            board[x][y] = (char)(countPeriMine(x, y, board) + '0');
            return board;
        }
        // 否则，当前碰到的是需要 -> 'B' 的情况
        board[x][y] = 'B';
        for(int[] d: dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] == 'E') {
                updateBoard(board, new int[]{nextX, nextY});
            }
        }

        return board;
    }
    private int countPeriMine(int x, int y, char[][] board) {
        int count = 0;
        for(int[] d: dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] == 'M') {
                count++;
            }
        }
        return count;
    }
}
