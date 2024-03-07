package lk.ijse.bookworm_lms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.custom.BookBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.BookDAO;
import lk.ijse.bookworm_lms.dto.BookDTO;

public class BookBOImpl implements BookBO {
    private final BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public boolean saveBook(BookDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateBook(String id, BookDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteBook(String id) throws Exception {
        return false;
    }

    @Override
    public BookDTO searchBook(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<BookDTO> getAllBooks() throws Exception {
        return null;
    }
}
