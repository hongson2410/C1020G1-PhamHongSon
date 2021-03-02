package com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blogName;
    private String titleBlog;
    private String typeBlog;
    private String blogWriter;
    private String content;

    public Blog() {
    }

    public Blog(String blogName, String titleBlog, String typeBlog, String blogWriter, String content) {
        this.blogName = blogName;
        this.titleBlog = titleBlog;
        this.typeBlog= typeBlog;
        this.blogWriter = blogWriter;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }

    public String getBlogWriter() {
        return blogWriter;
    }

    public void setBlogWriter(String blogWriter) {
        this.blogWriter = blogWriter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
