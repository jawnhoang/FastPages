package edu.sjsu.project.books;

import edu.sjsu.project.department.Department;
import edu.sjsu.project.department.DepartmentRepository;
import edu.sjsu.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    DepartmentRepository departmentRepo;

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> listBooks = bookRepo.findAll();
        model.addAttribute("listBooks", listBooks);
        return "books";

    }

    @GetMapping("/books/new")
    public String showBookNewForm(Model model){
        List<Department> listDept = departmentRepo.findAll();
        model.addAttribute("book", new Book());
        model.addAttribute("listDept", listDept);

        return "book_form";
    }

    @PostMapping("/books/save")
    public String saveBook(Book book){
        bookRepo.save(book);
        return "redirect:/books";
    }
}
