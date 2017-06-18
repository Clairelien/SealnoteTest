Feature: delete tag

  Scenario: successful delete tag
    Given user create a text note with tag "tag"
    When user delete the tag "tag"
    Then there is no tag in the tag list

  Scenario: successful delete no note use tag
    Given user create a text note with tag "tag2"
    And delete the note
    When user delete the tag "tag2"
    Then there is no tag in the tag list
