package lk.ijse.bookworm_lms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.SuperBO;
import lk.ijse.bookworm_lms.dto.BranchDTO;
import lk.ijse.bookworm_lms.entity.Branch;

public interface BranchBO extends SuperBO {

    boolean saveBranch(BranchDTO dto) throws Exception;

    boolean updateBranch(String id,BranchDTO dto) throws Exception;

    boolean deleteBranch(String id) throws Exception;

    BranchDTO searchBranch(String id) throws Exception;

    ObservableList<BranchDTO> getAllBranches() throws Exception;

}
