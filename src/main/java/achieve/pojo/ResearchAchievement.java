package achieve.pojo;

public class ResearchAchievement {

    private int id;
    private String teachAchieType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachAchieType() {
        return teachAchieType;
    }

    public void setTeachAchieType(String teachAchieType) {
        this.teachAchieType = teachAchieType;
    }

    @Override
    public String toString() {
        return "ResearchAchievement{" +
                "id=" + id +
                ", teachAchieType='" + teachAchieType + '\'' +
                '}';
    }
}
