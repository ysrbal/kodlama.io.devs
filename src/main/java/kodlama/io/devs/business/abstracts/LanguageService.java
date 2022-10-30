package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    String add(Language language);

    String update(Language language);

    void remove(Language language);

    Language getById(int id);

    List<Language> getAll();

}
