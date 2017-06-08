Feature:

  Scenario: check scenarios for yelp.com
#    Go to yelp.com
    Given I navigate to "https://www.yelp.com/sf"
#    Select “Restaurants” in the drop­down box in Find
    When I click on element having id "find_desc"
#    Click Search button
    And click on profile xpath "//*[@id='header_find_form']/div/div[1]/div/div/ul/li[1]/div/div[2]/span/span"
#    Append Pizza to Restaurants to make the search text as “Restaurants Pizza”
    When I enter "- Pizza" into input field having id "find_desc"
#    Append Pizza to Restaurants to make the search text as “Restaurants Pizza”
    Then I click on element having id "header-search-submit"
#    Report total no. of Search results with no. of results in the current page
    And get value of class "pagination-results-window"
#    Parameterize any 2 of the filtering parameters
    And I execute java script "all-filters-toggle"
#    apply first filter for Neighborhoods
    And I apply first filter
#    apply second filter for
    And I apply second filter
#    Report total no. of Search results with no. of results in the current page
    And get value of class "pagination-results-window"
#    Report the star rating of each of the results in the first result page
    And get value of stars
#    Click and expand the first result from the search results
    And click on profile xpath "//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[1]/div/div[1]/div[1]/div/div[2]/h3/a/span"
#    Log information for First 3 customer reviews
    And I execute for review
