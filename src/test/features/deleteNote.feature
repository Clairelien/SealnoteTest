Feature: delete a text note

#  Scenario: successful delete two text notes in main page
#    Given user create two text note
#    When user delete these notes in the main page
#    Then user can see these text notes in the trash section

  Scenario: successful delete a text note in main page
    Given user create text note
    When user delete this note in the main page
    Then user can see the text note in the trash section

  Scenario: successful delete a text note in main page
    Given user create text note
    When user delete this note in the edit page
    Then user can see the text note in the trash section