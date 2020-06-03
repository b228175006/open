package com.liuhq.open.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目记录
 */
public class ExamDto extends Document {

    public ExamDto() {
    }

    public ExamDto init(String id, String subject, List<String> options, List<ChooseDTO> answer){
        ExamDto dto = new ExamDto();
        dto.append("id", id);
        dto.append("subject",subject);
        dto.append("options",options);
        List<Document> collect = answer.stream().map(a -> {
            return new Document("i1", a.getI1()).append("i2", a.getI2()).append("isCorrect", a.getIsCorrect());
        }).collect(Collectors.toList());
        dto.append("answer",collect);
        return dto;
    }
}
