package com.feng;


import com.feng.Mapper.BlogMapper;
import com.feng.pojo.Blog;
import com.feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog1 = new Blog();
        blog1.setId(123);
        blog1.setAuthor("feng");
        blog1.setTitle("java真好玩");
        blog1.setViews(999);
        blog1.setCreateTime(new Date());
        mapper.addBlog(blog1);
        Blog blog2 = new Blog();
        blog2.setId(124);
        blog2.setAuthor("feng");
        blog2.setTitle("java真好玩");
        blog2.setViews(999);
        blog2.setCreateTime(new Date());
        mapper.addBlog(blog2);
        Blog blog3 = new Blog();
        blog3.setId(125);
        blog3.setAuthor("feng");
        blog3.setTitle("java真好玩");
        blog3.setViews(9);
        blog3.setCreateTime(new Date());
        mapper.addBlog(blog3);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("title","java真好玩");
        stringObjectHashMap.put("views",99);
//        stringObjectHashMap.put("id",123);
        List<Blog> blogs = mapper.getBlogsByIf(stringObjectHashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("title","java真好玩");
        stringObjectHashMap.put("views",100);
        stringObjectHashMap.put("id",124);
        List<Blog> blogsByChoose = mapper.getBlogsByChoose(stringObjectHashMap);
        for (Blog blog : blogsByChoose) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("title","Mybatis真好玩");
        stringObjectHashMap.put("author","feng");
        stringObjectHashMap.put("views",98);
        stringObjectHashMap.put("id",123);
        mapper.updateBlog(stringObjectHashMap);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);
        integers.add(124);
        stringObjectHashMap.put("ids",integers);
        List<Blog> blogsByForEach = mapper.getBlogsByForEach(stringObjectHashMap);
        for (Blog byForEach : blogsByForEach) {
            System.out.println(byForEach);
        }
        sqlSession.close();
    }
}
