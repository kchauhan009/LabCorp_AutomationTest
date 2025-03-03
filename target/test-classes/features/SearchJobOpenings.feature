Feature: Search Job Openings and verfiy information

  @SearchJobOpenings
  Scenario Outline: Search for <JobTitle> Job Openings in careers portal
    Given User is on home page
    When User clicked on career link
    Then User searched and selected job <JobTitle>
    Then User validates <JobTitle> and <Location> and <ID>
    Then User Confirm second bullet point under Skills - Must Have as <Skills>
    Then User Confirm third requirement as <Experience>
    Then User Confirm first suggested automation tool to be familiar with <Tools>
    And User click on apply button
    Then User checks <JobApplicationPageTitle> and <JobTitle> and <Location> and <ID> on job application page and returned to job search page

    Examples: 
      | JobTitle                      | Location    | ID     | Tools    | Experience                       | Skills                                                        | JobApplicationPageTitle |
      | Senior QA Automation Engineer | Navi Mumbai | 251869 | Selenium | 5-7 years of experience required | Analyzing software requirements and preparing test scenarios. | Workday                 |