package edu.sjsu.project.author;


import edu.sjsu.project.department.Department;
import edu.sjsu.project.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    @GetMapping("/authors")
    public String listAuthors(Model model){
        List<Author> listAuth = authRepo.findAll();

        model.addAttribute("listAuth", listAuth);

        return "authors";
    }


    @GetMapping("/authors/new")
    public String newAuthor(Model model){
        List<Department> listDept = deptRepo.findAll();
        model.addAttribute("listDept", listDept);
        model.addAttribute("author", new Author());

        return "author_form";
    }


    @PostMapping("/authors/save")
    public String saveAuthor(Author author){
        authRepo.save(author);

        return "redirect:/home";
    }

    @GetMapping("/authors/edit/{id}")
    public String editAuth(@PathVariable("id") Integer id, Model model){
        List<Department> listDept = deptRepo.findAll();
        Author author =  authRepo.findById(id).get();
        model.addAttribute("listDept", listDept);
        model.addAttribute("author", author);

        return "brand_form";


    }

    @GetMapping("/authors/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model){
        authRepo.deleteById(id);

        return "redirect:/authors";
    }

}
