package br.com.gbnews;

import br.com.gbnews.sender.DiscordLetterSender;
import br.com.gbnews.sender.EmailLetterSender;
import br.com.gbnews.sender.LetterSender;

public class App {
    public static void main(String[] args) {
        LetterSender sender = new EmailLetterSender(
                System.getenv("SMTP_USERNAME"),
                System.getenv("SMTP_PASSWORD"),
                System.getenv("SMTP_HOST"),
                Integer.parseInt(System.getenv("SMTP_PORT")));

        sender.send(
                System.getenv("TEST_RECIPIENT"),
                "Newsletter - Teste V0",
                """
                        Esta é uma mensagem de teste
                        enviada pelo Newsletter Hub V0.

                        Veículo: Email
                        """);

        sender = new DiscordLetterSender();

        sender.send(
                System.getenv("DISCORD_WEBHOOK_URL"),
                "Newsletter - Teste V0",
                """
                        Esta é uma mensagem de teste
                        enviada pelo Newsletter Hub.

                        Veículo: Discord
                        """);
    }
}
