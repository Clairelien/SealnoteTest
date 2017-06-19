Feature: edit a note

  Scenario: successful edit a text note
    Given user create a text note
    And turn the title to "test123"
    When user save the note
    Then user can see the title of this note is "test123"

  Scenario: edit a text note to be empty
    Given user create a text note
    And clear all the blank in text note
    When user save the note
    Then the text note will not be changed

  Scenario: successful edit a card note
    Given user create a card note
    And turn the valid from to "2222"
    When user save the note
    Then user can see the valid from of this note is "2222"

  Scenario: edit a card note to be empty
    Given user create a card note
    And clear all the blank in card note
    When user save the note
    Then the card note will not be changed

  Scenario: successful edit a login note
    Given user create a login note
    And turn the password to "00000"
    When user save the note
    Then user can see the password of this note is "00000"

  Scenario: edit a login note to be empty
    Given user create a login note
    And clear all the blank in login note
    When user save the note
    Then the login note will not be changed
