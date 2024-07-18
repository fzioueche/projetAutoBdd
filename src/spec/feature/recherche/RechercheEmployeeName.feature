@rechercheEmployeeName
Feature: recherche utilisateur
  En tant qu'admin, je veux effectuer une recherche d'un utilisateur par son employeeName

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @rechercheByEmployeeNameValide
  Scenario: recherche un utilisateur par employee name
    When je clique sur le menu Admin
    And je saisis l'employeename a chercher
    And je clique sur le bouton search
    Then je verifie que l'employee name  apparait dans le tableau

  @rechercheByEmployeeNameInvalide
  Scenario Outline: recherche un utilisateur par employee name non valide
    When je clique sur le menu Admin
    And je saisis l'employeename a chercher "<employeeName>" dans le champ de recherche
    And je clique sur le bouton search
    Then je verifie l'apparition du message d'erreur "<erreur>"

    Examples: 
      | employeeName | erreur  |
      | Karana Singh | Invalid |
      | srrr test    | Invalid |
