Feature: create new card note

  Scenario Outline: successful create a new text note
    Given user want to new a card note
    And user is editing a new card which the title is <title>, the name is <name>, valid from <startDate> to <endDate> and cvv is <cvv>
    When user submit the card note
    Then there is a new note which the title is <title>, the name is <name>, valid from <startDate> to <endDate> and cvv is <cvv> in the sealnote
    Examples:
    |  title  |  name  |  startDate  |  endDate | cvv |
    |""       |""      |""           |""        |""   |