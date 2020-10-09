package lk.ijse.dep.web.library.dto;

public class BookDTO {

    String isbn;
    String title;
    String author;
    String edition;

    public BookDTO() {
    }

    public BookDTO(String isbn, String title, String author, String edition) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
