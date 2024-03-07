package lk.ijse.bookworm_lms.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.BookDAO;
import lk.ijse.bookworm_lms.entity.Book;
import lk.ijse.bookworm_lms.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean save(Book addBook) {
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveBranch = saveSession.beginTransaction();
        saveSession.persist(addBook);
        saveBranch.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id){
        return false;
    }

    @Override
    public boolean update(String id, Book dto) {
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = updateSession.beginTransaction();
        Book existingBook = updateSession.get(Book.class, id);
        if (existingBook!= null) {
            existingBook.setBranch(dto.getBranch());
            existingBook.setTitle(dto.getTitle());
            existingBook.setAuthor(dto.getAuthor());
            existingBook.setGenre(dto.getGenre());
            existingBook.setStatus(dto.getStatus());
            updateSession.merge(existingBook);
        } else {
            updateTransaction.commit();
            updateSession.close();
            return false;
        }
        updateTransaction.commit();
        updateSession.close();
        return true;
    }

    @Override
    public Book search(String id) {
        Session searchSession = SessionFactoryConfig.getInstance().getSession();
        Transaction searchTransaction = searchSession.beginTransaction();
        Book getBooks = searchSession.get(Book.class,id);
        searchTransaction.commit();
        searchSession.close();
        return getBooks;
    }

    @Override
    public ObservableList<Book> getAll() {
        return null;
    }
}
