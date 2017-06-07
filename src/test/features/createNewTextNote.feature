Feature: create new text note

  Scenario Outline: successful create a new text note
    Given user want to new a text note
    And user is editing a new note which the title is <title>, and the content is <content>
    When user submit the text note
    Then there is a new text note which the title is <title>, and the content is <content> in the sealnote
    Examples:
      |  title    |      content       |
      |  "test"   |    "hello world"   |
#      |  "測試"   |    "嗨這是中文!"   |