Feature: create new note ( text, card, password )

  Scenario: successful create a new text note
    Given user is editing a new test note
    When user submit the note
    Then there is a new note in the sealnote