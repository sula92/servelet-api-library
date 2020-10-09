package lk.ijse.dep.web.library.repository;

import lk.ijse.dep.web.library.entity.Book;
import lk.ijse.dep.web.library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sql.DataSource;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member,String> {

  // public void setDataSource(DataSource ds);

    Member getFirstLastMemberIdByOrderByIdDesc() throws Exception;
   


}