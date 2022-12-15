package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as line brief description).
 */
public class MyDatabase implements IFancyDatabase {
    @Override
    public void connect() {

    }

    @Override
    public <T> void persist(T aT) {

    }

    @Override
    public <T> List<T> queryAll() {
        return Collections.emptyList();
    }

    @Override
    public void close() {

    }
}
