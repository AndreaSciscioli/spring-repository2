package co.develhope.springrepositories2.controller;

import co.develhope.springrepositories2.entities.ProgrammingLanguage;
import co.develhope.springrepositories2.repositories.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BasicController {
    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @PostMapping("/addLanguage")
    public ProgrammingLanguage language(@RequestBody ProgrammingLanguage programmingLanguage) {
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @GetMapping("/getAllLanguages")
    public List<ProgrammingLanguage> languages() {
        return programmingLanguageRepository.findAll();
    }

    @PutMapping("/updateALanguage/{id}")
    public void languageUpdate(@PathVariable Long id, @RequestBody ProgrammingLanguage programmingLanguage) {
        if (programmingLanguageRepository.existsById(id)) {
            programmingLanguage.setId(id);
            programmingLanguageRepository.save(programmingLanguage);
        }
    }
}