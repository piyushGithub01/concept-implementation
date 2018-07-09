Different approaches to API versioning

There are some different ways to provide an API versioning in your application. The most popular of them are:

Through an URI path - you include the version number in the URL path of the endpoint, for example /api/v1/persons

Through query parameters - you pass the version number as a query parameter with specified name, for example /api/persons?version=1

Through custom HTTP headers - you define a new header that contains the version number in the request

Through a content negotiation - the version number is included to the �Accept� header together with accepted content type. The request with cURL would look like in the following sample: curl -H "Accept: application/vnd.piomin.v1+json" http://localhost:8080/api/persons
