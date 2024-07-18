@recherche
Feature: recherche utilisateur 
  En tant qu'un admin, je veux effectuer une recherche d'un utilisateur par son username

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @rechercheUserName
  Scenario Outline: recherche un utilisateur avec username
    When je clique sur le menu Admin
    And je saisis le username a chercher "<username>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" dans le tableau

    Examples: 
      | username |
      | Admin    |
