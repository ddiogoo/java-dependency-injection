package DependencyInjector;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {
    private final Map<Class<?>, Class<?>> mappings = new HashMap<>();

    public <T> void register(Class<T> interfaceType, Class<? extends T> implementationType) {
        mappings.put(interfaceType, implementationType);
    }

    public <T> T resolve(Class<T> interfaceType) throws Exception {
        Class<?> implementationType = mappings.get(interfaceType);

        if(implementationType == null) {
            throw new RuntimeException("Implementation not registered for" + interfaceType);
        }

        Constructor<?>[] constructors = implementationType.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];

        Object implementationInstance;
        if(constructor.getParameterCount() > 0) {
            Object[] params = new Object[constructor.getParameterCount()];
            for(int i = 0; i < params.length; i++) {
                params[i] = resolve(constructor.getParameterTypes()[i]);
            }
            implementationInstance = constructor.newInstance(params);
        } else {
            implementationInstance = constructor.newInstance();
        }

        for(var field : implementationType.getDeclaredFields()) {
            if(field.getType().isInterface()) {
                field.setAccessible(true);
                field.set(implementationInstance, resolve((Class<?>) field.getType()));
            }
        }

        return interfaceType.cast(implementationInstance);
    }
}
