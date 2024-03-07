package lk.ijse.bookworm_lms.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.dao.custom.BookDAO;
import lk.ijse.bookworm_lms.entity.Book;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean save(Book dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id, Book dto) throws Exception {
        return false;
    }

    @Override
    public Book search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<Book> getAll() throws Exception {
        return null;
    }
}
