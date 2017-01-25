import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BoardUTest {

    Board board;
    char[][] cleanBoard = new char[][]
            {
                    {'.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.'}};

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void constructorShouldReturnAnInitializedyGameBoard() {
        //Given
        char[][] expected = cleanBoard;
        //When
        char[][] result = board.getBoard();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);

    }

    @Test
    public void playShouldPutTokenInTheGameBoard() {
        //Given
        char[][] expected =
                {
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', 'O', '.', '.', '.', '.'}};
        //When
        board.play('O', 2);
        char[][] result = board.getBoard();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void playShouldPutTokenOnOthersTokensInTheGameBoard() {
        //Given
        char[][] expected =
                {
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', 'X', '.', '.', '.', '.'},
                        {'.', '.', 'O', '.', '.', '.', '.'},
                        {'.', '.', 'X', '.', '.', '.', '.'},
                        {'.', '.', 'O', '.', '.', '.', '.'}};
        board.setBoard(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'},
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'}}
        );
        //When
        board.play('X', 2);
        char[][] result = board.getBoard();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }


    @Test
    public void playShouldReturnFalseWhenPlayerPlayedOnAFullColumn() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'},
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'},
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'}}
        );
        //When
        boolean result = board.play('X', 2);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void playShouldReturnFalseWhenPlayerPlayedOnOutOfBoard() {
        //Given

        //When
        boolean result = board.play('X', 10);
        //Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void displayShouldReturnFormattedStringWithTheBoard() {
        //Given
        String expected = ".......\n.......\n.......\n.......\n.......\n......O\n";
        //When
        board.play('O', 6);
        String result = board.display();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);

    }

    @Test
    public void initBoardShouldCleanTheBoard() {
        //Given
        board.setBoard(new char[][]{
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'},
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'},
                {'.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', 'O', '.', '.', '.', '.'}}
        );
        char[][] expected = cleanBoard;
        //When
        board.initBoard();
        char[][] result = board.getBoard();
        //Then
        Assertions.assertThat(result).isEqualTo(expected);

    }

}