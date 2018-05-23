package achieve.service;

import achieve.dao.AttachmentGroupDaoImpl;
import achieve.pojo.AttachmentGroup;
import org.springframework.stereotype.Service;

@Service
public class AttachmentGroupService {

    private static AttachmentGroupDaoImpl attachmentGroupDaoImpl = new AttachmentGroupDaoImpl();

    public int getOrSetValue(int ownerId, String ownerType, int userId){
        AttachmentGroup attachmentGroup = new AttachmentGroup();
        attachmentGroup.setCatalogType("上传成果附件");
        attachmentGroup.setOwnerId(ownerId);
        attachmentGroup.setOwnerType(ownerType);
        attachmentGroup.setStatus("active");
        attachmentGroup.setUserId(userId);
        int attachmentGroupId = attachmentGroupDaoImpl.addAttachmentGroup(attachmentGroup);
        return attachmentGroupId;
    }

}
