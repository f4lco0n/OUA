package pl.sokol;

public class Type {
    private String name;
    private String description;

    public static final Type[] TYPES = {
            new Type("Backend","Deskrypcja na temat backendu"),
            new Type("Frontend","Deskrypcja na temat frontu")
    };

    public Type(String name, String description){
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
