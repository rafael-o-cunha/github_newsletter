

# Minha tese é que é possível criar uma newsletter utilizando GitHub Actions, integrando diferentes veículos de comunicação.

# Setup 

```Shell
mvn archetype:generate \
  -DgroupId=br.com.gbnews \
  -DartifactId=app \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.5 \
  -DinteractiveMode=false \
  -DoutputDirectory=./app
```


- implementei o básico para testar viabilidade de rodar através de um action do github.


## Testes

### V0: ✅

- criar programa básico que de forma local envie e-mail
- ao rodar o programa um email é disparado e recebido corretamente pelo destinatário.

```XML
<dependency>
  <groupId>jakarta.mail</groupId>
  <artifactId>jakarta.mail-api</artifactId>
  <version>2.1.3</version>
</dependency>
```

o email foi enviado corretamente usando javaMail, ja era de se esperar porém a validação que eu estava buscando estava mais ligada 

ao fato de que usat smtp do gmail poderia ser complicado ou inviável, e não foi, apenas criei uma "Senha de App" dado a caracterísica da conta do google

e funcionou.


### V1: ✅

- com o projeto no github criar um github action para executar o programa e realizar o disparo do email
- ao executar o github action será realizado build e run do projeto fazendo-o enviar o email.
- espera-se que seja validado build, run e envio de e-mail.

O processo para esta etapa foi simples, como já previa, um .yml faria um job existir para ser executado, restava

saber se seria viável a saída de um email de dentro do ambiente.


### V2: ✅

- criar um novo veículo, Discord, fazer com que o programa envie e-mail e também a mensagem para o discord.
- ao executar o programa uma mensagem de discord será enviada para um canal específico.
- espera-se que seja validado envio e recebimento de mensagem para o discord assim como anteirormente o e-mail é realizado.

parece que é possível usar uma lib do discord que propiciará uma interface para facilitar envio de mensagens de aplicação java para dentro do discord.

iniciamente usei http do java para envio da mensagem pois esta etapa do projeto está testando viabilidade.

funcionou como esperado, porém com 1 webhook gerado no discord e envio para ele, algo a ser projetado de forma dinamica posteriormente.






---

## [1] Envio de email

- [mailtrap-io.translate.goog/blog/java-send-email-gmail/?_x_tr_sl=en&amp;_x_tr_tl=pt&amp;_x_tr_hl=pt&amp;_x_tr_pto=tc](https://mailtrap-io.translate.goog/blog/java-send-email-gmail/?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc)
- [www.devmedia.com.br/enviando-email-com-javamail-utilizando-gmail/18034](https://www.devmedia.com.br/enviando-email-com-javamail-utilizando-gmail/18034)
- [support.google.com/mail/answer/185833?hl=pt-br](https://support.google.com/mail/answer/185833?hl=pt-br)
- [sites.google.com/ufscar.br/gustavomauricio/inicio/tutoriais/criar-e-usar-senhas-de-app](https://sites.google.com/ufscar.br/gustavomauricio/inicio/tutoriais/criar-e-usar-senhas-de-app)


### [2] Criar Github Actions

- [www-freecodecamp-org.translate.goog/news/learn-to-use-github-actions-step-by-step-guide/?_x_tr_sl=en&amp;_x_tr_tl=pt&amp;_x_tr_hl=pt&amp;_x_tr_pto=tc](https://www-freecodecamp-org.translate.goog/news/learn-to-use-github-actions-step-by-step-guide/?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc)
- [labex.io/pt/tutorials/github-actions-first-workflow-creation-633887](https://labex.io/pt/tutorials/github-actions-first-workflow-creation-633887)


### [3] Envio de mensagem no Discord

- [www.alura.com.br/artigos/webhooks?srsltid=AfmBOopBqnei2WKF0Qx7AVz7-KPfSxwBdruDARFe0B-HP-wIv1ig0V-A](https://www.alura.com.br/artigos/webhooks?srsltid=AfmBOopBqnei2WKF0Qx7AVz7-KPfSxwBdruDARFe0B-HP-wIv1ig0V-A)
- [coffops.com/enviar-mensagens-para-o-discord-usando-um-webhook-e-python](https://coffops.com/enviar-mensagens-para-o-discord-usando-um-webhook-e-python/)
- [dev.to/shahidfoy/how-to-send-discord-webhook-alerts-in-java-spring-boot-example-h51](https://dev.to/shahidfoy/how-to-send-discord-webhook-alerts-in-java-spring-boot-example-h51)
