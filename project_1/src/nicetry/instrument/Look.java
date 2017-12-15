package nicetry.instrument;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nicetry.bean.Location;
import nicetry.bean.Ranking;
import nicetry.bean.Weather;
import nicetry.userdao.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Look {
    public static void weather(String city) throws IllegalAccessException, IOException, InstantiationException {
        URLInquire<Weather> urli = new URLInquire<>();
        Weather weather = urli.getInquire(Weather.class, city);
        Weather.ResultBean  resultBean = weather.getResult();
        System.out.println("城市 : " + resultBean.getCitynm());
        System.out.println("天气 : " + resultBean.getWeather());
        System.out.println("当前温度 : " + resultBean.getTemperature_curr());
    }

    public static void location(String phoneNum) throws IllegalAccessException, IOException, InstantiationException {
        URLInquire<Location> urli = new URLInquire<>();
        Location location = urli.getInquire(Location.class, phoneNum);
        Location.ResultBean resultBean = location.getResult();
        System.out.println("手机号 : " + resultBean.getPhone());
        System.out.println("归属地 : " + resultBean.getStyle_simcall());
    }

    public static void ranking() throws IOException {
        URL url = new URL(Constant.DATABASE_TEN);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024];
        int len = inputStream.read(buff);
        String str = new String(buff, 0, len,"utf-8");
//        System.out.println(str);
        JSONArray jsonArray = JSONArray.fromObject(str);
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Ranking ranking = (Ranking) JSONObject.toBean(jsonObject, Ranking.class);
            System.out.println("第" + (i+1) + "名: " + ranking.toString());
        }
    }

    public static void first() throws IOException {
        URL url = new URL(Constant.DATABASE_FIRST);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024];
        int len = inputStream.read(buff);
        String str = new String(buff, 0, len);
//        System.out.println(str);
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("User", Ranking.class);
        //xStream.fromXML(str);
        Ranking ranking = (Ranking) xStream.fromXML(str);
       // Object o = xStream.fromXML(str);

        System.out.println("姓名: " + ranking.getNickname() + "\t\t成绩: " + ranking.getScore());
    }

}
