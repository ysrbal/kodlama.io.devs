package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class inMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages;

    public inMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "C#"));
        languages.add(new Language(2, "Java"));
        languages.add(new Language(3, "Python"));
        languages.add(new Language(4, "Javascript"));
        languages.add(new Language(5, "Kotlin"));
    }

    @Override
    public void add(Language language) {
        languages.add(language);
        System.out.println("Added new language : " + language.getName());
    }

    @Override
    public void update(Language language, String newName) {
        languages.get(language.getId()).setName(newName);
    }

    @Override
    public void remove(Language language) {
        languages.remove(language);
        System.out.println("Language name of removed : " + language.getName());
    }

    @Override
    public Language getByID(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                return language;
            }
        }
        System.out.println("There is no such language.");
        return null;
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }
}
