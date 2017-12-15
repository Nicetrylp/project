package nicetry.instrument;

import net.sf.json.JSONObject;
import nicetry.bean.Location;
import nicetry.bean.Weather;
import nicetry.userdao.Constant;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLInquire <T>{
    // 输入要查询的种类,返回对应值的对象
    public T getInquire(Class<T> tClass , String string) throws IOException, IllegalAccessException, InstantiationException {
        URL u = null;
        if (tClass.newInstance() instanceof Weather){
              u=new URL(Constant.WEATHER_HEAD+ string + Constant.WEATHER_END);
        }else if (tClass.newInstance() instanceof Location){
            u = new URL(Constant.LOCATION_HEAD + string + Constant.LOCATION_END);
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
        String str = new String(b,"utf-8");
        JSONObject joss = JSONObject.fromObject(str);
        T t = (T) JSONObject.toBean(joss, tClass);
        return t;
    }

    // 上传下载的一些玩意
    public T upDownLoad(){


        return null;
    }

}
