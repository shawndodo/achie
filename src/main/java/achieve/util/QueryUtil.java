package achieve.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QueryUtil {

    public static String convertQueryParams(Map<String, Object> params){

        String querySql = "";

        for (Map.Entry<String, Object> m :params.entrySet())  {
            System.out.println("value===>" + m.getValue());
            if(m.getValue() == null || m.getValue() == ""){continue;}
            System.out.println("value2===>" + m.getValue());
            String key = m.getKey();
            if(key.contains("like_")){
                String convertKey = key.replaceAll("like_", "");
                querySql += (" AND " + convertKey + " LIKE '%" + m.getValue() + "%' ");
            }else if(key.contains("between_")) {
                String convertKey = key.replaceAll("between_", "");
                String value = String.valueOf(m.getValue());
                String[] valueArray = value.split(" ");
                if(valueArray.length == 2){
                    if(value.indexOf(" ") == 0){
                        querySql += " AND " + convertKey + " <= '" + valueArray[1] + " 23:59:59' ";
                    }else{
                        querySql += (" AND " + convertKey + " between '" + valueArray[0] + " 00:00:00' and '" + valueArray[1] + " 23:59:59' ");
                    }
                }else if(valueArray.length == 1){
                    if(value.indexOf(" ") == value.length() - 1){
                        querySql += " AND " + convertKey + " >= '" + valueArray[0] + " 00:00:00' ";
                    }
                }else{

                }
            }else{
                querySql += (" AND " + m.getKey() + " = '" + m.getValue() + "' ");
            }
        }

        return querySql;
    }

    public static String generateQuerySql(HttpServletRequest request){
//        Map<String, Object> map = new HashMap<String, Object>();

        // 参数Map
        Map properties = request.getParameterMap();

        System.out.println("map====" + properties);

        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object[] valueObj = (Object[]) entry.getValue();
            System.out.println("generate-name1===" + name);
            System.out.println("generate-value1===" + valueObj[0]);
            Object cValue = valueObj[0];
            if(cValue == null || cValue == ""){
                value = null;
            }else if(cValue instanceof String[]){
                String[] values = (String[])cValue;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = cValue.toString();
            }
            System.out.println("generate-name===" + name);
            System.out.println("generate-value===" + cValue);
            returnMap.put(name, value);
        }


//        map.put("like_user.realName", request.getParameter("like_user.realName"));
//        map.put("between_teacher_achie.createdAt", request.getParameter("between_teacher_achie.createdAt"));

        String querySql = QueryUtil.convertQueryParams(returnMap);

        System.out.println("querySql====" + querySql);

        return querySql;
    }



}
