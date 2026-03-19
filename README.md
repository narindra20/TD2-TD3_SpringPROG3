# PROG3 - TD2 et TD3 Spring Boot

Projet réalisé pour le cours **PROG3 - Implémentation d’API REST**  
HEI - Année 2025-2026

## Structure du repository

- **td2** : Implémentation du TD2
- **td3** : Implémentation du TD3

## TD2

Implémentation des endpoints REST :

- GET /welcome
- POST /students
- GET /students

Utilisation des annotations :
- @RequestParam
- @RequestBody
- @RequestHeader

Les étudiants sont stockés **en mémoire vive**.

## TD3

Amélioration de l'API avec gestion complète des réponses HTTP :

- utilisation de **ResponseEntity**
- gestion des **status codes HTTP**

### Endpoints

GET /welcome
- 200 OK si name fourni
- 400 Bad Request sinon

POST /students
- 201 Created après ajout
- 500 Internal Server Error si exception

GET /students
- 200 OK si Accept = text/plain ou application/json
- 400 Bad Request si header absent
- 501 Not Implemented si format non supporté