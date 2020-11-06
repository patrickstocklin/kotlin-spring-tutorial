Feature: health

  Scenario: Health
    Given my service is deployed
    When i call my service
    Then i get a 200