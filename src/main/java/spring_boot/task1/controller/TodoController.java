package spring_boot.task1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring_boot.task1.model.entity.Todo;
import spring_boot.task1.repository.TodoRepository;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String todos(Model model) {
        model.addAttribute("listTodo", todoRepository.findAll());
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    // Thêm mới
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("todo") Todo todo,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listTodo", todoRepository.findAll());
            return "todo";
        }

        todoRepository.save(todo);
        return "redirect:/todos/";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos/";
    }
}
