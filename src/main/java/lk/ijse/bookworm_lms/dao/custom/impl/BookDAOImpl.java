package lk.ijse.bookworm_lms.dao.custom.impl;

import jakarta.persistence.criteria.*;
import javafx.collections.*;
import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.BookDAO;
import lk.ijse.bookworm_lms.entity.Book;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.List;

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
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();
        Book deleteBook = deleteSession.get(Book.class, id);
        if (deleteBook != null){
            deleteSession.remove(deleteBook);
            deleteTransaction.commit();
            deleteSession.close();
            return true;
        } else {
            return false;
        }
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
        /*ObservableList<Book> allBookList = FXCollections.observableArrayList();
        Session loadSession = SessionFactoryConfig.getInstance().getSession();
        CriteriaQuery<Book> criteriaQuery = loadSession.getCriteriaBuilder().createQuery(Book.class);
        criteriaQuery.from(Book.class);
        List<Book> BookList = loadSession.createQuery(criteriaQuery).getResultList();
        allBookList.setAll(BookList);
        loadSession.close();
        return allBookList;*/
        return null;
    }

    @Override
    public ObservableList<Book> getAll(String branch) {
        ObservableList<Book> allBookList = FXCollections.observableArrayList();
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Query<Book> query = session.createQuery("FROM Book WHERE branch = :branch", Book.class);
            query.setParameter("branch", branch);
            allBookList.addAll(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allBookList;
    }
}
