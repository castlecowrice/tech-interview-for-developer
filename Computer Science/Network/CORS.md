## CORS

1. Web Browser -> Web Server A (GET /index.html)
2. A -> Web Browser
3. Web Browser -> Web Server B (Preflight Request)
4. B -> Web Browser (Access-Control-Allow-Origin: A)
5. Web Browser -> Web Server B (GET /coffee.jpg (B에 저장되어 있는 리소스))
6. B -> Web Browser

HTML img 태그 vs 스크립트
