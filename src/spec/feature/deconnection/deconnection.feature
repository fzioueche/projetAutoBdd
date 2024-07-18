@deconnection
Feature: deconnection
  En tant qu'un utilisateur je veux me deconnecter de l'application OrangeHRM

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et le texte "Dashboard" s'affiche

  @deconnection
  Scenario: deconnection de l'application
    When je clique sur le menu déroulant du profil utilisateur
    And  je clique sur le bouton logout 
    Then je me redirige vers la page de connexion  et login s'affiche
