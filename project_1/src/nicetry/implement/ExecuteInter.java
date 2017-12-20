package nicetry.implement;

import java.sql.Connection;
import java.sql.SQLException;

public interface ExecuteInter {
    void excuter(Connection conn) throws SQLException;
}
