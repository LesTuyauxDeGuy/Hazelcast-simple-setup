package com.tdg.hazelcast.simple.setup;


import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Random;

import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
        Random random = new Random();

        HazelcastInstance inst = Hazelcast.newHazelcastInstance();
        Map<String, String> demoMap = inst.getMap("demo");

        while (true) {
            //génération d'un nombre aléatoire entre 1 et 10
            int nombreAleatoireDeSecondes = random.nextInt(10) + 1;
            // on effectue une pause aléatoire
            Thread.sleep(nombreAleatoireDeSecondes * 1000);

            // on ajoute un élément à la map partagée dans hazelcast
            demoMap.put(LocalDateTime.now().toString(),UUID.randomUUID().toString());

            System.out.println("Nb total d'éléments dans la map:" + demoMap.size());
        }

    }

}
