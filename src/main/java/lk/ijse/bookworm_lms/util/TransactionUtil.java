package lk.ijse.bookworm_lms.util;

import org.hibernate.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public abstract class TransactionUtil implements Transaction {

    private final Session session;
    private Transaction transaction;

    public TransactionUtil(Session session) {
        this.session = session;
    }

    @Override
    public TransactionStatus getStatus() {
        return null;
    }

    @Override
    public void setTimeout(int i) {

    }

    @Override
    public int getTimeout() {
        return 0;
    }

    @Override
    public void begin() {
        transaction = session.beginTransaction();
    }

    @Override
    public void commit() {
        transaction.commit();
    }

    @Override
    public void rollback() {
        transaction.rollback();
    }

    @Override
    public void setRollbackOnly() {
        transaction.setRollbackOnly();
    }

    @Override
    public boolean getRollbackOnly() {
        return transaction.getRollbackOnly();
    }

    @Override
    public boolean isActive() {
        return transaction.isActive();
    }
}
