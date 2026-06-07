package com.kosehalil.controller;
import com.kosehalil.model.News;
import com.kosehalil.model.User;
import com.kosehalil.repository.ContactMessageRepository;
import com.kosehalil.repository.NewsRepository;
import com.kosehalil.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class AdminController {

    private final NewsRepository newsRepository;

    private final ContactMessageRepository contactMessageRepository;

    private final UserRepository userRepository;

    AdminController(UserRepository userRepository, ContactMessageRepository contactMessageRepository, NewsRepository newsRepository) {
        this.userRepository = userRepository;
        this.contactMessageRepository = contactMessageRepository;
        this.newsRepository = newsRepository;
    }
	
	  @GetMapping("/adminControlPanel")
	    public String adminControlPanel() {
	        return "adminControlPanel";
	    }
	  
	  @GetMapping("/admin/messages")
	    public String messages(Model model) {

	        model.addAttribute("messages", contactMessageRepository.findAll());

	        return "admin/messages";
	    }
	  
	  @GetMapping("/admin/messages/delete/{id}")
	  public String deleteMessage(@PathVariable Long id) {

	      contactMessageRepository.deleteById(id);

	      return "redirect:/admin/messages";
	  }

	    @GetMapping("/admin/users")
	    public String users(Model model) {

	        model.addAttribute("users", userRepository.findAll());

	        return "admin/users";
	    }
	    
	    @GetMapping("/admin/news")
	    public String news(Model model) {

	        System.out.println(newsRepository.findAll());
	        model.addAttribute("newsList", newsRepository.findAll());

	        return "admin/news";
	    }
	    
	    @PostMapping("/admin/news/save")
	    public String saveNews(News news) {

	        System.out.println("TITLE: " + news.getTitle());
	        System.out.println("CONTENT: " + news.getContent());
	        System.out.println("IMAGE: " + news.getImageUrl());

	        newsRepository.save(news);

	        return "redirect:/admin/news";
	    }
	    
	    @GetMapping("/admin/news/delete/{id}")
	    public String deleteNews(@PathVariable Long id) {

	        newsRepository.deleteById(id);

	        return "redirect:/admin/news";
	    }
	    
	    @GetMapping("/admin/users/create")
	    public String createUserForm(Model model) {

	        model.addAttribute("user", new User());

	        return "admin/userCreate";
	    }

	    @PostMapping("/admin/users/save")
	    public String saveUser(User user) {

	        userRepository.save(user);

	        return "redirect:/admin/users";
	    }

	    @GetMapping("/admin/users/edit/{id}")
	    public String editUserForm(@PathVariable Long id, Model model) {

	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

	        model.addAttribute("user", user);

	        return "admin/userEdit";
	    }

	    @PostMapping("/admin/users/update")
	    public String updateUser(User user) {

	        userRepository.save(user);

	        return "redirect:/admin/users";
	    }

	    @GetMapping("/admin/users/delete/{id}")
	    public String deleteUser(@PathVariable Long id) {

	        userRepository.deleteById(id);

	        return "redirect:/admin/users";
	    }

}
