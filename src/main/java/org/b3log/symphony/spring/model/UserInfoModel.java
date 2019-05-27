package org.b3log.symphony.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "user_info")
public class UserInfoModel {

    @JsonIgnore
    @Id
    @Column(name = "id", length = 64)
    private String id;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

}
