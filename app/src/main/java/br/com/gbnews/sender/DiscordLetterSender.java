package br.com.gbnews.sender;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DiscordLetterSender implements LetterSender {

    private final HttpClient httpClient;

    public DiscordLetterSender() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public void send(
            String recipient,
            String subject,
            String message
    ) {

        String webhookUrl = recipient;

        String content = """
                **%s**

                %s
                """.formatted(subject, message);

        String json = """
                {
                    "content": %s
                }
                """.formatted(toJsonString(content));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(webhookUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {

            HttpResponse<String> response =
                    httpClient.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            if (response.statusCode() < 200 ||
                response.statusCode() >= 300) {

                throw new RuntimeException(
                        "Erro ao enviar mensagem para Discord. " +
                        "HTTP " + response.statusCode() +
                        ": " + response.body()
                );
            }

            System.out.println(
                    "Mensagem enviada para Discord."
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao enviar mensagem para Discord",
                    e
            );
        }
    }

    private String toJsonString(String value) {

        return "\"" +
                value
                        .replace("\\", "\\\\")
                        .replace("\"", "\\\"")
                        .replace("\n", "\\n")
                        .replace("\r", "\\r") +
                "\"";
    }
}