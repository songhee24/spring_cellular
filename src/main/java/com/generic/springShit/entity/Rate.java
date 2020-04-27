package com.generic.springShit.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "for_call")
    private Double forCall;

    @Column(name = "for_sms")
    private Double forSMS;

    @ManyToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operatorId;
}
