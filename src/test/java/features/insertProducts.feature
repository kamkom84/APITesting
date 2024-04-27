Feature: Insert product using POST API

  Scenario Outline: Verify validate post product api works correctly
    Given User hits the url of post product api endpoint
    When User passes the url in the request
    And User passes the request body of the product title <ProductTitle>
    Then User should receive the response code as 200
      Examples:
      | ProductTitle |
      | Shoes |