import DependencyInjector.DependencyInjector;
import Logger.ConsoleLogger;
import Logger.ILogger;
import Service.Service;

public class Main {
    public static void main(String[] args) {
        try {
            DependencyInjector di = new DependencyInjector();

            di.register(ILogger.class, ConsoleLogger.class);
            di.register(Service.class, Service.class);

            Service service = di.resolve(Service.class);
            service.doSomething();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}