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

# Start the app
start-accounts_backend:
	@./gradlew :run --args='accounts_backend server'
