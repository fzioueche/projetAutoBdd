@authentification
Feature: authentification
  En tant qu'un utilisateur je veux m'identifier sur l'application OrangeHRM

  Background: 
    Given je me connecte sur l'application

  @authentificationValide
  Scenario: authentification avec des coordonnées valides
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @authentificationNonValide
  Scenario Outline: authentification avec des coordonnées non valides
    When je saisis le username "<username>"
    And je saisis le password "<password>"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "<resultatAttendu>" s'affiche

    Examples: 
      | username | password | resultatAttendu     |
      | Adminn   | admin123 | Invalid credentials |
      | Admin    | admin456 | Invalid credentials |
      | Adminn   | admin456 | Invalid credentials |
      |          | admin123 | Required            |
      | Admin    |          | Required            |
      |          |          | Required            |
