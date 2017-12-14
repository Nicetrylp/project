package nicetry.main;

import nicetry.classclass.User;
import nicetry.exception.RegisterException;
import nicetry.instrument.Look;
import nicetry.userdao.UserOperate;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

public class T {
    @Test
    public void t1() throws IOException {
        Look.ranking();
    }
    @Test
    public void t2() throws DocumentException, RegisterException, IOException {
        UserOperate.register(new User("15327289695","asdQWE123","Nicetry"));
    }
}
