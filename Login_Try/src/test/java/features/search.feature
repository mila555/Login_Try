Feature: Login using Form Authentication

@SeleniumTest
Scenario Outline: Login using username and password
Given User is on home page
When User clicks on Form Authentication Link
And  Enters <Username> and <Password>
Then Success message is displayed


Examples:
|Username|Password|
|tomsmith |SuperSecretPassword!|
|Beetroot|SuperSecretPassword!|