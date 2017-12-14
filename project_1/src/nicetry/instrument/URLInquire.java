package nicetry.instrument;

import net.sf.json.JSONObject;
import nicetry.classclass.Location;
import nicetry.classclass.Weather;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLInquire <T>{
    public void getInquire(Class<T> tClass , String string) throws IOException, IllegalAccessException, InstantiationException {
        URL u = null;
        if (tClass.newInstance() instanceof Weather){
              u=new URL("http://api.k780.com/?app=weather.today&weaid="+ string +
                "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        }else if (tClass.newInstance() instanceof Location){
            u = new URL("http://api.k780.com/?app=phone.get&phone=" +
                    string +
                    "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        }

        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
//        System.out.println(new String(b,"utf-8"));
        String str = new String(b,"utf-8");
        JSONObject joss = JSONObject.fromObject(str);
        Object o = JSONObject.toBean(joss, tClass);
        if (tClass.newInstance() instanceof Weather) {
            Weather weather = (Weather) o;
//        System.out.println(weather.getSuccess());
            Weather.ResultBean resultBean = weather.getResult();
            //System.out.println(resultBean.getCityid());
            System.out.println("城市 : " + resultBean.getCitynm());
            System.out.println("天气 : " + resultBean.getWeather());
            System.out.println("当前温度 : " + resultBean.getTemperature_curr());
        }else if (tClass.newInstance() instanceof Location){
            Location location = (Location) o;
            Location.ResultBean resultBean = location.getResult();
            System.out.println("手机号 : " + resultBean.getPhone());
            System.out.println("归属地 : " + resultBean.getStyle_simcall());
        }
    }
}
