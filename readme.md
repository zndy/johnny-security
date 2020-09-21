# authentication-server login: post Request 
### 1. get token
##### curl -d "username=johnny&password=123&grant_type=password&scope=select&client_id=client_2&client_secret=123456" -X POST http://localhost:8181/oauth/token
### 2. use token by call resource-server1
##### curl -H "Authorization: Bearer token_string" http://localhost:8071/talk
### 3. use token by call resource-server2
##### curl -H "Authorization: Bearer token_string" http://localhost:8072/remote-talk
