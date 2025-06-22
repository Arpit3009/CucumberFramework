Feature:Test login page

  Background:
    Given I am on login page.

    @gh @jk
    Scenario Outline: give incorrect username and password and see error message comes or not
      Given I enter wrong "<username>" and "<password>".
      When I ckicked on login button
      Then error "<error_message>" should come.
      Examples:
        | username   | password | error_message                                                                                    |
        | acc@fm.vom | dd       | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |

      @jk
  Scenario Outline: give incorrect username and password and see error message comes or not , verify it with tag
    Given I enter wrong "<username>" and "<password>".
    When I ckicked on login button
#    Then error "<error_message>" should come.
    Examples:
      | username | password |
      |kk@kk.com |kjl       |

        @kl
    Scenario: demo of data table
      Given I enter username and password.
        | hj | jk |
        |bkh |hj  |
