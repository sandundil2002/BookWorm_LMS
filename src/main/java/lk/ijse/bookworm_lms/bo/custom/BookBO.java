package lk.ijse.bookworm_lms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.SuperBO;
import lk.ijse.bookworm_lms.dto.BookDTO;

public interface BookBO  extends SuperBO {
    boolean saveBook(BookDTO dto) throws Exception;

    boolean updateBook(String id,BookDTO dto) throws Exception;

    boolean deleteBook(String id) throws Exception;

    BookDTO searchBook(String id) throws Exception;

    ObservableList<BookDTO> getAllBooks() throws Exception;

}
