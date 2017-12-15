package nicetry.userdao;

public class Constant {
    public static final String WEATHER_HEAD = "http://api.k780.com/?app=weather.today&weaid=";
    public static final String WEATHER_END = "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
    public static final String LOCATION_HEAD = "http://api.k780.com/?app=phone.get&phone=";
    public static final String LOCATION_END = "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
    public static final String SITE_START = "http://192.168.20.194";
    public static final String DATABASE_TEN = SITE_START+":8080/day16/ten";
    public static final String DATABASE_FIRST = SITE_START+":8080/day16/first";
    public static final String DATABASE_UP = SITE_START+":8080/day16/insert?username=";

}
