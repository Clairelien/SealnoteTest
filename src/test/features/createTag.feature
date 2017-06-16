Feature: create new tag in text note

  Scenario Outline: successful create new tag in text note
    Given user want to add a new tag named <tag> in the text note
    When user save the text note
    Then user can see the new tag <tag> in the tag list
    Examples:
    |           tag            |
    |         "yoyo"          |
    |    "中文中文喔喔喔"     |
    |    "/*--***/%$%^#&"    |
#    |           ""             |