package achieve.controller;

import achieve.editor.IntegerEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
//        binder.registerCustomEditor(int.class, new CustomNumberEditor(int.class, true));
        binder.registerCustomEditor(int.class, new IntegerEditor());
//        binder.registerCustomEditor(long.class, new CustomNumberEditor(long.class, true));
//        binder.registerCustomEditor(long.class, new LongEditor());
//        binder.registerCustomEditor(double.class, new DoubleEditor());
//        binder.registerCustomEditor(float.class, new FloatEditor());
    }

    @InitBinder
    public void InitBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) {
        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }

}
