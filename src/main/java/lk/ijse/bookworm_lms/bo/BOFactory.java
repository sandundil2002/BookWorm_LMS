package lk.ijse.bookworm_lms.bo;

import lk.ijse.bookworm_lms.bo.custom.impl.AdminBOImpl;
import lk.ijse.bookworm_lms.bo.custom.impl.BranchBOImpl;
import lk.ijse.bookworm_lms.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null)? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,ADMIN,BRANCH
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case USER:
                return new UserBOImpl();
            case ADMIN:
                return new AdminBOImpl();
            case BRANCH:
                return new BranchBOImpl();
            default:
                return null;
        }
    }
}
