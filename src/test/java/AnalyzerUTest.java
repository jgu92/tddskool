import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class AnalyzerUTest {

    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void isFullShouldReturnFalseIfBoardIsNotFull() {
        //Given
        board.play('X', 2);
        //When
        boolean result = Analyzer.isFull(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void isFullShouldReturnTrueIfBoardIsFull() {
        //Given
        board.setBoard(new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'}}
        );
        //When
        boolean result = Analyzer.isFull(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void horizontalAnalysisShouldReturnTrueIf4TokensOfTheSamePlayerAreAlignedHorizontaly(){
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'X', 'X', 'X', '.'},
                {'.', '.', '.', 'O', 'O', 'O', 'O'}}
        );
        //When
        boolean result = Analyzer.horizontalAnalysis(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void horizontalAnalysisShouldReturnFalseIfLessThan4TokensOfTheSamePlayerAreAlignedHorizontaly(){
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'X', 'X', 'X', '.'},
                {'.', '.', '.', 'O', 'O', 'O', 'X'}}
        );
        //When
        boolean result = Analyzer.horizontalAnalysis(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void verticalAnalysisShouldReturnTrueIf4TokensOfTheSamePlayerAreAlignedVerticaly(){
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'X', '.', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'}}
        );
        //When
        boolean result = Analyzer.verticalAnalysis(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void verticalAnalysisShouldReturnFalseIfLessThan4TokensOfTheSamePlayerAreAlignedVerticaly(){
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'},
                {'X', 'O', '.', '.', '.', '.', '.'}}
        );
        //When
        boolean result = Analyzer.verticalAnalysis(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }


    @Test
    public void diagonalRightAnalysisShouldReturnTrueIf4TokensOfTheSamePlayerAreAlignedDiagonally(){
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'X', '.', '.', '.', '.', '.', '.'},
                {'X', 'X', '.', '.', '.', '.', '.'},
                {'O', 'O', 'X', '.', '.', '.', '.'},
                {'X', 'O', 'O', 'X', '.', '.', '.'}}
        );
        //When
        boolean result = Analyzer.diagonalRight(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void diagonalRightAnalysisShouldReturnFalseIfLessThan4TokensOfTheSamePlayerAreAlignedDiagonally() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'X', '.', '.', '.', '.', '.', '.'},
                {'X', 'X', '.', '.', '.', '.', '.'},
                {'O', 'O', 'X', '.', '.', '.', '.'},
                {'X', 'O', 'O', 'O', '.', '.', '.'}}
        );
        //When
        boolean result = Analyzer.diagonalRight(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void diagonalLeftAnalysisShouldReturnTrueIf4TokensOfTheSamePlayerAreAlignedDiagonally() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'O', '.', '.', '.'},
                {'X', 'X', 'O', 'X', '.', '.', '.'},
                {'O', 'O', 'X', 'X', '.', '.', '.'},
                {'O', 'O', 'O', 'X', '.', '.', '.'}}
        );
        //When
        boolean result = Analyzer.diagonalLeft(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void checkVictoryShouldReturnTrueIfCurrentPlayerWon() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'O', 'X', '.', '.', '.'},
                {'X', 'X', 'O', 'O', '.', '.', '.'},
                {'O', 'O', 'X', 'X', 'O', '.', '.'},
                {'O', 'O', 'O', 'X', 'X', 'O', '.'}}
        );
        //When
        boolean result = Analyzer.checkVictory(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }
    @Test
    public void checkVictoryShouldReturnFalseIfCurrentPlayerHaventWonAtFirstTurn() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'O', 'X', '.', '.', '.'},
                {'X', 'X', 'O', 'O', '.', '.', '.'},
                {'O', 'O', 'X', 'X', 'X', '.', '.'},
                {'O', 'O', 'O', 'X', 'X', 'O', '.'}}
        );
        //When
        boolean result = Analyzer.checkVictory(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void checkNextTurnShouldReturnTrueIfPlayerCanContinue() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'O', 'X', '.', '.', '.'},
                {'X', 'X', 'O', 'O', '.', '.', '.'},
                {'O', 'O', 'X', 'X', 'X', '.', '.'},
                {'O', 'O', 'O', 'X', 'X', 'O', '.'}}
        );
        //When
        boolean result = Analyzer.checkNextTurn(board);
        //Then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void checkNextTurnShouldReturnFalseIfPlayerHasWon() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'O', 'X', '.', '.', '.'},
                {'X', 'X', 'O', 'X', '.', '.', '.'},
                {'O', 'O', 'X', 'X', 'X', '.', '.'},
                {'O', 'O', 'O', 'X', 'X', 'O', '.'}}
        );
        //When
        boolean result = Analyzer.checkNextTurn(board);
        //Then
        Assertions.assertThat(result).isFalse();
    }
}