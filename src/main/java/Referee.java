public class Referee {
    private char currentPlayer;
    private Board board;
    private Analyzer analyzer;

    public void startGame(){
        currentPlayer = 'X';
        board = new Board();
        analyzer = new Analyzer();
    }

    public Board getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String whoIsCurrentPlayer() {
        return "The current player is "+currentPlayer+"\n";
    }

    public String displayGrid() {
        return board.display();
    }

    public void play(int column) {
        board.play(currentPlayer,column);
    }

    public String checkGameState() {
        if(analyzer.checkVictory(board)){
            return currentPlayer+" has won";
        }
        if(analyzer.isFull(board)){
            return "Board is Full. End of the game";
        }
        return "Continue";
    }
}
