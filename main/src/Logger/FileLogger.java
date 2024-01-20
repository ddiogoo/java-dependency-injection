package Logger;

public class FileLogger implements ILogger {
    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        System.out.println("File: " + message);
    }
}
