package achieve.dao;

import achieve.pojo.Attachment;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.Date;

public class AttachmentDaoImpl implements AttachmentDao {

    public Integer addAttachment(Attachment attachment) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO attachment " +
                    "(file , fileName , createdAt , updatedAt , attachmentGroupId, status, fileSize, remark, fileExt, fileContentType, attachmentUrl, reason, checkStatus, ownerId, ownerType, operatorPlatform, dataSource, userId) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, attachment.getFile()) ;
            ps.setString(2, attachment.getFileName()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(3, timeStamp);
            ps.setTimestamp(4, timeStamp);
            ps.setInt(5, attachment.getAttachmentGroupId()) ;
            ps.setString(6, attachment.getStatus()) ;
            ps.setInt(7, attachment.getFileSize()) ;
            ps.setString(8, attachment.getRemark()) ;
            ps.setString(9, attachment.getFileExt()) ;
            ps.setString(10, attachment.getFileContentType()) ;
            ps.setString(11, attachment.getAttachmentUrl()) ;
            ps.setString(12, attachment.getReason()) ;
            ps.setString(13, attachment.getCheckStatus()) ;
            ps.setInt(14, attachment.getOwnerId()) ;
            ps.setString(15, attachment.getOwnerType()) ;
            ps.setString(16, attachment.getOperatorPlatform()) ;
            ps.setString(17, attachment.getDataSource()) ;
            ps.setInt(18, attachment.getUserId()) ;


            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int attachmentId = 0;
            if(rs.next())
            {
                attachmentId = rs.getInt(1);
            }
            ps.close() ;
            return attachmentId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public Attachment findByOwnerIdAndOwnerType(Integer ownerId, String ownerType){

        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM attachment " +
                    "WHERE ownerId = ? AND ownerType = ? and status = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, ownerId) ;
            ps.setString(2, ownerType);
            Attachment attachment = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                attachment = new Attachment() ;
                attachment.setId(rs.getInt("id")) ;
                attachment.setFile(rs.getString("file")) ;
                attachment.setFileName(rs.getString("fileName")) ;
                attachment.setCreatedAt(rs.getTimestamp("createdAt")) ;
                attachment.setUpdatedAt(rs.getTimestamp("updatedAt")) ;
                attachment.setAttachmentGroupId(rs.getInt("attachmentGroupId")) ;
                attachment.setStatus(rs.getString("status")) ;
                attachment.setFileSize(rs.getInt("fileSize")) ;
                attachment.setRemark(rs.getString("remark")) ;
                attachment.setFileExt(rs.getString("fileExt")) ;
                attachment.setFileContentType(rs.getString("fileContentType")) ;
                attachment.setAttachmentUrl(rs.getString("attachmentUrl")) ;
                attachment.setReason(rs.getString("reason")) ;
                attachment.setCheckStatus(rs.getString("checkStatus")) ;
                attachment.setOwnerId(rs.getInt("ownerId")) ;
                attachment.setOwnerType(rs.getString("ownerType")) ;
                attachment.setOperatorPlatform(rs.getString("operatorPlatform")) ;
                attachment.setDataSource(rs.getString("dataSource")) ;
                attachment.setUserId(rs.getInt("userId")) ;
            }
            rs.close() ;
            ps.close() ;
            return attachment ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }


    }

    public void deleteAttachment(Integer attachmentId){

        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "DELETE FROM attachment " +
                    "WHERE id = ?" ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, attachmentId) ;
            int n = ps.executeUpdate() ;
            System.out.println(n) ;
            ps.close() ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }finally{
            DBUtil.close(conn) ;
        }


    }

}
