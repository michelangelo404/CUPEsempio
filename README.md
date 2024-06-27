# CUPEsempio
Progetto sviluppato utilizzando i container docker, springboot, angular e postgresql

## Installazione

### Step 1
installeremo docker desktop dal sito ufficiale, dopo l'installazione creeremo un network personalizzato utilizzando il comando:
`docker network create <nome_network>`

in questo modo i 3 container che andremo a creare potranno parlarsi tra di loro.

### Step 2
creeremo il primo container, ovvero il database in postgresql:
`docker run -p 8001:5432 --name db-postgres --network=progetto-spring -e POSTGRES_PASSWORD=password -d postgres`

### Step 3
dovremo creare il secondo container, ovvero il backend con springboot, per fare ciò dovremo prima dirigerci nella cartella backend del progetto, aprire il prompt dei comandi e digitare il comando:
`mvn package -DskipTests`
In questo modo creeremo il nostro package jar all'interno della cartella "target"
Poi creeremo il nostro container docker, utilizando il file jar appena creato:
`docker buildx build -t springboot:latest .`
e lo avvieremo con questo comando:
`docker run --name springboot --network=progetto-spring -p 8080:8080 springboot`

### Step 4
il terzo ed ultimo container che creeremo è quello per il frontend in angular.
Il dockerfile è già presente, dovremo soltanto dirigerci nella cartella "frontend" e digitare il comando:
`docker build -t angular-docker .`
e per avviarlo:
`docker run --name angular-docker --network=progetto-spring -p 4201:4200 angular-docker`



