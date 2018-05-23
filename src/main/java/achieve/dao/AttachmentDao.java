package achieve.dao;

import achieve.pojo.Attachment;

public interface AttachmentDao {

    Integer addAttachment(Attachment attachment);

    Attachment findByOwnerIdAndOwnerType(Integer ownerId, String ownerType) ;

    void deleteAttachment(Integer attachmentId) ;

}
