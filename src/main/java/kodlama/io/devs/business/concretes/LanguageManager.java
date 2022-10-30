package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    private boolean isName(String languageName) {
        List<Language> languages = this.languageRepository.getAll();
        boolean result = false;
        for (Language language : languages) {
            if (language.getName().equalsIgnoreCase(languageName)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String add(Language language) {
        if (this.isName(language.getName())) {
            return "There is a language with the same name.";
        }
        if (language.getName().isBlank() || language.getName().isEmpty()) {
            return "The name field must not be empty.";
        }
        this.languageRepository.add(language);
        return "Adding name successful.";
    }

    @Override
    public String update(Language language) {
        if (this.isName(language.getName())) {
            return "There is a language with the same name.";
        }
        if (language.getName().isBlank() || language.getName().isEmpty()) {
            return "The name field must not be empty.";
        }
        this.languageRepository.update(language, language.getName());
        return "Name have removed.";
    }

    @Override
    public void remove(Language language) {
        this.languageRepository.remove(language);
    }

    @Override
    public Language getById(int id) {
        return this.languageRepository.getByID(id);
    }

    @Override
    public List<Language> getAll() {
        return this.languageRepository.getAll();
    }
}
