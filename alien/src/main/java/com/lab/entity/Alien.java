package com.lab.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    UUID id;

    String name;

    int power;

    @ManyToOne
    @JoinColumn(name = "mothership_id")
    Mothership mothership;
}
