package achieve.pojo;

import java.util.Date;

// 教学奖项(教学)
public class TeachAward {

    private int id;
    private String awardName;
    private int selfRank;
    private String level;
    private String awardDepartment;
    private Date awardDate;
    private String remark;
    private String relatedCourseName;
    private Date createdAt;
    private Date updatedAt;

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

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRelatedCourseName() {
        return relatedCourseName;
    }

    public void setRelatedCourseName(String relatedCourseName) {
        this.relatedCourseName = relatedCourseName;
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

    @Override
    public String toString() {
        return "TeachAward{" +
                "id=" + id +
                ", awardName='" + awardName + '\'' +
                ", selfRank=" + selfRank +
                ", level='" + level + '\'' +
                ", awardDepartment='" + awardDepartment + '\'' +
                ", awardDate=" + awardDate +
                ", remark='" + remark + '\'' +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
