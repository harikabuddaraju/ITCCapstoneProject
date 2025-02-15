Feature: Login to JPetStore and Validate My Order page heading
 
#Step1: User Launch the Browser and URL
#Step2: Login to the Jpetstore web app
#Step3: Validate the page heading
#Step4: Close the Browser
 
 
Scenario: Validate My Order page heading in JPetStore Application
Given User launch the Browser and Url
And Login to the JPetStore web application
Then User validate "My Orders" as page heading in JpetStore Order list page
And User close the Browser