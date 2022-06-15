package com.sparta.studywebpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaAuditing
public class StudywebpageApplication {
    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:aws.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(StudywebpageApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}

