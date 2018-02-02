package com.week2challenge.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.persistence.PostPersist;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    EducationRepository educationRepository;
    ExperienceRepository experienceRepository;
    SkillsRepository skillsRepository;

    @RequestMapping("/")
    public String generateResume(Model model){
        model.addAttribute("usr",userRepository.findAll());
        return "index";
    }
    @RequestMapping("/add")
    public String collectRecords(Model model){
        model.addAttribute("edu",educationRepository.findAll());
        model.addAttribute("exp",experienceRepository.findAll());
        model.addAttribute("skl",skillsRepository.findAll());
        return "add";
    }

    @GetMapping("/add")
    public String userForm(Model model){
        model.addAttribute("user",new User());
        return "resumeform";
    }

    @PostMapping("/process1")
    public String processForm(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "resumeform";
        }
        userRepository.save(user);
        return "redirect:/";
    }
    @GetMapping("/education")
    public String educationForm(Model model){
        model.addAttribute("education",new Education());
        return "education";
    }
    @PostMapping("/process2")
    public String processeduForm(@Valid @ModelAttribute("education") Education education, BindingResult result){
        if(result.hasErrors()){
            return "education";
        }

        educationRepository.save(education);
        return "redirect:/add";
    }

    @GetMapping("/experience")
    public String experienceForm(Model model){
        model.addAttribute("experience",new Experience());
        return "experience";
    }
    @PostMapping("/experience")
    public String processexpForm(@Valid @ModelAttribute("experience") Experience experience, BindingResult result){
        if(result.hasErrors()){
            return "experience";
        }

        experienceRepository.save(experience);
        return "redirect:/add";
    }

    @GetMapping("/skills")
    public String skillsForm(Model model){
        model.addAttribute("skills",new Skills());
        return "skills";
    }
    @PostMapping("/skills")
    public String skillsForm(@Valid @ModelAttribute("skills") Skills skill, BindingResult result){
        if(result.hasErrors()){
            return "skills";
        }

        skillsRepository.save(skill);
        return "redirect:/";
    }


}
