package achieve.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QiniuUtil {

    // AK
    private static String ACCESS_KEY = "BHQUXfiuUObUzapQ_YH6YYKOiiJCA1XlEvsIkyjz";

    //SK
    private static String SECRET_KEY = "PtgbCnXkRl40AGh63r69GHRzm_y1NGSuEx8V50xW";

    // bucket
    private static String bucket = "shops-sit-uploads";

    // key 不能再上面定义 因为key每次都会拼接文件名
//    private static String key = "report-forms/";


    public static String uploadToQiNiuYun(MultipartFile file) throws Exception {

        System.out.println("文件长度: " + file.getSize());
        System.out.println("文件类型: " + file.getContentType());
        System.out.println("文件名称: " + file.getName());
        System.out.println("文件原名: " + file.getOriginalFilename());

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucket);
        Response qresponse;
        try {
            String key = "report-forms/";
            key += file.getOriginalFilename();
            byte[] b = key.getBytes("UTF-8");
            String tranformKey = new String(b, "UTF-8");
            qresponse = uploadManager.put(file.getInputStream(),tranformKey,upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(qresponse.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            String url = "https://o18ajdo78.qnssl.com/"+putRet.key;
//            String gsonString = new Gson().toJson(url);
            return url;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }


    }

}
