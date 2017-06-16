Feature: create new tag in text note

  Scenario Outline: successful delete tag
    Given user want to delete the tag named <tag>
    When user delete the tag
    Then there is no tag <tag> in the tag list
    Examples:
      | tag |
      |  "yoyo"   |