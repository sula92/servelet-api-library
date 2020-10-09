package lk.ijse.dep.web.library.business.custom.impl;

import lk.ijse.dep.web.library.business.custom.BookBO;
import lk.ijse.dep.web.library.dto.BookDTO;
import lk.ijse.dep.web.library.entity.Book;
import lk.ijse.dep.web.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class BookBOImpl implements BookBO {

    @Autowired
    private BookRepository BookRepository;

    @Transactional(readOnly = true)
    public List<BookDTO> getAllBooks() throws Exception {
        List<Book> allBooks = BookRepository.findAll();

        List<BookDTO> Books = new ArrayList<>();
        for (Book Book : allBooks) {
            Books.add(new BookDTO(Book.getId(), Book.getName(), Book.getAuthor(),Book.getEdition()));
        }
        return Books;
    }

    @Override
    public BookDTO getBook(String id) throws Exception {
        Book b =  BookRepository.findById(id).get();
        return new BookDTO(b.getId(),b.getName(),b.getAuthor(),b.getEdition());
    }

    @Override
    public void saveBook(String isbn, String title, String author, String edition) throws Exception {
        BookRepository.save(new Book(isbn, title, author,edition));
    }

    @Override
    public void deleteBook(String BookId) throws Exception {
        BookRepository.deleteById(BookId);
    }

    @Override
    public void updateBook(String isbn, String title, String author, String edition) throws Exception {
        BookRepository.save(new Book(isbn, title, author,edition));
    }

    @Transactional(readOnly = true)
    @Override
    public String getNewBookId() throws Exception {
        String lastBookId = BookRepository.getFirstLastBookIdByOrderByIdDesc().getId();

        if (lastBookId == null) {
            return "B001";
        } else {
            int maxId = Integer.parseInt(lastBookId.replace("B", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "B00" + maxId;
            } else if (maxId < 100) {
                id = "B0" + maxId;
            } else {
                id = "B" + maxId;
            }
            return id;
        }
    }



}
