package edu.sjsu.project.books;

import edu.sjsu.project.department.Department;
import edu.sjsu.project.department.DepartmentRepository;
import edu.sjsu.project.user.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String saveBook(Book book, HttpServletRequest request){
        String[] id = request.getParameterValues("detailID");
        String[] firstName = request.getParameterValues("firstName");
        String[] lastName = request.getParameterValues("lastName");

        for(int i =0; i < firstName.length;i++){
            if(id != null && id.length > 0){
                book.setDetails(Integer.valueOf(id[i]), firstName[i], lastName[i]);
            }else {
                book.addAuth(firstName[i], lastName[i]);
            }
        }


        bookRepo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable("id") Integer id, Model model){
        Book book = bookRepo.findById(id).get();
        model.addAttribute("book", book);


        List<Department> listDept = departmentRepo.findAll();
        model.addAttribute("listDept", listDept);

        return "book_form";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model){
        bookRepo.deleteById(id);

        return "redirect:/books";
    }

}
