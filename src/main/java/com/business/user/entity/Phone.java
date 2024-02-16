package com.business.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Phone {

    @Id
    @Column(name = "id_phone")
    private String idPhone;

    @Column(name = "number")
    private String number;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "id_user")
    private String idUser;

}
