package lk.ijse.dep.web.library.business.custom;

import lk.ijse.dep.web.library.business.SuperBO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.entity.Book;

import java.util.List;

public interface BookBO extends SuperBO {

    BookDTO getBook(String id) throws Exception;

    List<BookDTO> getAllBooks() throws Exception;

    

    void saveBook(String isbn, String title, String author, String edition) throws Exception;

    void deleteBook(String BookId) throws Exception;

    void updateBook(String isbn, String title, String author, String editionn) throws Exception;

    String getNewBookId() throws Exception;

}
