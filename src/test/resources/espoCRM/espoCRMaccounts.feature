Feature: : Validate new accounts creation in espoCRM

  Background: the user goes to home page
    Given the user goes to espoCRM page and login

#  Test case 1: validation of home page function names
#  User goes to espoCRM demo page
#  User login by clicking login button
#  User validate all the function names are matching with ones in provided table

  Scenario: user see the functions names at the home page
    Given the user validate functions names
      | Home          |
      | Accounts      |
      | Contacts      |
      | Leads         |
      | Opportunities |
      | Reports       |
      | Quotes        |
      | Sales Orders  |
      | Invoices      |
      | Products      |
      | Emails        |
      | Cases         |
      | Calendar      |
      | Tasks         |

#  Test case 2: validation of new accounts creation with a 4 sets of new account details
#  User goes to espoCRM demo page;
#  User logins by clicking login button
#  User clicks the "Account" tab
#  User clicks "Create Account" button
#  User creates four new accounts using the provided table and clicks "Save" button
#  User clicks "Accounts" button and validate all four new accounts are reflected on UI

  Scenario Outline: new account creation and validation
    Given the user clicks the Accounts tab
    Then the user clicks the Create Account button
    Then the user enters "<name>", "<website>", "<type>", "<country>" and saves new account
    And the user validate the new account details "<name>", "<website>", "<type>", "<country>" are matching

    Examples:
      | name           | website          | type     | country |
      | Luke Huber     | www.huber.com    | Partner  | Belgium |
      | Hanka Gross    | www.gross.com    | Customer | Germany |
      | Kevin Bykes    | www.bykes.com    | Investor | Ireland |
      | Luiza Gonzalez | www.gonzalez.com | Reseller | Brazil  |

#  Test case 3: validation of user details
#  User goes to espoCRM demo page
#  User logins by clicking login button
#  User clicks the three dot button to see additional functions
#  User clicks "Users" button
#  User validate the Names and Emails on UI are matching with the provided table

#  @userDetails
  Scenario: user details validation
    When the user clicks the three dot button
    Then the user clicks the Users tab
    And the user should validate the Names and Emails are matching the with the provided table

      | Admin           | espocrm.demo@gmail.com              |
      | Ben Parter      | ben.parter@example.com.ko           |
      | Bill Chan       | bill_chan@example-demo.so           |
      | Brendon Lewis   | brendon.lewis@re-example.org        |
      | Emma Bard       | emma_bard@rio.demo.su               |
      | Gabliel Brie    | gabrielbrie@exmpl.org.pi            |
      | Jake Forester   | jake_forester@example-espo.demo.com |
      | Jim Williams    | jim_williams@example.com.ca         |
      | Rebecca Maer    | rebecca.maer@demoexmpl.org          |
      | Richard Pan     | richard_pan@read.exmpl-dd.com       |
      | Thomas Peterson | thomas.peterson@demo-user.exmpl.com |