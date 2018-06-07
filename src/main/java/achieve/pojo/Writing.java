package achieve.pojo;

import java.util.Date;

public class Writing {

    private int id;
    private String writingName;
    private String publicationNumber;
    private String selfPosition;
    private int selfRank;
    private String press;
    private String writingType;
    private Date publishTime;
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

    public String getWritingName() {
        return writingName;
    }

    public void setWritingName(String writingName) {
        this.writingName = writingName;
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public String getSelfPosition() {
        return selfPosition;
    }

    public void setSelfPosition(String selfPosition) {
        this.selfPosition = selfPosition;
    }

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getWritingType() {
        return writingType;
    }

    public void setWritingType(String writingType) {
        this.writingType = writingType;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

    public String getTeacherName() {return teacherName;}

    @Override
    public String toString() {
        return "Writing{" +
                "id=" + id +
                ", writingName='" + writingName + '\'' +
                ", publicationNumber='" + publicationNumber + '\'' +
                ", selfPosition='" + selfPosition + '\'' +
                ", selfRank=" + selfRank +
                ", press='" + press + '\'' +
                ", writingType='" + writingType + '\'' +
                ", publishTime=" + publishTime +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
