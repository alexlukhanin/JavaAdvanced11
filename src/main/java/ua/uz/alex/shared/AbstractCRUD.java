package ua.uz.alex.shared;

import java.util.List;

public interface AbstractCRUD<T>{
    T create(T t);
    T readById(Integer id);
    T readByString(String string);
    T update(T t);
    void delete(Integer id);
    List<T> readAll();
}
