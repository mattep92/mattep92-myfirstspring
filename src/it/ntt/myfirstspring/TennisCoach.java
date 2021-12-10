package it.ntt.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {}

    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    
    @Override
    public String getDailyWorkout() {
        return "Try to hit the ball :P || "+ fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void doInitStuffs() {
        System.out.println("Initializing Tennis Coach...");
    }

    public void doDestroyStuffs() {
        System.out.println("Destroying Tennis Coach...");
    }
    
}
