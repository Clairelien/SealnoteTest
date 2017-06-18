Feature: create new note

  Scenario: successful create a new text note
    Given user want to new a text note
    And user is editing a new note which the title is "test", and the content is "hello"
    When user submit the note
    Then there is a new text note which the title is "test", and the content is "hello" in the sealnote

  Scenario: create a empty text note
    Given user want to new a text note
    When user submit the note
    Then there is no new note in the sealnote

  Scenario: successful create a new card note
    Given user want to new a card note
    And user is editing a new card which the title is "test", the name is "my card", the card number "1234123412341234", valid from "1111" to "1120" and cvv is "222"
    When user submit the note
    Then there is a new note which the title is "test", the name is "my card", the card number "1234-1234-1234-1234", valid from "1111" to "1120" and cvv is "222" in the sealnote

  Scenario: create a empty card note
    Given user want to new a card note
    When user submit the note
    Then there is no new note in the sealnote

  Scenario: successful create a new login note
    Given user want to new a login note
    And user is editing a new note which the url is "google.com", the login account is "hello123" and the password is "123***555"
    When user submit the note
    Then there is a new login note which the url is "google.com", the login account is "hello123" and the password is "123***555" in the sealnote

  Scenario: create a empty login note
    Given user want to new a login note
    When user submit the note
    Then there is no new note in the sealnote
