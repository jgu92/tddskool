import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RefereeUTest {

    Referee referee;

    @Before
    public void setUp() throws Exception {
        referee = new Referee();
        referee.startGame();

    }

    @Test
    public void startGameShouldSetCurrentPlayerAsX(){
        //Given
        //When
        char result = referee.getCurrentPlayer();
        //Then
        Assertions.assertThat(result).isEqualTo('X');
    }

    @Test
    public void startGameShouldInitGameBoard(){
        //Given
        char[][] expected = new char[][]
                {
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'}};
        //When
        char[][] result = referee.getBoard().getBoard();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void whoIsCurrentPlayerShouldReturnStringWithXPlayer(){
        //Given
        String expected = "The current player is X\n";
        //When
        String result = referee.whoIsCurrentPlayer();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void displayGridShouldReturnStringWithTheBoardGame() {
        //Given
        String expected = ".......\n.......\n.......\n.......\n.......\n.......\n";
        //When
        String result = referee.displayGrid();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void playShouldChangBoardWithPlayedActionOfX() {
        //Given
        String expected = ".......\n.......\n.......\n.......\n.......\n..X....\n";
        //When
        referee.play(2);
        String result = referee.displayGrid();

        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void checkGameStateShouldReturnXHasWon() {
        //Given
        referee.play(2);
        referee.play(3);
        referee.play(2);
        referee.play(4);
        referee.play(2);
        referee.play(0);
        referee.play(2);

        //When
        String result = referee.checkGameState();

        //Then
        Assertions.assertThat(result).isEqualTo("X has won");
    }
    @Test
    public void checkGameStateShouldReturnFullIfAndCurrentPlayerHaveNotWon() {
        //Given
        referee.getBoard().setBoard(new char[][]{
                {'O', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'O', 'X', 'O', 'O'}}
        );

        //When
        String result = referee.checkGameState();

        //Then
        Assertions.assertThat(result).isEqualTo("Board is Full. End of the game");
    }


    @Test
    public void orderOfMethodsShouldVerifyGameStateBeforeNextTurn() {
        //Given
        referee.play(2);
        referee.checkGameState();
        referee.play(3);
        referee.checkGameState();
        referee.play(2);
        referee.checkGameState();
        referee.play(4);
        referee.checkGameState();
        referee.play(2);
        referee.checkGameState();
        referee.play(0);
        referee.checkGameState();
        referee.play(2);

        //When
        String result = referee.checkGameState();

        //Then
        Assertions.assertThat(result).isEqualTo("X has won");
    }

}