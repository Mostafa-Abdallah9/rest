package com.pioneers.rest.exampleforme.controllers.models.di.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties(ClassPropeties.class)
public class ClasstConfig {
    private static final Logger log = LoggerFactory.getLogger(ClasstConfig.class);
    private final ClassPropeties classPropeties;

    @Autowired
    public ClasstConfig(ClassPropeties classPropeties) {
        this.classPropeties = classPropeties;
    }

    @Bean
//    @ConditionalOnClass(ClassB.class)
//    @ConditionalOnProperty(name = "most.fName",havingValue = "mostafa")
//    @ConditionalOnBean(ClassB.class)
//    @ConditionalOnMissingBean(ClassA.class)
//    @Conditional(PostClass.class)
    public ClassA classA1() {
        log.info("aaaaaaaaaaaaaaaa");
        log.info("fName [{}] fPassword  [{}]",classPropeties.fName(),classPropeties.fPassword());
        return new ClassA("mostafa","1234");
    }
    @Primary
    @Bean
    public ClassA classA2() {
       log.info("bbbbbbbbbbbbb");
        return new ClassA("Ahmed", "5678");
    }

}
