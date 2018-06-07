package achieve.pojo;

import java.util.Date;

// 专利(科研)
public class Patent {
    private int id;
    private String patentName;
    private String patentType;
    private String patentStatus;
    private String patentCode;
    private Date getPatentDate;
    private String applyCode;
    private Date applyDate;
    private int selfRank;
    private String relatedCourseName;
    private String remark;
    private Date createdAt;
    private Date updatedAt;
    private String teacherName;
//    private int researchAchievementId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentStatus() {
        return patentStatus;
    }

    public void setPatentStatus(String patentStatus) {
        this.patentStatus = patentStatus;
    }

    public String getPatentCode() {
        return patentCode;
    }

    public void setPatentCode(String patentCode) {
        this.patentCode = patentCode;
    }

    public Date getGetPatentDate() {
        return getPatentDate;
    }

    public void setGetPatentDate(Date getPatentDate) {
        this.getPatentDate = getPatentDate;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public String getRelatedCourseName() {
        return relatedCourseName;
    }

    public void setRelatedCourseName(String relatedCourseName) {
        this.relatedCourseName = relatedCourseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    public int getResearchAchievementId() {
//        return researchAchievementId;
//    }
//
//    public void setResearchAchievementId(int researchAchievementId) {
//        this.researchAchievementId = researchAchievementId;
//    }


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
        return "Patent{" +
                "id=" + id +
                ", patentName='" + patentName + '\'' +
                ", patentType='" + patentType + '\'' +
                ", patentStatus='" + patentStatus + '\'' +
                ", patentCode='" + patentCode + '\'' +
                ", getPatentDate=" + getPatentDate +
                ", applyCode='" + applyCode + '\'' +
                ", applyDate=" + applyDate +
                ", selfRank=" + selfRank +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
