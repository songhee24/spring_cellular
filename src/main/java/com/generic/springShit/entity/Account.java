package com.generic.springShit.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "request")
    private String request;

    @Column(name = "currency")
    private String currency;

    @OneToMany
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client clientId;

}
