package lk.ijse.bookworm_lms.bo;

import java.util.List;

public interface CrudBO<T> extends SuperBO{
    boolean save(T dto) throws Exception;

    boolean update(T dto) throws Exception;

    boolean delete(String id) throws Exception;

    List<T> getAll() throws Exception;
}