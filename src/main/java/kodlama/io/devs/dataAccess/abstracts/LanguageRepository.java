package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {

    void add(Language language);

    void update(Language language, String newName);

    void remove(Language language);

    Language getByID(int id);

    List<Language> getAll();

}
