import java.sql.*;

public interface PTABC {

    void show() throws SQLException;
    void insert() throws SQLException;
    void update() throws SQLException;
    void delete();
    void search() throws SQLException;

}
