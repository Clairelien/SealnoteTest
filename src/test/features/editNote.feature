Feature: edit a text note

  Scenario: successful edit a text note
    Given user select the latest text note, and the new title is "test123"
    When user edit this note and save
    Then user can see the title of this note is "test123"