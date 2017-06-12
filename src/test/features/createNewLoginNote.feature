Feature: create new login note

  Scenario Outline: successful create a new login note
    Given user want to new a login note
    And user is editing a new note which the url is <url>, the login account is <acc> and the password is <pwd>
    When user submit the login note
    Then there is a new login note which the url is <url>, the login account is <acc> and the password is <pwd> in the sealnote
    Examples:
      |      url      |      acc       |  pwd  |
      |      "google.com"     |    "hello123"   | "123***555" |
#      |     "測試"     |    "嗨這是中文!"   |    ""     |
#      | "/*-+@@%&*" |    "^&&*(%%*&"   |    ""   |