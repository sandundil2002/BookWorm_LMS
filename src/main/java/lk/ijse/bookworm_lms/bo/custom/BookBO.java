package lk.ijse.bookworm_lms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.SuperBO;
import lk.ijse.bookworm_lms.dto.BookDTO;
import lk.ijse.bookworm_lms.entity.Book;

public interface BookBO  extends SuperBO {
    boolean saveBook(BookDTO dto) throws Exception;

    boolean updateBook(String id,BookDTO dto) throws Exception;

    boolean deleteBook(String id) throws Exception;

    BookDTO searchBook(String id) throws Exception;

    ObservableList<BookDTO> getAllBooks(String branch) throws Exception;

    ObservableList<BookDTO> loadAllBooks() throws Exception;

    ObservableList<BookDTO> SearchBookName(String name) throws Exception;

    boolean updateStatus(int id,String status) throws Exception;

}
