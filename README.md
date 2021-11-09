# leaderboard-api

Create a Mongo DB locally (Use terminal)
-------------------------

use playerstat_db

db.players.insertOne({ name: 'Lynx Titan', attack: {score: 40000000, level: 110}, defense: {score: 45000000, level: 180}, magic: {score: 42000700, level: 152}, cooking: {score: 43000020, level: 102}, crafting: {score: 48000000, level: 109}, level: 2200});


>> Insert other players like this from json file.

Swagger UI
----------

Swagger UI is available which maps all the apis.

http://localhost:8080/swagger-ui.html
