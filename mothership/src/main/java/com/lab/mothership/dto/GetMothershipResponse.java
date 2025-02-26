package com.lab.mothership.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetMothershipResponse {

    UUID id;

    String name;

    int power;
}
