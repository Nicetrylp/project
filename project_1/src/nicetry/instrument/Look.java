package nicetry.instrument;

import nicetry.classclass.Location;
import nicetry.classclass.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Look {
    public static void weather(String city) throws IllegalAccessException, IOException, InstantiationException {
        URLInquire<Weather> urli = new URLInquire<>();
        urli.getInquire(Weather.class,city);
    }

    public static void location(String phoneNum) throws IllegalAccessException, IOException, InstantiationException {
        URLInquire<Location> urli = new URLInquire<>();
        urli.getInquire(Location.class,phoneNum);
    }

    public static void ranking() throws IOException {
        URL url = new URL("http://192.168.20.221:8080/day16/ten");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024];
        int len = inputStream.read(buff);
        String str = new String(buff, 0, len,"utf-8");
        System.out.println(str);
    }
}
