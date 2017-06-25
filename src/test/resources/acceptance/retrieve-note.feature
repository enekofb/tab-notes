Feature: Can retrieve notes
  As a busy person
  I want to retrieve a created note
  So I can remember what happens in my life

  Background:
    Given I have a created a note with id "noteId" password "05031976"

  Scenario: Can retrieve created note by id and right password
    When I retrieve a note with id "noteId" and password "05031976"
    Then note has been successfully retrieved
    And note text has been successfully decrypted

  Scenario: Can retrieve created note by id and wrong password
    When I retrieve a note with id "noteId" and password "not-valid-password"
    Then note has been successfully retrieved
    And note text has not been successfully decrypted
