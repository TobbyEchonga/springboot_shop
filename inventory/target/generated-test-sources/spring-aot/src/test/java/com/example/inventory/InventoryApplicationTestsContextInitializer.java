package com.example.inventory;

import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class InventoryApplicationTestsContextInitializer {
  public static void registerAppController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("appController", AppController.class)
        .instanceSupplier((instanceContext) -> {
          AppController bean = new AppController();
          instanceContext.field("service", ProductService.class)
              .invoke(beanFactory, (attributes) -> {
                Field serviceField = ReflectionUtils.findField(AppController.class, "service", ProductService.class);
                ReflectionUtils.makeAccessible(serviceField);
                ReflectionUtils.setField(serviceField, bean, attributes.get(0));
              });
              return bean;
            }).register(beanFactory);
      }

      public static void registerProductService(DefaultListableBeanFactory beanFactory) {
        BeanDefinitionRegistrar.of("productService", ProductService.class)
            .instanceSupplier((instanceContext) -> {
              ProductService bean = new ProductService();
              instanceContext.field("repo", ProductRepository.class)
                  .invoke(beanFactory, (attributes) -> {
                    Field repoField = ReflectionUtils.findField(ProductService.class, "repo", ProductRepository.class);
                    ReflectionUtils.makeAccessible(repoField);
                    ReflectionUtils.setField(repoField, bean, attributes.get(0));
                  });
                  return bean;
                }).register(beanFactory);
          }
        }
