package lk.ijse.dep.web.library.repository;

import lk.ijse.dep.web.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,String > {

    Book getFirstLastBookIdByOrderByIdDesc() throws Exception;


}
