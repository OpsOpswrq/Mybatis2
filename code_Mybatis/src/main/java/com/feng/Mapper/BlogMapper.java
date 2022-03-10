package com.feng.Mapper;

import com.feng.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    void addBlog(Blog blog);
    List<Blog> getBlogsByIf(Map map);
    List<Blog> getBlogsByChoose(Map map);
    void updateBlog(Map map);
    List<Blog> getBlogsByForEach(Map map);
}
