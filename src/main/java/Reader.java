import java.util.Scanner;

public class Reader {
    Scanner scanner;

    public Reader(){
        scanner = new Scanner(System.in);
    }

    public Integer ReadInput(){
        return scanner.nextInt();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
