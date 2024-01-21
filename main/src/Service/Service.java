package Service;

import Logger.ILogger;

public class Service {
    private final ILogger logger;

    public Service(ILogger logger) {
        this.logger = logger;
    }

    public void doSomething(String message) {
        logger.log(message);
    }
}
