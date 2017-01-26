public class Application {
    private Reader reader;

    public Application(Reader reader) {
        this.reader = reader;
    }

    public static void main(String[] args) {
        Application application = new Application(new Reader());
        Referee referee = new Referee();
        application.startGame(referee);
        application.launchGame(referee);
    }

    public void startGame(Referee referee) {
        referee.startGame();

    }

    public void launchGame(Referee referee) {
        String currentState = "Continue";
        while (currentState.equals("Continue")) {
            referee.displayGrid();
            referee.whoIsCurrentPlayer();
            System.out.println("Which column do you want to play ?");
            int position = reader.ReadInput();
            referee.play(position);
            currentState = referee.checkGameState();
        }
        System.out.println(currentState);
        System.out.println("ADIEEUUUU");
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
