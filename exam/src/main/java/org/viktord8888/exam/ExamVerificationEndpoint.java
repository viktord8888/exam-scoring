package org.viktord8888.exam;

import exam.Answer;
import exam.ExamResult;
import exam.ExamScoringService;
import exam.StandardPointsCountingPolicy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExamVerificationEndpoint {

    private static final Map<Integer, Answer> correctAnswers = Map.of(
            0, Answer.B,
            1, Answer.B,
            2, Answer.C,
            3, Answer.A,
            4, Answer.D
            );

    private final ExamScoringService examScoringService;

    public ExamVerificationEndpoint(ExamScoringService examScoringService) {
        this.examScoringService = examScoringService;
    }

    @PostMapping("/verify")
    ExamResult verifyExam(@RequestBody ExamVerificationRequest examVerificationRequest) {
        return examScoringService.countPoints(examVerificationRequest.getAnswersAsMap(), correctAnswers, new StandardPointsCountingPolicy());
    }


}
