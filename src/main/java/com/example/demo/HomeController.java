package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class HomeController {
    HashMap<Integer, Post> allPosts = new HashMap<Integer, Post>();
    Post p = new Post();

    @GetMapping("/")
    public String home(Model model){
        HashMap<Integer, Post> p = allPosts;
        model.addAttribute("allPosts", allPosts);
        return "allPosts";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("submit", "Add Wish!");
        return "addPost";
    }

    @PostMapping("/processPost")
    public String processTask(@ModelAttribute Post post, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("submit", "Add Wish!");
            return "addPost";
        }

        int r = post.getPostId();
        Boolean flag = allPosts.containsKey(post.getPostId());

        allPosts.put(post.getPostId(), post);


        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public String updatePost(@PathVariable int id, Model model){
        Post toBeUpdatedPost;
        if (allPosts.containsKey(id)) {
            toBeUpdatedPost = allPosts.get(id);
            allPosts.remove(id);
        } else {
            toBeUpdatedPost = new Post();
        }

        model.addAttribute("post", toBeUpdatedPost);
        model.addAttribute("submit", "Update Wish!");
        return "addPost";
    }
    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable int id){
        if (allPosts.containsKey(id)) {
           allPosts.remove(id);
        }
        return "redirect:/";
    }

    @GetMapping("/viewDetails/{id}")
    public String viewPostDetails(@PathVariable int id, Model model) {
        Post post = allPosts.get(id);

        model.addAttribute("post", post);
        return "viewDetails";
    }


}
