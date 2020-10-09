package lk.ijse.dep.web.library.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Fee {


    String borrowId;
    int amount;


}
