package com.business.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class User {

    @Id
    @Column(name = "id_user")
    private String idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private String created;

    @Column(name = "modified")
    private String modified;

    @Column(name = "last_login")
    private String lastLogin;

    @Column(name = "isactive")
    private String isactive;

//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
//    private List<Phone> listPhones;
}
