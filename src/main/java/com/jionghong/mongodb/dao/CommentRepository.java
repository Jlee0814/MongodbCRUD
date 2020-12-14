package com.jionghong.mongodb.dao;

import com.jionghong.mongodb.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
    //pagination
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
