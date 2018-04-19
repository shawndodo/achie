package achieve.pojo;

public class Teacher {

    private int id;
    private int facultyId;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", facultyId=" + facultyId +
                ", userId=" + userId +
                '}';
    }
}
