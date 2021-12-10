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

        // Utilizzo init e destroy methods
        // I metodi init e destroy vengono invocati rispettivamente
        // alla creazione e alla distruzione dell'istanza della classe

        System.out.println("\n### init & destroy ###");

        contextDISetter.close();

        // Utilizzo Annotations

        System.out.println("\n### Annotations ###");

        // Risolvere gli errori di questa parte

        // ClassPathXmlApplicationContext contextAnnotations = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        
        // Come glielo passiamo adesso che non abbiamo più l'ID?
        // Di default, nei Component, l'ID è il nome della classe,
        // MA con la prima lettera MINUSCOLA!

        // Si può fare, ma è brutto... ed evitare questo è il motivo per cui usiamo Spring
        // TennisCoach myCoach4 = contextAnnotations.getBean("tennisCoach", TennisCoach.class);
        // OtherFortune fortune = new OtherFortune();
        // myCoach4.setFortuneService(fortune);
        // System.out.println(myCoach4.getDailyWorkout());
        // contextAnnotations.close();

        // Coach myCoach4 = contextAnnotations.getBean("tennisCoach", Coach.class);
        // System.out.println(myCoach4.getDailyWorkout());

        // Utilizzo Autowired

        // System.out.println("\n### Autowired ###");

        // Coach myCoach5 = contextAnnotations.getBean("soccerCoach", Coach.class);
        // System.out.println(myCoach5.getDailyWorkout());

        // contextAnnotations.close();

    }
}
