Feature: Can create notes
  As a busy person
  I want to create a note
  So I can remember what happens in my life

  Scenario: Can create empty note
    Given I have an empty note
    When I create the note
    Then note has been successfully created

  Scenario Outline: Can create not empty notes
    Given I have a note with title "<title>" text "<text>" and password "<password>"
    When I create the note
    Then note has been successfully created

    Examples:
      | title    | text                            | password |
      | walk dog | I have to walk to pingo at 6 am | 05021975 |
