package com.generic.springShit.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "SMS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SMS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id",referencedColumnName = "id")
    private Rate rate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accepting_sms_id",referencedColumnName = "id")
    private PhoneNumber acceptingSms;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sms_sending_id",referencedColumnName = "id")
    private PhoneNumber sendingSms;

    @Column(name = "sms_length")
    private Integer smsLength;

}
