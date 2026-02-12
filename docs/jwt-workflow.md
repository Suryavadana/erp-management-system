JWT workflow
Client → POST /login (username + password)
        ↓
Spring verifies credentials
        ↓
JWT generated
        ↓
Client stores token
        ↓
Client sends token in Authorization header