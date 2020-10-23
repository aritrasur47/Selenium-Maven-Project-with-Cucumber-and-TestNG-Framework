Feature: Amazon Application Login 

Scenario Outline: Positive test validation login 
	Given Intialize the browser with Driver 
	Given Navigate to "https://www.amazon.in/" website 
	Given Click on to SignIn button in the home page 
	When User enters email <email> 
	And User clicks on continue button 
	And User enters password <password> 
	And User click on login button 
	Then Verify that the user is successfully logged in 
	
	Examples: 
		|email	                 | password        |
		|xxxxxxxxx.@gmail1.com   | xxxxxpassword1  |
		|xxxxxxxxx.@gmail2.com   | xxxxxpassword2  |