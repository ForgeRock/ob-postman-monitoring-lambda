# Open Banking postman monitoring lambda hook

# Compile the jar

The lambda is expecting a java jar. You will need to compile the project:

```$xslt
mvn clean package shade:shade
```

# Configuring the lambda

You will need to setup environment variables to the lambda.
The environments variables you need to provide:

* ``apiKey`` : the postman API key, to allow the lambda to call your postman collection
* ``monitoringId`` : the postman monitoring ID
* ``originRegion`` : the postman monitoring region
* ``applicationId`` : the monitoring application ID
* ``applicationSecret`` : the monitoring application secret
* ``institutionId`` : the monitoring institution ID
* ``monitoringUri`` : the monitoring uri service
* ``slackWebHook`` : the slack hook. If null, no notification will be send to slack.

#Setup a cron

We personally took the decision of setting up a cron triggering event for the lambda. 