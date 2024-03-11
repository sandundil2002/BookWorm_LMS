package lk.ijse.bookworm_lms.dao;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.entity.Admin;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T dto) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(String id , T dto) throws Exception;

    T search(String id) throws Exception;

    ObservableList<T> loadAll() throws Exception;
}
