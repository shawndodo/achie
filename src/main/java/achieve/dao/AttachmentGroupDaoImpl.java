package achieve.dao;

import achieve.pojo.AttachmentGroup;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.Date;

public class AttachmentGroupDaoImpl implements AttachmentGroupDao {

    public Integer addAttachmentGroup(AttachmentGroup attachmentGroup) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO attachment_group " +
                    "(catalogType , ownerId , ownerType , status , userId, remark, reason, dataSource, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, attachmentGroup.getCatalogType()) ;
            ps.setInt(2, attachmentGroup.getOwnerId()) ;
            ps.setString(3, attachmentGroup.getOwnerType()) ;
            ps.setString(4, attachmentGroup.getStatus()) ;
            ps.setInt(5, attachmentGroup.getUserId()) ;
            ps.setString(6, attachmentGroup.getRemark()) ;
            ps.setString(7, attachmentGroup.getReason()) ;
            ps.setString(8, attachmentGroup.getDataSource()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(9, timeStamp);
            ps.setTimestamp(10, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int attachmentGroupId = 0;
            if(rs.next())
            {
                attachmentGroupId = rs.getInt(1);
            }
            ps.close() ;
            return attachmentGroupId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }


}
