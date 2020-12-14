package com.jionghong.mongodb.service;

import com.jionghong.mongodb.dao.CommentRepository;
import com.jionghong.mongodb.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    //inject dao
    @Autowired
    private CommentRepository commentRepository;

    //inject MongoTemplate
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * save a comment
     * @param comment
     */
    public void saveComment(Comment comment){

        commentRepository.save(comment);
    }
    /**
     * update comment
     * @param comment
     */
    public void updateComment(Comment comment){
//调用dao
        commentRepository.save(comment);
    }
    /**
     * delete comment by id
     * @param id
     */
    public void deleteCommentById(String id){

        commentRepository.deleteById(id);
    }
    /**
     * query all the comments
     * @return
     */
    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }
    /**
     * query comment by id
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }

    /**
     * paging query
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Comment> findCommentListPageByParentid(String parentid, int page , int size){
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));
    }
    /**
     * like count +1
     * @param id
     */
    public void updateCommentLikenum(String id){
        //query object
        Query query= Query.query(Criteria.where("_id").is(id));
        //update obejct
        Update update=new Update();
        //$set
        // update.set(key,value)
        //$inc
        // update.inc("likenum",1);
        update.inc("likenum");
        //param 1：query object
        //param 2: update object
        //param 3: collection name
        mongoTemplate.updateFirst(query,update,"comment");
    }
}
