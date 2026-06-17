package com.blogs.SpringBlogProject.Repo;

import com.blogs.SpringBlogProject.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
