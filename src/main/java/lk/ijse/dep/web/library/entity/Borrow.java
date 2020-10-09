package lk.ijse.dep.web.library.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    String borrowId;
    Date borrowedDate;
    String bookIs;
    String cusId;


}
