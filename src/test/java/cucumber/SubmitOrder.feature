@tag
Feature: Order the product in the Ecommerce site

Background:
Given I landed on the login page

@tag2
Scenario Outline: Positive flow of ordering the product

Given user is logged in with username <email> and password <passwordused>
When the user is able to add product <productname> to the cart 
And checkout the <productname>
Then  "Thankyou for the order." confirmation message is displayed

Examples:
| email                   | passwordused | productname  |
|jecinthamuldoss@gmail.com| Jecintha@19  | ZARA COAT 3  |