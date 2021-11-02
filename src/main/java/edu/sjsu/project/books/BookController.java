package edu.sjsu.project.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> listBooks = bookRepo.findAll();
        model.addAttribute("listBooks", listBooks);
        return "books";

    }
}
