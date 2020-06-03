package com.liuhq.open.service;

import com.liuhq.open.model.ItemDTO;

public interface MongoTemplate {
    void add(ItemDTO dto);
}
