package it.ntt.myfirstspring;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach() {}

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    
    public String getDailyWorkout() {
        return "Run for 20 minutes || "+ fortuneService.getFortune();
    }
}
