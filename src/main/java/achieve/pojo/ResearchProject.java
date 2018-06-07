package achieve.pojo;

import java.util.Date;

// 科研项目(科研)
public class ResearchProject {

    private int id;
    private String leader;
    private String name;
    private String projectType;
    private String approvalNumber;
    private String researchCategory;
    private int approvalFund;
    private int currentYearInMoney;
    private int currentYearOutMoney;
    private String subjectCategory;
    private String organizationForm;
    private String serveNationalEconomyIndustry;
    private String projectGoal;
    private String projectStatus;
    private String remark;
    private Date createdAt;
    private Date updatedAt;
    private String teacherName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getResearchCategory() {
        return researchCategory;
    }

    public void setResearchCategory(String researchCategory) {
        this.researchCategory = researchCategory;
    }

    public int getApprovalFund() {
        return approvalFund;
    }

    public void setApprovalFund(int approvalFund) {
        this.approvalFund = approvalFund;
    }

    public int getCurrentYearInMoney() {
        return currentYearInMoney;
    }

    public void setCurrentYearInMoney(int currentYearInMoney) {
        this.currentYearInMoney = currentYearInMoney;
    }

    public int getCurrentYearOutMoney() {
        return currentYearOutMoney;
    }

    public void setCurrentYearOutMoney(int currentYearOutMoney) {
        this.currentYearOutMoney = currentYearOutMoney;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public String getServeNationalEconomyIndustry() {
        return serveNationalEconomyIndustry;
    }

    public void setServeNationalEconomyIndustry(String serveNationalEconomyIndustry) {
        this.serveNationalEconomyIndustry = serveNationalEconomyIndustry;
    }

    public String getProjectGoal() {
        return projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal = projectGoal;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "id=" + id +
                ", leader='" + leader + '\'' +
                ", name='" + name + '\'' +
                ", projectType='" + projectType + '\'' +
                ", approvalNumber='" + approvalNumber + '\'' +
                ", researchCategory='" + researchCategory + '\'' +
                ", approvalFund=" + approvalFund +
                ", currentYearInMoney=" + currentYearInMoney +
                ", currentYearOutMoney=" + currentYearOutMoney +
                ", subjectCategory='" + subjectCategory + '\'' +
                ", organizationForm='" + organizationForm + '\'' +
                ", serveNationalEconomyIndustry='" + serveNationalEconomyIndustry + '\'' +
                ", projectGoal='" + projectGoal + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
