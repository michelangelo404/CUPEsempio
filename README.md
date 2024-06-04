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
dovremo creare il secondo container, ovvero il backend con springboot
