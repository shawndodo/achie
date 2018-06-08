package achieve.pojo;

import java.util.Date;

// 软件著作权(科研)
public class SoftwareCopyright {

    private int id;
    private String copyrightName;
    private String certificateNum;
    private int selfRank;
    private Date getDate;
    private Date developFinishDate;
    private String copyrightType;
    private String copyrightPerson;
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

    public String getCopyrightName() {
        return copyrightName;
    }

    public void setCopyrightName(String copyrightName) {
        this.copyrightName = copyrightName;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getDevelopFinishDate() {
        return developFinishDate;
    }

    public void setDevelopFinishDate(Date developFinishDate) {
        this.developFinishDate = developFinishDate;
    }

    public String getCopyrightType() {
        return copyrightType;
    }

    public void setCopyrightType(String copyrightType) {
        this.copyrightType = copyrightType;
    }

    public String getCopyrightPerson() {
        return copyrightPerson;
    }

    public void setCopyrightPerson(String copyrightPerson) {
        this.copyrightPerson = copyrightPerson;
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
        return "SoftwareCopyright{" +
                "id=" + id +
                ", copyrightName='" + copyrightName + '\'' +
                ", certificateNum='" + certificateNum + '\'' +
                ", selfRank=" + selfRank +
                ", getDate=" + getDate +
                ", developFinishDate=" + developFinishDate +
                ", copyrightType='" + copyrightType + '\'' +
                ", copyrightPerson='" + copyrightPerson + '\'' +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
