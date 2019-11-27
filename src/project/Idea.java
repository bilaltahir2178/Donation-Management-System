package project;

public class Idea extends Project {

    private String description;
    
    Idea(int id, String name, String description) {
        super(id, name);
        this.description=description;
    }
}
