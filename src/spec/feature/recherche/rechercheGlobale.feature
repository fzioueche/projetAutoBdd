@rechercheGlobale
Feature: recherche utilisateur
  En tant qu'un admin, je veux effectuer une recherche d'un utilisateur par

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @rechercheGlobale
  Scenario Outline: recherche un utilisateur par
    When je clique sur le menu Admin
    And je saisis le username a chercher "<username>
    And je clique sur le champ user role et je choisis le role "<userRole>"
    And je saisis l'employeename a chercher
    And je clique sur le champ status et je choisis le role "<Status>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" dans le tableau
    Then je verifie le user role "<userRole>" dans le tableau
    Then je verifie que l'employee name  "<employeeName>" apparait dans le tableau
    Then je verifie le status "<Status>" dans le tableau

    Examples: 
      | username | userRole | employeeName | status   |
      | Admin    | Admin    | Karan Singh  | Enabled  |
      | Admin    | ESS      |              | Disabled |
