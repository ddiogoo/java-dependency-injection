package Logger;

public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}
