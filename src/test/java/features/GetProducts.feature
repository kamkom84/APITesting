Feature: Get all products from the api

  Scenario: Verify the get api for the products
    Given User hits the url of get product api endpoint
    When User passes the url in the request
    Then User should receive the response code as 200

  Scenario Outline: Verify the rate of first product is correct
    Given User hits the url of get product api endpoint
    When User passes the url in the request
    Then User verifies that the rate of the first product is <FirstProductRate>
      Examples:
      | FirstProductRate|
      | 3.90            |

