package com.dilipblog.simpleframework.section5.framework;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.section5.framework.annotation.Autowired;
import com.dilipblog.simpleframework.section5.framework.annotation.Component;
import com.dilipblog.simpleframework.section5.framework.exception.SimpleFrameworkException;

public class ApplicationContext {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationContext.class);
  private final Set<Class<?>> beanTypes;
  private final Map<Class<?>, Object> beanInstances = new HashMap<>();

  public ApplicationContext(final Class<?> mainAplicationClass) {
    // get reflection object for main application class's package
    final String packageName = mainAplicationClass.getPackage().getName();
    final Reflections reflections = new Reflections(packageName);
    // get all the classes that are annotated with @Component annotation
    // we ignore interfaces here
    this.beanTypes = reflections.getTypesAnnotatedWith(Component.class).stream()
        .filter(clazz -> !clazz.isInterface())
        .collect(Collectors.toSet());

    logger.info(String.format("Found %1$s beans under package: %2$s", beanTypes.size(), packageName));
  }

  /**
   * This method is used to get beans from application context
   */
  public <T> T getBean(final Class<T> clazz) {
    if (!clazz.isInterface()) {
      throw new SimpleFrameworkException(
          String.format("Provided class %1$s should be an interface", clazz.getName()));
    }
    if (!beanInstances.containsKey(clazz)) {
      logger.info("Instantiating a new bean for type: " + clazz.getName());
      final Class<T> impl = getImplementationForInterface(clazz);
      final T beanInstance = createBean(clazz, impl);
      beanInstances.put(clazz, beanInstance);
    }
    return (T) beanInstances.get(clazz);
  }

  private <T> Class<T> getImplementationForInterface(final Class<T> interfaceClass) {
    final Set<Class<?>> classes = beanTypes.stream()
        .filter(bean -> List.of(bean.getInterfaces()).contains(interfaceClass))
        .collect(Collectors.toSet());

    if (classes.size() > 1) {
      throw new SimpleFrameworkException("There are more than 1 implementations for interface: " + interfaceClass.getName());
    }

    return (Class<T>) classes.stream()
        .findFirst()
        .orElseThrow(() ->
            new SimpleFrameworkException("Cannot find an implementation for interface: " + interfaceClass.getName()));
  }

  private <T> T createBean(final Class<T> clazz, final Class<T> implementation) {
    try {
      final Constructor<T> constructor = getConstructor(implementation);
      final Object[] parameters = getConstructorParams(constructor);
      return constructor.newInstance(parameters);
    } catch (Exception e) {
      throw new SimpleFrameworkException(e);
    }
  }

  private <T> Constructor<T> getConstructor(final Class<T> clazz) {
    final Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();

    // if there is only one constructor, we return it right away
    if (constructors.length == 1) {
      return constructors[0];
    }

    final Set<Constructor<T>> autowiredConstructors = Arrays.stream(constructors)
        .filter(constructor -> constructor.isAnnotationPresent(Autowired.class))
        .collect(Collectors.toSet());

    if (autowiredConstructors.size() > 1) {
      throw new SimpleFrameworkException("There are more than 1 autowired constructors in class: " + clazz.getName());
    }

    return autowiredConstructors.stream()
        .findFirst()
        .orElseThrow(() -> new SimpleFrameworkException("Cannot find an autowired constructor in class: " + clazz.getName()));

  }

  private <T> Object[] getConstructorParams(final Constructor<T> constructor) {
    final Class<?>[] parameterTypes = constructor.getParameterTypes();
    return Arrays.stream(parameterTypes)
        .map(this::getBean)
        .toArray(Object[]::new);
  }

}
