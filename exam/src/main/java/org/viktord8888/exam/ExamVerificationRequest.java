package org.viktord8888.exam;

import exam.Answer;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamVerificationRequest {

    private String[] answers;

    public Map<Integer, Answer> getAnswersAsMap() {
        Map<Integer, Answer> mapAnswers = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            mapAnswers.put(i, Answer.valueOf(answers[i]));
        }

        return mapAnswers;
    }
}
