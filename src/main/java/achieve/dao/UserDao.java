package achieve.dao;

import achieve.pojo.User;

public interface UserDao {

    User findByUserName(String userName) ;

    User findById(Integer id) ;

    int editUser(User user) ;

}
