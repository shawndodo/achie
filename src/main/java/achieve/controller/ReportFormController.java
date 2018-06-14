package achieve.controller;

import achieve.dao.*;
import achieve.pojo.JoinAcademicConference;
import achieve.pojo.Paper;
import achieve.pojo.Patent;
import achieve.pojo.ResearchAward;
import achieve.util.ExportUtil;
import achieve.util.QueryUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    private static JoinAcademicConferenceDaoImpl joinAcademicConferenceDaoImpl = new JoinAcademicConferenceDaoImpl();
    @Autowired
    private static PaperDaoImpl paperDaoImpl = new PaperDaoImpl();
    @Autowired
    private static PatentDaoImpl patentDaoImpl = new PatentDaoImpl();
    @Autowired
    private static ResearchAwardDaoImpl researchAwardDaoImpl = new ResearchAwardDaoImpl();

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public String export(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String querySql = QueryUtil.generateQuerySql(request);

        System.out.println("querySql====" + querySql);

        String pageName = request.getParameter("pageName");

//        参数初始化
//        List<HashMap> list;
        String[][] content = {};
        String[] title = {};
        String fileName = null;
        String sheetName = null;
        HSSFWorkbook wb = null;

        // 统计页面导出
        if("statistics_export".equals(pageName)){
            //获取数据
//        List<PageData> list = reportService.bookList(page);
            List<HashMap> list = statisticsDaoImpl.findBasicInfo(querySql);

            content = new String[list.size()][];

            //excel标题
            title = new String[]{
                    "教师姓名", "科研成果数", "专利", "软件著作权", "论文", "参与学术会议",
                    "获奖成果", "科研项目", "教学成果数", "著作", "教学奖项", "指导学生项目数",
                    "教学论文", "主持教学改革研究项目"
            };

            //excel文件名
            fileName = "成果统计表" + System.currentTimeMillis() + ".xls";

            //sheet名
            sheetName = "成果统计表";

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
            wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);

        }else if("join_academic_conference_export".equals(pageName)){
            List<JoinAcademicConference> list = joinAcademicConferenceDaoImpl.adminFindAll(querySql);

            content = new String[list.size()][];

            //excel标题
            title = new String[]{
                    "教师姓名", "学术会议名称", "会议地点", "会议等级", "提交论文名称", "是否特邀报告",
                    "所属学科", "备注", "提交时间", "修改时间"
            };

            //excel文件名
            fileName = "(科研)参加学术会议统计表" + System.currentTimeMillis() + ".xls";

            //sheet名
            sheetName = "(科研)参加学术会议统计表";

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                JoinAcademicConference jac = list.get(i);
                content[i][0] = jac.getTeacherName();
                content[i][1] = jac.getName();
                content[i][2] = jac.getLocation();
                content[i][3] = jac.getLevel();
                content[i][4] = jac.getPaperName();
                content[i][5] = jac.getIsInviteReport();
                content[i][6] = jac.getSubjectCategory();
                content[i][7] = jac.getRemark();
                content[i][8] = jac.getCreatedAt().toString().substring(0, 19);
                content[i][9] = jac.getUpdatedAt().toString().substring(0, 19);
            }

            //创建HSSFWorkbook
            wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);

        }else if("paper_export".equals(pageName)){
            List<Paper> list = paperDaoImpl.adminFindAll(querySql);

            content = new String[list.size()][];

            //excel标题
            title = new String[]{
                    "教师姓名", "论文名称", "论文类型", "本人排名", "是否独著", "通讯作者",
                    "刊物名称", "收录检索(刊物级别)", "发表时间", "备注", "提交时间", "修改时间"
            };

            //excel文件名
            fileName = "(科研)论文统计表" + System.currentTimeMillis() + ".xls";

            //sheet名
            sheetName = "(科研)论文统计表";

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                Paper paper = list.get(i);
                content[i][0] = paper.getTeacherName();
                content[i][1] = paper.getPaperName();
                content[i][2] = paper.getPaperType();
                content[i][3] = paper.getSelfRank() + "";
                content[i][4] = paper.getIsAlone();
                content[i][5] = paper.getMessageAuthor();
                content[i][6] = paper.getPeriodicalName();
                content[i][7] = paper.getInclusionSearch();
                content[i][8] = paper.getPublishTime().toString();

                content[i][9] = paper.getRemark();
                content[i][10] = paper.getCreatedAt().toString().substring(0, 19);
                content[i][11] = paper.getUpdatedAt().toString().substring(0, 19);
            }

            //创建HSSFWorkbook
            wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);
        }else if("patent_export".equals(pageName)){
            List<Patent> list = patentDaoImpl.adminFindAll(querySql);

            content = new String[list.size()][];

            //excel标题
            title = new String[]{
                    "教师姓名", "专利名称", "专利类型", "专利状态", "专利编号", "获得时间",
                    "申请编号", "申请时间", "本人排名", "备注", "提交时间", "修改时间"
            };

            //excel文件名
            fileName = "(科研)专利统计表" + System.currentTimeMillis() + ".xls";

            //sheet名
            sheetName = "(科研)专利统计表";

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                Patent patent = list.get(i);
                content[i][0] = patent.getTeacherName();
                content[i][1] = patent.getPatentName();
                content[i][2] = patent.getPatentType();
                content[i][3] = patent.getPatentStatus();
                content[i][4] = patent.getPatentCode();
                content[i][5] = patent.getGetPatentDate().toString();
                content[i][6] = patent.getApplyCode();
                content[i][7] = patent.getApplyDate().toString();
                content[i][8] = patent.getSelfRank() + "";

                content[i][9] = patent.getRemark();
                content[i][10] = patent.getCreatedAt().toString().substring(0, 19);
                content[i][11] = patent.getUpdatedAt().toString().substring(0, 19);
            }

            //创建HSSFWorkbook
            wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);
        }else if("research_award_export".equals(pageName)){
            List<ResearchAward> list = researchAwardDaoImpl.adminFindAll(querySql);

            content = new String[list.size()][];

            //excel标题
            title = new String[]{
                    "教师姓名", "成果名称", "发表刊物", "出版单位", "成果发表时间", "获奖名称",
                    "获奖类别", "颁奖部门", "奖励时间", "证书号", "单位排名",
                    "本人排名", "学科门类", "提交时间", "修改时间"
            };

            //excel文件名
            fileName = "(科研)获奖成果统计表" + System.currentTimeMillis() + ".xls";

            //sheet名
            sheetName = "(科研)获奖成果统计表";

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                ResearchAward researchAward = list.get(i);
                content[i][0] = researchAward.getTeacherName();
                content[i][1] = researchAward.getAwardName();
                content[i][2] = researchAward.getPublishJournal();
                content[i][3] = researchAward.getPublisher();
                content[i][4] = researchAward.getPublishDate().toString();
                content[i][5] = researchAward.getAwardWinningName();
                content[i][6] = researchAward.getAwardType();
                content[i][7] = researchAward.getAwardDepartment();
                content[i][8] = researchAward.getAwardDate().toString();
                content[i][9] = researchAward.getAwardNumber();
                content[i][10] = researchAward.getUnitRank() + "";
                content[i][11] = researchAward.getSelfRank() + "";

                content[i][12] = researchAward.getSubjectCategory();
                content[i][13] = researchAward.getCreatedAt().toString().substring(0, 19);
                content[i][14] = researchAward.getUpdatedAt().toString().substring(0, 19);
            }

            //创建HSSFWorkbook
            wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);
        }

        if(title.length != 0){


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
        }else{
            return "前端参数错误";
        }
        return "";
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
