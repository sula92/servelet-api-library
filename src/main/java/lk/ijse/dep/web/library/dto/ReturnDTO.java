package lk.ijse.dep.web.library.dto;

import java.sql.Date;

public class ReturnDTO {

    String borrowId;
    Date returnedDate;

    public ReturnDTO() {
    }

    public ReturnDTO(String borrowId, Date returnedDate) {
        this.borrowId = borrowId;
        this.returnedDate = returnedDate;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Override
    public String toString() {
        return "ReturnDTO{" +
                "borrowId='" + borrowId + '\'' +
                ", returnedDate=" + returnedDate +
                '}';
    }
}
