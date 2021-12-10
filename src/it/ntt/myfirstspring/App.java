package it.ntt.myfirstspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
    public static void main(String[] args) {

        System.out.println("### \"normale\" ###");

        HappyFortune happyFortune = new HappyFortune();
        OtherFortune otherFortune = new OtherFortune();
        
        Coach bbCoach = new BaseballCoach(happyFortune);
        Coach trCoach = new TrackCoach(happyFortune);
        Coach teCoach = new TennisCoach(otherFortune);

        System.out.println(bbCoach.getDailyWorkout()+"\n"+
            trCoach.getDailyWorkout()+"\n"+
            teCoach.getDailyWorkout());
        
        // Utilizzo Spring

        System.out.println("\n### Spring ###");
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("myCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkout());

        context.close();

        // Implemento la DI (Dependency Injection)

        System.out.println("\n### Dependency Injection ###");

        ClassPathXmlApplicationContext contextDIconstructor = new ClassPathXmlApplicationContext("applicationContextDIconstructor.xml");
        Coach myCoach2 = contextDIconstructor.getBean("myDICoach", Coach.class);

        System.out.println(myCoach2.getDailyWorkout());

        contextDIconstructor.close();

        // Implemento la SI (Setter Injection)

        System.out.println("\n### Setter Injection ###");
        
        ClassPathXmlApplicationContext contextDISetter = new ClassPathXmlApplicationContext("applicationContextDIsetter.xml");
        Coach myCoach3 = contextDISetter.getBean("myDICoach", Coach.class);
        
        System.out.println(myCoach3.getDailyWorkout());

        // Utilizza init e destroy methods
        // I metodi init e destroy vengono invocati rispettivamente
        // alla creazione e alla distruzione dell'istanza della classe

        System.out.println("\n### init & destroy ###");

        contextDISetter.close();

    }
}
