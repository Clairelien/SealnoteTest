Feature: create new tag in text note

  Scenario Outline: successful create new tag in text note
    Given user want to add a new tag named <tag> in the <type> note
    When user save the text note
    Then user can see the new tag <tag> in the tag list
    Examples:
    |           tag            |type|
    |         "tag"          |   "Plain Text"  |
    |         "tag1"          |   "Card Details"  |
    |         "tag2"          |   "Login Details"  |
    |         "中文"          |   "Plain Text"  |
    |         "中文1"          |   "Card Details"  |
    |         "中文2"          |   "Login Details"  |

