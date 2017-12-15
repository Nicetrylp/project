package nicetry.main;

import nicetry.bean.User;
import nicetry.exception.RegisterException;
import nicetry.instrument.Look;
import nicetry.userdao.Constant;
import nicetry.userdao.UserOperate;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class T {
    @Test
    public void t1() throws IOException {
        Look.ranking();
    }
    @Test
    public void t2() throws DocumentException, RegisterException, IOException {
        UserOperate.register(new User("15327289695","asdQWE123","Nicetry"));
    }

    @Test
    public void t3() throws IOException {
            URL url = new URL(Constant.DATABASE_UP +
                    "Nicetry" +
                    "&score=" +
                    "2537");
            URLConnection urlConnection = url.openConnection();
            /*
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buff = new byte[1024];
            int len = inputStream.read(buff);
            String string = new String(buff, 0, len,"utf-8");
            System.out.println(string);
            */
    }

    @Test
    public void t4() throws IOException {
        Look.first();
    }
    @Test
    public void t5() throws IllegalAccessException, IOException, InstantiationException {
            Look.location("13333333333");
    }
}
