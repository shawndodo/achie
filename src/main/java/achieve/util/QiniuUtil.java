package achieve.util;

import com.qiniu.util.Auth;

public class QiniuUtil {

    // AK
    private static String ACCESS_KEY = "BHQUXfiuUObUzapQ_YH6YYKOiiJCA1XlEvsIkyjz";

    //SK
    private static String SECRET_KEY = "PtgbCnXkRl40AGh63r69GHRzm_y1NGSuEx8V50xW";

    // bucket
    private static String bucket = "shops-sit-uploads";

    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);



}
