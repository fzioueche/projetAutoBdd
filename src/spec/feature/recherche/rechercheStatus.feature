@recherche
Feature: recherche utilisateur par user role
  En tant qu'un admin, je veux effectuer une recherche d'un utilisateur par son status

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @rechercheByStatus
  Scenario Outline: recherche un utilisateur par status
    When je clique sur le menu Admin
    And je clique sur le champ status et je choisis le role "<Status>"
    And je clique sur le bouton search
    Then je verifie le status "<Status>" dans le tableau

    Examples: 
      | status   |
      | Enabled  |
      | Disabled |
