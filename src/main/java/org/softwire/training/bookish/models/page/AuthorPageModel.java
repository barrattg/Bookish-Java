package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Author;

import java.util.List;

public class AuthorPageModel {
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
