package it.ntt.myfirstspring;

public class OtherFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "This is just another fortune service";
    }
    
}
