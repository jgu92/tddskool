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
    @Mock
    View view;

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
    public void launchGameShouldCallDisplayGrid1TimeIfCheckGameStateIsNotContinueStatus() {
        //Given
        //When
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("Board is Full. End of the game");
        application.launchGame(referee);
        //Then
        Mockito.verify(referee, Mockito.times(1)).displayGrid();
    }

    @Test
    public void launchGameShouldCallPlayWithArgument0() {
        //Given
        //When
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("Board is Full. End of the game");
        application.launchGame(referee);
        //Then
        Mockito.verify(referee, Mockito.times(1)).play(0);
    }

    @Test
    public void launchGameShouldCallViewWithEndArgument() {
        //Given
        //When
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("End");
        application.launchGame(referee);
        //Then
        Mockito.verify(view, Mockito.times(1)).printInformation("End");
    }

    @Test
    public void launchGameShouldCallViewWithCurrentPlayerArgument() {
        //Given
        //When
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("End");
        Mockito.when(referee.whoIsCurrentPlayer()).thenReturn("The current play is juju");
        application.launchGame(referee);
        //Then
        Mockito.verify(view, Mockito.times(1)).printInformation("The current play is juju");
    }

    @Test
    public void launchGameShouldCallViewWithDisplayGridArgument() {
        //Given
        Mockito.when(reader.ReadInput()).thenReturn(0);
        Mockito.when(referee.checkGameState()).thenReturn("End");
        Mockito.when(referee.displayGrid()).thenReturn("....");
        //When
        application.launchGame(referee);
        //Then
        Mockito.verify(view, Mockito.times(1)).printInformation("....");
    }


}