package com.liuhq.open.service.impl;

import com.liuhq.open.model.ChooseDTO;
import com.liuhq.open.model.ExamDto;
import com.liuhq.open.model.ItemDTO;
import com.liuhq.open.service.MongoTemplate;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Main;
import org.bson.Document;

import java.util.List;

public class MongoTemplateImpl implements MongoTemplate {
    private static MongoDatabase md;
    static {
        MongoClient mc = new MongoClient("localhost", 27017);
        md = mc.getDatabase("exam_open");
    }
    public void add(ItemDTO item) {
        MongoCollection<Document> exam = md.getCollection("exam");
        ExamDto doc = new ExamDto().init(item.getI1(),item.getI2(),item.getI7(),item.getChoices());
        exam.insertOne(doc);
    }

    public static void main(String[] args) {
        MongoTemplate mt = new MongoTemplateImpl();
        mt.add(ItemDTO.builder().i1("test").i2("test22").i7(List.of("1")).choices(List.of(new ChooseDTO("A","A.1",null))).build());
    }
}
