package com.generic.springShit.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Phone_Number")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "request")
    private String request;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client clientId;

}
