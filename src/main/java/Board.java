public class Board {

    private static Integer height = 6;
    private static Integer width = 7;
    private char[][] board;

    public Board() {
        board = new char[height][width];
        initBoard();
    }

    public void initBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '.';
            }
        }
    }

    public boolean play(char player, int y) {
        if (y >= width || y < 0) {
            return false;
        }
        for (int x = height - 1; x >= 0; x--) {
            if (board[x][y] == '.') {
                board[x][y] = player;
                return true;
            }
        }
        return false;
    }

    public String display() {
        String result = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result += board[i][j];
            }
            result += "\n";
        }
        return result;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }
}
