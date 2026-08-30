COMPOSE = docker compose \
    --env-file infra/.env \
    -f infra/docker-compose.yml

APP_CONTAINER = news_app

build:
	$(COMPOSE) build $(APP_CONTAINER)

up:
	$(COMPOSE) up -d $(APP_CONTAINER)

down:
	$(COMPOSE) down $(APP_CONTAINER)

exec:
	docker exec -it $(APP_CONTAINER) bash

logs:
	$(COMPOSE) logs -f $(APP_CONTAINER)

clean:
	$(COMPOSE) down -v

re: clean build
