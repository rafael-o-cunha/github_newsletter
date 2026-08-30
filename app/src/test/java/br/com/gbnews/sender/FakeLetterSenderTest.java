package br.com.gbnews.sender;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FakeLetterSenderTest {

    @Test
    void shouldSendLetter() {

        LetterSender sender = new FakeLetterSender();

        sender.send(
                "test@email.com",
                "Test",
                "Hello"
        );

        assertTrue(
                ((FakeLetterSender) sender).wasSent()
        );
    }
}