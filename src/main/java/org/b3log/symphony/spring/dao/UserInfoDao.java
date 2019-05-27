package org.b3log.symphony.spring.dao;



import org.b3log.symphony.spring.model.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoDao extends JpaRepository<UserInfoModel,String>, JpaSpecificationExecutor<UserInfoModel> {

    @Query("select p from UserInfoModel p where p.username=:username ")
    UserInfoModel findByUserName(@Param("username") String username);

    @Query("select p from UserInfoModel p where p.phoneNumber=:phoneNumber ")
    UserInfoModel findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}