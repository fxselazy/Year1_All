package lib.model;

import java.util.ArrayList;

public interface LibraryDao<dbd> {

    void insert(dbd obj);

    void delete(dbd obj);

    void update(dbd obj);

    dbd findById(String id);

    ArrayList<dbd> getAll();
    
    void delete2(int id);
}
