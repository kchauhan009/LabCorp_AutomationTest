Feature: Validate beeceptor Api's
  I want to use this template for my feature file

  @getBeeceptorData
  Scenario: Verify Path, IP and All Headers
    Given User get beeceptor information and validated Path IP and all headers
      | Path                             | IP            | Host                    | User-Agent                              | Accept | Accept-Encoding | Cache-Control | Content-Type     | Postman-Token                        |
      | /sample-request?author=beeceptor | 103.83.219.69 | echo.free.beeceptor.com | Apache-HttpClient/4.5.13 (Java/17.0.12) | */*    | gzip,deflate    | no-cache      | application/json | 60b0b055-fa2a-4255-95af-7455938c2a19 |

  @postCustomerInformation
  Scenario: Verify the accuracy of customer information, payment details and product information
  	Given Customer information addition and verification