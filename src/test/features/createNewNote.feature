Feature: create new note ( text, card, password )

  Scenario: successful create a new text note
    Given user is editing a new note which the title is "test", and the content is "hello world"
    When user submit the note
    Then there is a new note which the title is "test", and the content is "hello world" in the sealnote