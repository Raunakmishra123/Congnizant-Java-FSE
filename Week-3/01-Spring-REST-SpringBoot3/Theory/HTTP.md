# HTTP Protocol

Hypertext Transfer Protocol (HTTP) is the foundation of data communication on the World Wide Web.

## HTTP Request Elements

1. **Request Method:** Indicates the action to perform (e.g., GET, POST, PUT, DELETE).
2. **Request URI:** The path identifying the resource (e.g., `/api/books`).
3. **Headers:** Metadata like `Content-Type`, `Accept`, and authentication tokens.
4. **Body:** The payload data (usually in JSON format for REST APIs).

## HTTP Response Elements

1. **Status Code:** Three-digit numeric code indicating the outcome (e.g., 200, 404, 500).
2. **Headers:** Metadata describing the response (e.g., `Content-Type: application/json`).
3. **Body:** The returned data/payload.

## Common HTTP Methods

- **GET:** Retrieve a resource. Safe and idempotent.
- **POST:** Create a new resource. Not safe, not idempotent.
- **PUT:** Replace/update an existing resource entirely. Idempotent.
- **PATCH:** Partially update a resource.
- **DELETE:** Remove a resource. Idempotent.
