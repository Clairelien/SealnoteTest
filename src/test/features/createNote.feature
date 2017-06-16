Feature: create new text note

#  Scenario Outline: successful create a new text note
#    Given user want to new a text note
#    And user is editing a new note which the title is <title>, and the content is <content>
#    When user submit the note
#    Then there is a new text note which the title is <title>, and the content is <content> in the sealnote
#    Examples:
#      |      title      |      content       |
#      |      "test"     |    "hello world"   |
#      |     "測試"     |    "嗨這是中文!"   |
#      | "/*-+@@%&*" |    "^&&*(%%*&"   |
#
#  Scenario: create a empty text note
#    Given user want to new a empty text note
#    When user submit the note
#    Then there is no new text note in the sealnote

#  Scenario Outline: successful create a new card note
#    Given user want to new a card note
#    And user is editing a new card which the title is <title>, the name is <name>, the card number <number>, valid from <startDate> to <endDate> and cvv is <cvv>
#    When user submit the note
#    Then there is a new note which the title is <title>, the name is <name>, the card number <number>, valid from <startDate> to <endDate> and cvv is <cvv> in the sealnote
#    Examples:
#      |   title   |  name  |  number|  startDate  |  endDate | cvv |
#      |  "test"   |  "my card"  |  "1234123412341234"  |  "2312"  |  "1231"  |  "222"  |
#
  Scenario Outline: successful create a new login note
    Given user want to new a login note
    And user is editing a new note which the url is <url>, the login account is <acc> and the password is <pwd>
    When user submit the note
    Then there is a new login note which the url is <url>, the login account is <acc> and the password is <pwd> in the sealnote
    Examples:
      |      url      |      acc       |  pwd  |
      |      "google.com"     |    "hello123"   | "123***555" |
#      |     "測試"     |    "嗨這是中文!"   |    ""     |
#      | "/*-+@@%&*" |    "^&&*(%%*&"   |    ""   |