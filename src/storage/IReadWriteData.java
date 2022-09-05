package storage;

import java.util.List;

public interface IReadWriteData<T> {
    List<T> readData();
    void writeData(List<T> tList);
}
