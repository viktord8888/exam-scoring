package org.viktord8888.config;

import exam.ExamScoringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamVerificationConfig {

    @Bean
    public ExamScoringService examScoringService() {
        return new ExamScoringService();
    }
}
