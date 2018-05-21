package achieve.pojo;

import java.util.Date;

public class TeacherAchie {

    private int id;
    private int teacherId;
    private int achieId;
    private String achieType;
    private String teacherContributeType;
    private String label;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getAchieId() {
        return achieId;
    }

    public void setAchieId(int achieId) {
        this.achieId = achieId;
    }

    public String getAchieType() {
        return achieType;
    }

    public void setAchieType(String achieType) {
        this.achieType = achieType;
    }

    public String getTeacherContributeType() {
        return teacherContributeType;
    }

    public void setTeacherContributeType(String teacherContributeType) {
        this.teacherContributeType = teacherContributeType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        return "TeacherAchie{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", achieId=" + achieId +
                ", achieType='" + achieType + '\'' +
                ", teacherContributeType='" + teacherContributeType + '\'' +
                ", label='" + label + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
