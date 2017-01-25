public class Analyzer {

    public static boolean isFull(Board board) {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean horizontalAnalysis(Board board) {

        for (int i = 0; i < board.getBoard().length; i++) {
            boolean winHorizontalForO = String.valueOf(board.getBoard()[i]).contains("OOOO");
            boolean winHorizontalForX = String.valueOf(board.getBoard()[i]).contains("XXXX");

            if (winHorizontalForX || winHorizontalForO) {
                return true;
            }
        }
        return false;
    }

    public static boolean verticalAnalysis(Board board) {
        for (int i = 0; i < board.getBoard().length-3; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] != '.') {
                    int counter = 1;
                    char currentToken = board.getBoard()[i][j];
                    for(int k=i+1;k<=i+3;k++){
                        if(board.getBoard()[k][j]==currentToken) {
                            counter++;
                        }
                    }
                    if(counter==4){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean diagonalRight(Board board) {

        for (int i = 0; i < board.getBoard().length-3; i++) {
            for (int j = 0; j < board.getBoard()[i].length-3; j++) {
                if (board.getBoard()[i][j] != '.') {
                    int counter = 1;
                    char currentToken = board.getBoard()[i][j];
                    for(int k=1;k<=3;k++){
                        if(board.getBoard()[i+k][j+k]==currentToken) {
                            counter++;
                        }
                    }
                    if(counter==4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean diagonalLeft(Board board) {
        for (int i = 0; i < board.getBoard().length-3; i++) {
            for (int j = 3; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] != '.') {
                    int counter = 1;
                    char currentToken = board.getBoard()[i][j];
                    for(int k=1;k<=3;k++){
                        if(board.getBoard()[i+k][j-k]==currentToken) {
                            counter++;
                        }
                    }
                    if(counter==4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkVictory(Board board) {
        if(horizontalAnalysis(board) || verticalAnalysis(board) || diagonalLeft(board) || diagonalRight(board)){
            return true;
        }
        return false;
    }

    public static boolean checkNextTurn(Board board) {
        return (!checkVictory(board) && !isFull(board));
    }
}
