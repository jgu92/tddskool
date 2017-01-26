public class Application {
    private Reader reader;
    private View view;

    public Application(Reader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    public static void main(String[] args) {
        Application application = new Application(new Reader(), new View());
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
            view.printInformation(referee.displayGrid());
            view.printInformation(referee.whoIsCurrentPlayer());
            view.printInformation("Which column do you want to play ?");
            int position = reader.ReadInput();
            referee.play(position);
            currentState = referee.checkGameState();
        }
        view.printInformation(currentState);
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
