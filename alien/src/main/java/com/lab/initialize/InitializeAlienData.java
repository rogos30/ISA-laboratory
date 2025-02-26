package com.lab.initialize;

import com.lab.entity.Alien;
import com.lab.service.AlienService;
import com.lab.entity.Mothership;
import com.lab.service.MothershipService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class InitializeAlienData implements InitializingBean {

    AlienService alienService;
    MothershipService mothershipService;

    //@Autowired
    public InitializeAlienData(
            AlienService alienService,
            MothershipService mothershipService
    ) {
        this.alienService = alienService;
        this.mothershipService = mothershipService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if (alienService.find("test").isEmpty()) {
            Mothership raiders = Mothership.builder()
                    .id(UUID.fromString("1584a9da-f3de-48a1-aee1-2123fa5ec98a"))
                    .name("Raiders")
                    .power(500)
                    .build();

            Mothership pacifists = Mothership.builder()
                    .id(UUID.fromString("13f6a3fe-aaca-4673-a50b-bffcf90ca175"))
                    .name("Pacifists")
                    .power(300)
                    .build();

            mothershipService.create(raiders);
            mothershipService.create(pacifists);

            Alien zeke = Alien.builder()
                    .id(UUID.fromString("2f3b4d13-9796-405f-bde8-86121758929f"))
                    .name("Zeke")
                    .power(14)
                    .mothership(raiders)
                    .build();

            Alien bruun = Alien.builder()
                    .id(UUID.fromString("3dd4e2cb-ccc9-4096-8dcf-305ce8e251de"))
                    .name("Bruun")
                    .power(5)
                    .mothership(pacifists)
                    .build();

            Alien bob = Alien.builder()
                    .id(UUID.fromString("49391e56-500a-408b-aed8-add13117bed7"))
                    .name("Bob")
                    .power(10)
                    .mothership(raiders)
                    .build();

            Alien rava = Alien.builder()
                    .id(UUID.fromString("1c38d850-c0ab-40b1-9953-daede56d1c87"))
                    .name("Rava")
                    .power(3)
                    .mothership(pacifists)
                    .build();

            alienService.create(zeke);
            alienService.create(bruun);
            alienService.create(bob);
            alienService.create(rava);
        }
    }
}
