package br.com.gbnews.sender;

public interface LetterSender {
        
    void send(String recipient, String subject, String mesage);

}
