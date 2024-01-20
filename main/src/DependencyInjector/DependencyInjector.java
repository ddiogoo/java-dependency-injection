package DependencyInjector;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {
    private final Map<Class<?>, Class<?>> mappings = new HashMap<>();

    public <T> void register(Class<T> interfaceType, Class<? extends T> implementationType) {
        mappings.put(interfaceType, implementationType);
    }
}
