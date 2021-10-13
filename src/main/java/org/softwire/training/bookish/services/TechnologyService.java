package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService extends DatabaseService {

    public List<Technology> getAllTechnologies() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM technologies")
                        .mapToBean(Technology.class)
                        .list()
        );
    }

    public void addTechnology(Technology technology) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO technologies (name, logoUrl) VALUES (:name, :logoUrl)")
                        .bind("name", technology.getName())
                        .bind("logoUrl", technology.getLogoUrl())
                        .execute()
        );
    }

    public void deleteTechnology(int technologyId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM technologies WHERE id = :id")
                        .bind("id", technologyId)
                        .execute()
        );
    }
}
