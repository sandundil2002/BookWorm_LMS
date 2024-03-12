package lk.ijse.bookworm_lms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.dao.CrudDAO;
import lk.ijse.bookworm_lms.entity.Book;

public interface BookDAO extends CrudDAO<Book> {

    ObservableList<Book> getAllBooks(String branch);

    ObservableList<Book> searchBookName(String title);

    boolean updateStatus(int id,String status);
}
