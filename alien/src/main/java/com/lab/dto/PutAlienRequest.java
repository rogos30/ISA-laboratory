package com.lab.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PutAlienRequest {
    String name;
    int power;
    UUID mothershipId;
}
