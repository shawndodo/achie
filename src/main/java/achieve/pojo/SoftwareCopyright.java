package achieve.pojo;

public class SoftwareCopyright {

    private int id;
    private String copyrightName;
    private String certificateNum;
    private int selfRank;
    private String copyrightType;
    private String copyrightPerson;
    private String relatedCourseName;
    private String remark;
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

//    public int getResearchAchievementId() {
//        return researchAchievementId;
//    }
//
//    public void setResearchAchievementId(int researchAchievementId) {
//        this.researchAchievementId = researchAchievementId;
//    }

    @Override
    public String toString() {
        return "SoftwareCopyright{" +
                "id=" + id +
                ", copyrightName='" + copyrightName + '\'' +
                ", certificateNum='" + certificateNum + '\'' +
                ", selfRank=" + selfRank +
                ", copyrightType='" + copyrightType + '\'' +
                ", copyrightPerson='" + copyrightPerson + '\'' +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", remark='" + remark + '\'' +
//                ", researchAchievementId=" + researchAchievementId +
                '}';
    }
}
