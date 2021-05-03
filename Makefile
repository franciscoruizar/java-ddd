.PHONY: all build test ping-mysql

all: build test
build: build-jar up

test:
	@./gradlew test

run:
	@./gradlew :run

build-jar:
	@./gradlew :bootJar

up:
	@docker-compose up -d

ping-mysql:
	@docker exec codelytv-java_ddd_template-mysql mysqladmin --user=root --password=lechuga --host "127.0.0.1" ping --silent

# Start the app
start-accounts_backend:
	@./gradlew :run --args='accounts_backend server'

start-gateway_backend:
	@./gradlew :run --args='gateway_backend server'
