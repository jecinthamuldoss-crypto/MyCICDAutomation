
Feature: Verify the error Scenario in the login page


@Errorvalidationn
Scenario Outline: Negative flow of ordering the product

Given user is logged in with username <email> and wrong password <passwordused>
Then  "Incorrect email or password" message is displayed

Examples:
| emailerr                   | passworderr |
|jecinthamuldoss@gmail.com   | Jecintha@1  | 