Feature: create new tag in text note

  Scenario Outline: successful edit tag
    Given user want to edit the tag on the top of the tag list
    When user edit the tag to <newTag>
    Then the tag <newTag> is in the tag list
    Examples:
    |  newTag  |
    |     "yaya"       |
    |      "中文"            |
    |       "/*-/*-/*"               |