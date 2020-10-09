package lk.ijse.dep.web.library.dto;

import java.sql.Date;

public class BorrowDTO {

    String borrowId;
    Date borrowedDate;
    String bookIs;
    String cusId;

    public BorrowDTO() {
    }

    public BorrowDTO(String borrowId, Date borrowedDate, String bookIs, String cusId) {
        this.borrowId = borrowId;
        this.borrowedDate = borrowedDate;
        this.bookIs = bookIs;
        this.cusId = cusId;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getBookIs() {
        return bookIs;
    }

    public void setBookIs(String bookIs) {
        this.bookIs = bookIs;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "BorrowDTO{" +
                "borrowId='" + borrowId + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", bookIs='" + bookIs + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
