package achieve.pojo;

import java.util.Date;

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
//                ", researchAchievementId=" + researchAchievementId +
                '}';
    }
}
