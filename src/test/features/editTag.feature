Feature: create new tag in text note

  Scenario Outline: successful edit tag
    Given user create a text note with tag
    When user edit the tag to <newTag>
    Then the tag <newTag> is in the tag list
    Examples:
    |  newTag  |
    |     "newTag"       |
    |      ""            |