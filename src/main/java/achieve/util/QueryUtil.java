package achieve.util;

import java.util.Map;

public class QueryUtil {

    public static String convertQueryParams(Map<String, Object> params){

        String querySql = "";

        for (Map.Entry<String, Object> m :params.entrySet())  {
            if(m.getValue() == null){continue;}
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



}
