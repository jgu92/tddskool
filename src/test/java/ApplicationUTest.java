import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationUTest {
    @InjectMocks
    Application application;
    @Mock
    Reader reader;
    @Mock
    Referee referee;

    @Test
    public void startGameShouldCallStartGame() {
        //Given
        //When
        application.startGame(referee);
        //Then
        Mockito.verify(referee, Mockito.times(1)).startGame();
    }

    @Test
    public void launchGameShouldCallDisplayGrid() {
        //Given
        //When
        Mockito.when(referee.checkGameState()).thenReturn("End");
        Mockito.when(reader.ReadInput()).thenReturn(0);
        application.launchGame(referee);
        //Then
        Mockito.verify(referee).displayGrid();
    }

    @Test
    public void launchGameShouldCallWhoIsPlayer() {
        //Given
        //When
        Mockito.when(referee.checkGameState()).thenReturn("End");
        Mockito.when(reader.ReadInput()).thenReturn(0);
        application.launchGame(referee);
        //Then
        Mockito.verify(referee).whoIsCurrentPlayer();
    }

    @Test
    public void launchGameShouldCallPlay1TimeIfCheckGameStateIsNotContinueStatus() {
        //Given
        //When
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("Board is Full. End of the game");
        application.launchGame(referee);
        //Then
        Mockito.verify(referee, Mockito.times(1)).displayGrid();
    }
}