package edu.sjsu.project.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @GetMapping("/departments")
    public String listDepartments(Model model){
        List<Department> listDept = repo.findAll();
        model.addAttribute("listDept", listDept);

        return "departments";
    }

    @GetMapping("/departments/new")
    public String newDepartmentForm(Model model){
        model.addAttribute("department", new Department());

        return "department_form";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(Department department){
        repo.save(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model){
        repo.deleteById(id);

        return "redirect:/departments";
    }

}
