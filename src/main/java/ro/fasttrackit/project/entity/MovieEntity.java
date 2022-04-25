package ro.fasttrackit.project.entity;

import javax.persistence.*;

@Entity
public class MovieEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    public MovieEntity() {
    }

    public MovieEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
