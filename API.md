# Messaging Exercise Using DDD #

## 1. Overview ##

Your team needs to be able to pass a message to another team.\
However, the message is only applicable within a set period of time and must be discarded afterwards.\
To avoid unnecessarily spreading the information, it is important that the message can only be read once, after which it should be discarded.

Slack, email and other existing messaging system isn't applicable for the given requirements, so you've been tasked to create
a simple REST API for creating and retrieving the message.

## 2. Acceptance Criteria ##

**Scenario: Create New Message**

Given an endpoint for creating a message \
When the user posts a request to create a new message \
And specified the time to live of that message \
Then the endpoint should return a created response \
With the link to retrieve the message \
And the expiry of the message

Given an endpoint for creating a message \
When the user posts a request to create a new message \
And the time to live of that message is not specified \
Then the endpoint should return a created response \
With the link to retrieve the message \
And the default expiry of 30 mins from when the message was created

**Scenario: Retrieve the Message**

Given an unused and unexpired link to a message \
When the user accesses that link \
Then the message should be returned

Given a used link to a message \
When the user accesses that link \
Then a gone response should be returned \
And an error message to say that the message has already been retrieved

Given an expired link to a message \
When the user accesses that link \
Then a gone response should be returned \
And an error message to say that the message has expired

### 3. URI scheme ###

*BasePath* \: /api  
*Schemes* \: HTTP

## 2. Paths ##

### 2.1. POST /v1/message ###

#### 2.1.1. Request Body ####
Content type: `application/json`

| Field | Type | Required | Description |
|---|---|---|---|
| message | string | required | Message to store |
| ttl | integer | optional | Time to live in minutes |

Example:

```
POST /api/v1/message

{
    "message": "this is a test message",
    "ttl": 5
}
```

or curl request:
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"message":"this is a test message","ttl":5}' \
  http://localhost:7777/api/v1/message
```

#### 2.1.2. Response ####
Content type: `application/json`

| HTTP Code | Description |
|---|---|
| 201 | Successful |

| Field | Type | Description |
|---|---|---|
| accessLink | string | The link to access the message |
| expiry | string | The expiry date of the message |

Example:

```
{
    "accessLink": "http://localhost:7777/api/v1/message/949dc5dc-600a-4935-94af-0396ead1353e",
    "expiry": "Sep 15, 2020 05:00:24 UTC"
}
```

### 2.2. GET /v1/message/{id} ###

#### 2.2.1. Request Parameter ####
Accept: `application/json`

| Parameter | Type | Required | Description |
|---|---|---|---|
| id | string | required | Message id |

Example:

```
GET /api/v1/message/949dc5dc-600a-4935-94af-0396ead1353e
```

or curl request:
```
curl http://localhost:7777/api/v1/message/949dc5dc-600a-4935-94af-0396ead1353e -i \
  -H 'Accept: application/json'
```

#### 2.1.2. Response ####
Content type: `application/json`

| HTTP Code | Description |
|---|---|
| 200 | Successful |
| 404 | Message not found |
| 410 | Message is expired or previously accessed |

| Field | Type | Description |
|---|---|---|
| message | string | The stored message |

Example:

```
{
    "message": "this is a test message"
}
```