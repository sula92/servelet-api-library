package lk.ijse.dep.web.library.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Return {

    String borrowId;
    Date returnedDate;



}
