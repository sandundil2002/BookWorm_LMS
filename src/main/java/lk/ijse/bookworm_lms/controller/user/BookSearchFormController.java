package lk.ijse.bookworm_lms.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.BookBO;
import lk.ijse.bookworm_lms.dto.BookDTO;

public class BookSearchFormController {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableColumn<?, ?> colDateTime;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<BookDTO> tblBooks;

    private final BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize(){
        loadAllBooks();
        setCellValueFactory();
    }

    @FXML
    private void btnSearchOnAction() {
        String title = txtSearch.getText();
        if (title != null) {
            try {
                tblBooks.setItems(bookBO.SearchBookName(title));
                setCellValueFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Please Enter Book Name").show();
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
    }

    private void loadAllBooks(){
        try {
            tblBooks.setItems(bookBO.loadAllBooks());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
