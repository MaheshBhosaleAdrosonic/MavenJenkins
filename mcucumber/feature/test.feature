Feature: Shopping Homepage
This feature verifies the functionality on Shopping Homepage

Scenario: Login to application
Given I open my application
When I login with the following data
| 		UserName 		| Password  |
|btest@gmail.com  | Btest@123 |
Then Check home page is displayed

Scenario: 
Given product Is Displayed
When product Add Into Cart as "Printed Dress"
Then Check Product Added Into Cart


Scenario: GOToProgressNote
Given Progress Note Page Display
When Treatement Page Open
Then Check Lab Added