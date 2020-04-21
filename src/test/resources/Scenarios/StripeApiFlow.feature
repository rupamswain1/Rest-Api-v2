Feature: Test Stripe API Customer flow

Scenario Outline: Test E2E Flow of Stripe API customer flow

Given Create a general blank customer and store the cutomer id in "custId"
Then Validate customer id is created 
Then validate status code is "<status code>"
And Create a get request for cutomer "custId"
Then Validate customer id is fetched for "custId"
Then Validate status code is "<get code>"
And then customer with "custId" updated with "<email>" and "<description>"
Then validate status code is "<update status code>"
Then Create a get request for cutomer "custId"
Then validate email and description matches with "<email>" and "<description>"
And user deletes customer "custId"
Then user validates status code "<delete status>"
Then user user validates delete fiels as "<delete response>"
Examples:
|status code|get code|email      |description|update status code|delete status|delete response|
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |
|200        |200     |abc@pqr.com|cucumbers  |200               |200          |true           |

