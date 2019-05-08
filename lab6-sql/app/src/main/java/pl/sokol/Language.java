package pl.sokol;

public class Language {
    private String name;
    private String description;

    public Language(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Language[] languages = {
            new Language("Java","Java nie jest taka zla do pewnego momentu"),
            new Language("Python","Python jest calkiem przyjemny")
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
