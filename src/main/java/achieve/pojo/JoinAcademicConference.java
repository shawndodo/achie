package achieve.pojo;

import java.util.Date;

// 参加学术会议(科研)
public class JoinAcademicConference {

    private int id;
    private String name;
    private String location;
    private String level;
    private String paperName;
    private String isInviteReport;
    private Date submitDate;
    private String remark;
    private String participant;
    private String title;
    private String subjectCategory;
    private Date createdAt;
    private Date updatedAt;
    private String teacherName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getIsInviteReport() {
        return isInviteReport;
    }

    public void setIsInviteReport(String isInviteReport) {
        this.isInviteReport = isInviteReport;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "JoinAcademicConference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", level='" + level + '\'' +
                ", paperName='" + paperName + '\'' +
                ", isInviteReport='" + isInviteReport + '\'' +
                ", submitDate=" + submitDate +
                ", remark='" + remark + '\'' +
                ", participant='" + participant + '\'' +
                ", title='" + title + '\'' +
                ", subjectCategory='" + subjectCategory + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
