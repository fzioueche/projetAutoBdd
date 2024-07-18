@ajoutUtilisateur
Feature: ajout d'un utilisateur
  en tant qu'admin, je veux ajouter un utilisateur dans le tableau

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @ajoutUtilisateur
  Scenario Outline: ajout d'un nouveau utilisateur
    When je clique sur le menu Admin
    And je clique sur bouton add
    And j ecris le user role "<user Role>"
    And je saisis le nom de l'employee "<employee Name>"
    And je sélectionne le statut de l'employee "<status>"
    And je saisis le username a ajouter "<username>"
    And j ecris le mot de passe "fatima@01"
    And je confirme le mot de passe ecris "fatima@01"
    And je clique sur bouton save
    Then je me redirige vers la page Admin et "System Users" s'affiche
    And je saisis le nom d'utilisateur à rechercher "<username>"
    And je clique sur le bouton Search
    Then je vérifie que le nouvel utilisateur "<username>" est présent dans le tableau

    Examples: 
      | username   | userRole | status   | employeeName | password  | confirmPassword |
      | fatima123x | Admin    | Enabled  | manda user   | fatima@01 | fatima@01       |
      | fatima123X | ESS      | Disabled | manda user   | fatima@01 | fatima@01       |
