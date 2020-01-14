package pl.coderslab;

import java.util.List;

public interface BookService<T, S extends Number> {

    public List<T> getAllElements();

    public T getOneElement(S s);

    public T addElement(T t);

    public T updateElement(T t);

    public T deleteElemenet(S s);
}
