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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id",referencedColumnName = "id")
    private Rate rate;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "number")
    private String number;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client clientId;
}
