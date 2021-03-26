all: build

up:
	@docker-compose up -d

build:
	@./gradlew build --warning-mode all

run-tests:
	@./gradlew test --warning-mode all

run:
	@./gradlew :run

build-jar:
	@./gradlew :bootJar

# Start the app
start-accounts_backend:
	@./gradlew :run --args='accounts_backend server'

start-gateway_backend:
	@./gradlew :run --args='gateway_backend server'
