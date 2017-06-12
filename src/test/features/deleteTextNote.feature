Feature: delete a text note

  Scenario: successful delete a text note
    Given user select the latest text note
    When user delete this note
    Then user can see the text note in the trash section