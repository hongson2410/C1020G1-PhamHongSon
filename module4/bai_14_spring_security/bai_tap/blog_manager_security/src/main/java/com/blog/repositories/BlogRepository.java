package com.blog.repositories;

import com.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByOrderByDateUpdateDesc(Pageable pageable);

    List<Blog> findByBlogNameContaining(String blogName);

    List<Blog> findByCategoryId(int categoryId);
}
