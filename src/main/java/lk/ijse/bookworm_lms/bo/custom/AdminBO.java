package lk.ijse.bookworm_lms.bo.custom;

import lk.ijse.bookworm_lms.bo.CrudBO;
import lk.ijse.bookworm_lms.dto.AdminDTO;
import lk.ijse.bookworm_lms.entity.Admin;

public interface AdminBO extends CrudBO<AdminDTO> {

    Admin searchAdmin(String name, String password);

}
