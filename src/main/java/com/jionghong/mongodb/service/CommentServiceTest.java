package com.jionghong.mongodb.service;

import com.jionghong.mongodb.MongodbApplication;
import com.jionghong.mongodb.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.time.LocalDateTime;
import java.util.List;

//SpringBoot Junit
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = MongodbApplication.class)
public class CommentServiceTest {
    //注入Service
    @Autowired
    private CommentService commentService;
    /**
     * save a comment
     */
    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("test");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("casa");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }
    /**
     * query all data
     */
    @Test
    public void testFindAll(){
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }
    /**
     * query by id
     */
    @Test
    public void testFindCommentById(){
        Comment comment = commentService.findCommentById("5fd6936e0c53ac3e8087bc3a");
        System.out.println(comment);
    }

    /**
     * find sub comment based on parent id
     */
    @Test
    public void testFindCommentListPageByParentid(){
        Page<Comment> pageResponse = commentService.findCommentListPageByParentid("3", 1, 2);
        System.out.println("----total comment："+pageResponse.getTotalElements());
        System.out.println("----current page："+pageResponse.getContent());
    }

    /**
     * like count+1
     */
    @Test
    public void testUpdateCommentLikenum(){
        // find the comment and increase like
        commentService.updateCommentLikenum("3");
    }
}
