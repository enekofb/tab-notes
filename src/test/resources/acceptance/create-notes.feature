Feature: Can create notes
  As a busy person
  I want to create a note
  So I can remember what happens in my life

  Scenario: Can create empty note
    When I create an empty note
    Then note has been sucessfully created

#  Scenario Outline: Can calculate the price of an empty cart
#    Given I have a cart given by "<cartFile>"
#    When I calculate its price
#    Then Its prices is "<cartPrice>"
#
#    Examples:
#      | cartFile       | cartPrice |
#      | cart-4560.json | 4560.0     |
#      | cart-9363.json | 9363.1     |
#      | cart-9500.json | 9500.0     |
#      | cart-11356.json | 11356.8     |
