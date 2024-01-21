import DependencyInjector.DependencyInjector;
import Logger.ConsoleLogger;
import Logger.FileLogger;
import Logger.ILogger;
import Service.Service;

public class Main {
    public static void main(String[] args) {
        try {
            DependencyInjector injectorConsole = new DependencyInjector();
            injectorConsole.register(ILogger.class, ConsoleLogger.class);
            injectorConsole.register(Service.class, Service.class);
            Service serviceConsole = injectorConsole.resolve(Service.class);
            serviceConsole.doSomething("hello");

            DependencyInjector injectorFile = new DependencyInjector();
            injectorFile.register(ILogger.class, FileLogger.class);
            injectorFile.register(Service.class, Service.class);
            Service serviceFile = injectorFile.resolve(Service.class);
            serviceFile.doSomething("hello");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}