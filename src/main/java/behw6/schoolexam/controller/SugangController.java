package behw6.schoolexam.controller;

import behw6.schoolexam.entity.Sugang;
import behw6.schoolexam.service.SugangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SugangController {

    @Autowired
    private SugangService sugangService;

    @PostMapping("/sugang/create/{id}")
    public String create(@PathVariable("id") int id, @Valid Sugang sugang, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            sugangService.create(id, sugang);
        }
        return "redirect:/readdetail/" + id;
    }
}
