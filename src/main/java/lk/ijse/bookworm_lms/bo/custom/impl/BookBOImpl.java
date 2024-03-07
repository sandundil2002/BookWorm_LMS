package lk.ijse.bookworm_lms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.custom.BookBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.BookDAO;
import lk.ijse.bookworm_lms.dto.BookDTO;
import lk.ijse.bookworm_lms.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    private final BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public boolean saveBook(BookDTO dto) throws Exception {
        return bookDAO.save(new Book(
                dto.getBranch(),
                dto.getAuthor(),
                dto.getTitle(),
                dto.getGenre(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean updateBook(String id, BookDTO dto) throws Exception {
        return bookDAO.update(id, new Book(
                dto.getBranch(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getGenre(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean deleteBook(String id) throws Exception {
        return bookDAO.delete(id);
    }

    @Override
    public BookDTO searchBook(String id) throws Exception {
        Book book = bookDAO.search(id);
        if (book != null){
            return new BookDTO(
                    book.getBranch(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getStatus()
            );
        }
        return null;
    }

    @Override
    public ObservableList<BookDTO> getAllBooks(int branch) throws Exception {
        List<Book> bookList = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : bookList){
            bookDTOS.add(new BookDTO(
                    book.getId(),
                    book.getBranch(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getStatus(),
                    book.getDateTime()
            ));
        }
        return FXCollections.observableArrayList(bookDTOS);
    }
}
