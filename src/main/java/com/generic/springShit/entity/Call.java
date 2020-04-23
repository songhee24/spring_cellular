package com.generic.springShit.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "call")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accepting_call_id",referencedColumnName = "id")
    private PhoneNumber acceptingCallNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calling_id",referencedColumnName = "id")
    private PhoneNumber callingPhoneNumber;

    @Column(name = "minutes")
    private Integer minutes;
}
