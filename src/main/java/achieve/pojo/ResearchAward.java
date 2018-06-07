package achieve.pojo;

import java.util.Date;

// 获奖成果(科研)
public class ResearchAward {

    private int id;
    private String awardName;
    private String publishJournal;
    private String publisher;
    private Date publishDate;
    private String awardWinningName;
    private String awardType;
    private String awardDepartment;
    private Date awardDate;
    private String awardNumber;
    private int unitRank;
    private int selfRank;
    private String subjectCategory;
    private String remark;
    private Date createdAt;
    private Date updatedAt;
    private String teachername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getPublishJournal() {
        return publishJournal;
    }

    public void setPublishJournal(String publishJournal) {
        this.publishJournal = publishJournal;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAwardWinningName() {
        return awardWinningName;
    }

    public void setAwardWinningName(String awardWinningName) {
        this.awardWinningName = awardWinningName;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getAwardDepartment() {
        return awardDepartment;
    }

    public void setAwardDepartment(String awardDepartment) {
        this.awardDepartment = awardDepartment;
    }

    public Date getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public int getUnitRank() {
        return unitRank;
    }

    public void setUnitRank(int unitRank) {
        this.unitRank = unitRank;
    }

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "ResearchAward{" +
                "id=" + id +
                ", awardName='" + awardName + '\'' +
                ", publishJournal='" + publishJournal + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", awardWinningName='" + awardWinningName + '\'' +
                ", awardType='" + awardType + '\'' +
                ", awardDepartment='" + awardDepartment + '\'' +
                ", awardDate=" + awardDate +
                ", awardNumber='" + awardNumber + '\'' +
                ", unitRank=" + unitRank +
                ", selfRank=" + selfRank +
                ", subjectCategory='" + subjectCategory + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
