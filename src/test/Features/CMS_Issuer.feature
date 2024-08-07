Feature: issuer

  Background:
    Given I am logged in as an admin
    Given   I navigate to the Create Issuer page

  Scenario: creating an New Issuer with Existing issuer name
    Given   I fill in the other required fields with valid data
    When  I fill in the Issuer Name field with ExistingIssuerName
    When   I click the Submit button
    Then  I should see an error message

#  Scenario: creating an New Issuer with Existing Routing and Transit ID
#    And  I fill in the other required fields with valid data
#    When I give in the Routing and Transit Id field with Existing_Routing and Transit Id
#    And  I click the Submit button
#    Then I should see an error message

  Scenario: creating an New Issuer with Existing InstitutionID
    Given   I fill in the other required fields with valid data
    When  I give in the Institution Id field with Existing_Institution Id
    When   I click the Submit button
    Then  I should see an error message



  Scenario: creating an New Issuer
    Given  I fill the all required fields in New Issuer Page with valid data
    Given  I fill the all required fields in Secure Pin Page with valid data
    Given  I fill the all required fields in Card Mailer Return Address Page with valid data
    Given  I fill the all required fields in Business Address Page with valid data
    Given  I fill the all required fields in PIN Mailer Return Address Page with valid data
    Given  I fill the all required fields in Contact Page with valid data
    When I click the Finish button
    Then I should redirected into an successful page





