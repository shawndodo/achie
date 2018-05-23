package achieve.service;

import achieve.dao.AttachmentDaoImpl;
import achieve.pojo.Attachment;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentService {

    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    public void setValue(MultipartFile file, String url, int userId, int ownerId, String ownerType){

        Attachment attachment = new Attachment();
        attachment.setFile(file.toString());
        attachment.setFileName(file.getOriginalFilename());
        attachment.setStatus("active");
        attachment.setFileSize((int)file.getSize());
        attachment.setFileExt(StringUtils.substringBeforeLast(file.getOriginalFilename(), "."));
        attachment.setAttachmentUrl(url);
        attachment.setOwnerId(ownerId);
        attachment.setOwnerType(ownerType);
        // 先默认为teacher 后续会加入admin
        attachment.setOperatorPlatform("teacher");
        attachment.setUserId(userId);
        System.out.println("attachmentId是" + attachmentDaoImpl.addAttachment(attachment));

    }

}
