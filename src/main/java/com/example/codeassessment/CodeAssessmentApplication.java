package com.example.codeassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CodeAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeAssessmentApplication.class, args);
    }

}
