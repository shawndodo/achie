package achieve.pojo;

public class TeacherAchie {

    private int id;
    private int teacherId;
    private int achieId;
    private int achieType;
    private int teacherContributeType;

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

    public int getAchieType() {
        return achieType;
    }

    public void setAchieType(int achieType) {
        this.achieType = achieType;
    }

    public int getTeacherContributeType() {
        return teacherContributeType;
    }

    public void setTeacherContributeType(int teacherContributeType) {
        this.teacherContributeType = teacherContributeType;
    }

    @Override
    public String toString() {
        return "TeacherAchie{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", achieId=" + achieId +
                ", achieType=" + achieType +
                ", teacherContributeType=" + teacherContributeType +
                '}';
    }
}
