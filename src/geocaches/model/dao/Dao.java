package geocaches.model.dao;

import java.util.Collection;

public interface Dao<T> {
    public T create(T obj);
    public void delete(T obj);
    public Collection<T> findAll();
}
