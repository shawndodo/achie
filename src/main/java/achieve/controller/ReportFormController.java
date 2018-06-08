package achieve.controller;

import achieve.dao.StatisticsDaoImpl;
import achieve.util.ExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/report")
public class ReportFormController extends BaseController {

//    @Resource(name = "reportService")
//    private ReportManager reportService;

    @Autowired
    private static StatisticsDaoImpl statisticsDaoImpl =  new StatisticsDaoImpl();

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
//        List<PageData> list = reportService.bookList(page);
        List<HashMap> list = statisticsDaoImpl.findBasicInfo("");

        String[][] content = new String[5][5];

        //excel标题
        String[] title = {
                "教师姓名", "科研成果数", "专利", "软件著作权", "论文", "参与学术会议",
                "获奖成果", "科研项目", "教学成果数", "著作", "教学奖项", "指导学生项目数",
                "教学论文", "主持教学改革研究项目"
        };

        //excel文件名
        String fileName = "成果统计表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "成果统计表";

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            HashMap hm = list.get(i);
            content[i][0] = hm.get("userName").toString();
            content[i][1] = hm.get("teachCount").toString();
            content[i][2] = hm.get("writingCount").toString();
            content[i][3] = hm.get("teachAwardCount").toString();
            content[i][4] = hm.get("studentProjectCount").toString();
            content[i][5] = hm.get("teachPaperCount").toString();
            content[i][6] = hm.get("teachReformResearchProjectCount").toString();
            content[i][7] = hm.get("researchCount").toString();
            content[i][8] = hm.get("patentCount").toString();
            content[i][9] = hm.get("softwareCopyrightCount").toString();
            content[i][10] = hm.get("paperCount").toString();
            content[i][11] = hm.get("joinAcademicConferenceCount").toString();
            content[i][12] = hm.get("researchAwardCount").toString();
            content[i][13] = hm.get("researchProjectCount").toString();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
