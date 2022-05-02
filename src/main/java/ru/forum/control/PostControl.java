package ru.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forum.model.Post;
import ru.forum.service.PostService;


@Controller
public class PostControl {

    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public String detailsPost(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.findById(id));
        return "post";
    }

    @GetMapping("/edit/{id}")
    public String editPost(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @GetMapping("/new")
    public String newPost() {
        return "new";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/index";
    }
}
