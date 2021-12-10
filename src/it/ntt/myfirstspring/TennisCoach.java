package it.ntt.myfirstspring;

public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {}

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
