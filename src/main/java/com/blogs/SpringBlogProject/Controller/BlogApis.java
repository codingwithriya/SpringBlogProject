package com.blogs.SpringBlogProject.Controller;

import com.blogs.SpringBlogProject.Model.Blog;
import com.blogs.SpringBlogProject.Repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogApis {
    @Autowired
    BlogRepo b1;

    @GetMapping("/")
    public String getAllBlogs(Model model){

        List<Blog> blogs = b1.findAll();
    //    Debugging purpose
       System.out.println("================================");
       System.out.println("Blogs found: " + blogs.size());
       System.out.println(blogs);
       System.out.println("================================");

        model.addAttribute("blogs", blogs);

        return "index";
    }

    @GetMapping("/create")
    public String createblog(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);

        return "create-blog";
    }

    @PostMapping("/save")


    public String saveBlog(@ModelAttribute("blog") Blog blog){
        b1.save(blog);
        return "redirect:/";
        
    }

    @GetMapping("/edit/{id}")
    public String editBlog(Model model,@PathVariable int id){
        Blog b = b1.findById(id).get();
        model.addAttribute("blog",b);
        return "/edit-blog";
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(Model model,@PathVariable int id){
        b1.deleteById(id);
        return "redirect:/";
    }
}
