package com.lab.mothership.initialize;

import com.lab.mothership.entity.Mothership;
import com.lab.mothership.service.MothershipService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class InitializeMothershipData implements InitializingBean {

    MothershipService mothershipService;

    //@Autowired
    public InitializeMothershipData(
            MothershipService mothershipService
    ) {
        this.mothershipService = mothershipService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if (mothershipService.findAll().isEmpty()) {
            Mothership raiders = Mothership.builder()
                    .id(UUID.fromString("1584a9da-f3de-48a1-aee1-2123fa5ec98a"))
                    .name("Raiders")
                    .power(300)
                    .build();

            Mothership pacifists = Mothership.builder()
                    .id(UUID.fromString("13f6a3fe-aaca-4673-a50b-bffcf90ca175"))
                    .name("Pacifists")
                    .power(500)
                    .build();

            mothershipService.create(raiders);
            mothershipService.create(pacifists);
        }
    }
}
