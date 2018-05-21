package achieve.pojo;

import java.util.Date;

public class Attachment {

    private int id;
    private String file;
    private String fileName;
    private Date createdAt;
    private Date updatedAt;
    private int attachmentGroupId;
    private String status;
    private int fileSize;
    private String remark;
    private String fileExt;
    private String fileContentType;
    private String attachmentUrl;
    private String reason;
    private String checkStatus;
    private int ownerId;
    private String ownerType;
    private String operatorPlatform;
    private String dataSource;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public int getAttachmentGroupId() {
        return attachmentGroupId;
    }

    public void setAttachmentGroupId(int attachmentGroupId) {
        this.attachmentGroupId = attachmentGroupId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOperatorPlatform() {
        return operatorPlatform;
    }

    public void setOperatorPlatform(String operatorPlatform) {
        this.operatorPlatform = operatorPlatform;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", file='" + file + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", attachmentGroupId=" + attachmentGroupId +
                ", status='" + status + '\'' +
                ", fileSize=" + fileSize +
                ", remark='" + remark + '\'' +
                ", fileExt='" + fileExt + '\'' +
                ", fileContentType='" + fileContentType + '\'' +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", reason='" + reason + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", ownerId=" + ownerId +
                ", ownerType='" + ownerType + '\'' +
                ", operatorPlatform='" + operatorPlatform + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", userId=" + userId +
                '}';
    }
}
