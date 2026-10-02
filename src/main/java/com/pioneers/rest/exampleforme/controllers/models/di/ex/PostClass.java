package com.pioneers.rest.exampleforme.controllers.models.di.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
@Slf4j
public class PostClass implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      final Environment environment = context.getEnvironment();
      final String[] active = environment.getActiveProfiles();
      log.info("active [{}] " , active);
      int x = 5;
      if (x != 5) {
          return false;
      }
        return true;
    }
}
