@recherche
Feature: recherche utilisateur par user role
  En tant qu'un admin, je veux effectuer une recherche d'un utilisateur par son user role

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @rechercheByRole
  Scenario Outline: recherche un utilisateur par user role
    When je clique sur le menu Admin
    And je clique sur le champ user role et je choisis le role "<userRole>"
    And je clique sur le bouton search
    Then je verifie le user role "<userRole>" dans le tableau

    Examples: 
      | userRole |
      | Admin    |
      | ESS      |
