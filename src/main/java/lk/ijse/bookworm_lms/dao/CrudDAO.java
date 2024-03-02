package lk.ijse.bookworm_lms.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T t) throws Exception;

    boolean delete(T t) throws Exception;

    boolean update(T t) throws Exception;

    List<T> getAll() throws Exception;
}
