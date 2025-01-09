# Système d'Auto-Diagnostic pour l'Hôpital du Futur

## Contexte
Bienvenue dans le projet de développement du système d'auto-diagnostic pour l'hôpital du futur. Ce projet fait partie d'une équipe de développement au sein de la squad Diagnostic, qui suit la méthodologie agile SCRUM. L'objectif est de développer un système permettant de traiter l'index de santé généré par une cabine d'auto-diagnostic, d'analyser les pathologies associées, et de rediriger les patients vers les unités médicales appropriées au sein de l'hôpital.

### Objectif
Le projet est basé sur un capteur qui génère un **index de santé**, une valeur numérique utilisée pour diagnostiquer des pathologies. Selon la valeur de cet index, le système déterminera si le patient souffre d'une pathologie cardiaque (multiples de 3), d'une fracture (multiples de 5), ou des deux (multiples de 3 et 5).

### Règles Métier
1. Un index de santé multiple de **3** indique un problème cardiaque (redirection vers **Cardiologie**).
2. Un index de santé multiple de **5** indique une fracture (redirection vers **Traumatologie**).
3. Si l'index de santé est multiple de **3 et 5**, le patient sera redirigé vers **Cardiologie** et **Traumatologie**.
4. Si l'index de santé ne correspond à aucune pathologie, le système doit renvoyer un message d'erreur.

### Exemple de Scénarios
- **Index 33** → Redirection vers **Cardiologie**.
- **Index 55** → Redirection vers **Traumatologie**.
- **Index 15** → Redirection vers **Cardiologie** et **Traumatologie**.

## Précisions Techniques

- **Technologie utilisée** : Spring Boot avec Java 21.
- **Service** : Le service reçoit un index de santé, analyse les multiples et renvoie la ou les pathologies associées.
- **Gestion des erreurs** : En cas d'index non valide, le système renvoie un message d'erreur approprié.

### Accédez à l'interface Swagger de l'API :
- **URL de l'interface Swagger** : http://localhost:8080/swagger-ui.html 

## Installation

### Prérequis
- Java 21 ou supérieur
- Maven 3.3.4 ou supérieur

### Étapes pour démarrer le projet

1. **Clonez le repository** :

   ```bash
   git clone https://github.com/softwaymedical/auto-diagnostic.git
   cd auto-diagnostic```
  
