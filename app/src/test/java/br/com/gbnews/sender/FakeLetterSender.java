package br.com.gbnews.sender;

public class FakeLetterSender implements LetterSender{
    private boolean sent;

    @Override
    public void send(String recipient, String subject, String message) {
        sent = true;
    }

    public boolean wasSent() {
        return sent;
    }
}
