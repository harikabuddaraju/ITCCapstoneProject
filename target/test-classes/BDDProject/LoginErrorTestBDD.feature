Feature: Login to JPetStore with incorrect credentials and Validate the login error message
 
#Step1: User Launch the Browser and URL
#Step2: Login with incorrect credentials in Jpetstore web app
#Step3: Validate the error message
#Step4: Close the Browser
 
Scenario: Login with incorrect credentials and Validate the login error message in JPetStore Application
Given User launch the Browser and Url
And User login with incorrect credentials in JPetStore web application
Then User validate "Invalid username or password. Signon failed." as error message in JpetStore login page
And User close the Browser