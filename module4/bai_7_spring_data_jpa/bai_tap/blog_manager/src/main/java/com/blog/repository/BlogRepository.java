package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByOrderByDateUpdateDesc(Pageable pageable);
    Page<Blog> findByBlogNameContaining(Pageable pageable, String blogName);
    Page<Blog> findByCategoryId(Pageable pageable, int categoryId);
}
