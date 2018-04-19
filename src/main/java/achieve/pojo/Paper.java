package achieve.pojo;

import java.util.Date;

public class Paper {

    private int id;
    private String paperName;
    private String paperType;
    private int selfRank;
    private String isAlone;
    private String messageAuthor;
    private String periodicalName;
    private String inclusionSearch;
    private Date publishTime;
    private String keyWord;
    private String relatedCourseName;
    private String remark;
    private String edition;
    private String startEndPageNum;
    private String doiNum;
    private String issnNum;
    private String cnNum;
    private String impactFactor;
    private String quotesNum;
    private int researchAchievementId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public int getSelfRank() {
        return selfRank;
    }

    public void setSelfRank(int selfRank) {
        this.selfRank = selfRank;
    }

    public String getIsAlone() {
        return isAlone;
    }

    public void setIsAlone(String isAlone) {
        this.isAlone = isAlone;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getPeriodicalName() {
        return periodicalName;
    }

    public void setPeriodicalName(String periodicalName) {
        this.periodicalName = periodicalName;
    }

    public String getInclusionSearch() {
        return inclusionSearch;
    }

    public void setInclusionSearch(String inclusionSearch) {
        this.inclusionSearch = inclusionSearch;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getStartEndPageNum() {
        return startEndPageNum;
    }

    public void setStartEndPageNum(String startEndPageNum) {
        this.startEndPageNum = startEndPageNum;
    }

    public String getDoiNum() {
        return doiNum;
    }

    public void setDoiNum(String doiNum) {
        this.doiNum = doiNum;
    }

    public String getIssnNum() {
        return issnNum;
    }

    public void setIssnNum(String issnNum) {
        this.issnNum = issnNum;
    }

    public String getCnNum() {
        return cnNum;
    }

    public void setCnNum(String cnNum) {
        this.cnNum = cnNum;
    }

    public String getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(String impactFactor) {
        this.impactFactor = impactFactor;
    }

    public String getQuotesNum() {
        return quotesNum;
    }

    public void setQuotesNum(String quotesNum) {
        this.quotesNum = quotesNum;
    }

    public int getResearchAchievementId() {
        return researchAchievementId;
    }

    public void setResearchAchievementId(int researchAchievementId) {
        this.researchAchievementId = researchAchievementId;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", paperName='" + paperName + '\'' +
                ", paperType='" + paperType + '\'' +
                ", selfRank=" + selfRank +
                ", isAlone='" + isAlone + '\'' +
                ", messageAuthor='" + messageAuthor + '\'' +
                ", periodicalName='" + periodicalName + '\'' +
                ", inclusionSearch='" + inclusionSearch + '\'' +
                ", publishTime=" + publishTime +
                ", keyWord='" + keyWord + '\'' +
                ", relatedCourseName='" + relatedCourseName + '\'' +
                ", remark='" + remark + '\'' +
                ", edition='" + edition + '\'' +
                ", startEndPageNum='" + startEndPageNum + '\'' +
                ", doiNum='" + doiNum + '\'' +
                ", issnNum='" + issnNum + '\'' +
                ", cnNum='" + cnNum + '\'' +
                ", impactFactor='" + impactFactor + '\'' +
                ", quotesNum='" + quotesNum + '\'' +
                ", researchAchievementId=" + researchAchievementId +
                '}';
    }
}
