package lk.ijse.dao;



public interface CrudDao <T> extends SuperDao{
    public boolean save(T t);
    public boolean update(T t);
    public boolean delete(int t);
    public T find(String id);

}
