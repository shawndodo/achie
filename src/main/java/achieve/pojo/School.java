package achieve.pojo;

public class School {

    private int id;
    private String fullNameCn;
    private String nameCn;
    private String fullNameEn;
    private String nameEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullNameCn() {
        return fullNameCn;
    }

    public void setFullNameCn(String fullNameCn) {
        this.fullNameCn = fullNameCn;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getFullNameEn() {
        return fullNameEn;
    }

    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", fullNameCn='" + fullNameCn + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", fullNameEn='" + fullNameEn + '\'' +
                ", nameEn='" + nameEn + '\'' +
                '}';
    }
}
