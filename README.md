# web-socket

## SETTINGS
- local
    - vue
        - `npm install sockjs-client`
        - `npm install @stomp/stompjs sockjs-client`
    - spring boot
        ```.gradle
          dependencies {
              implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
              implementation 'org.springframework.boot:spring-boot-starter-web'
              implementation 'org.springframework.boot:spring-boot-starter-websocket'
              compileOnly 'org.projectlombok:lombok'
              developmentOnly 'org.springframework.boot:spring-boot-devtools'
              annotationProcessor 'org.projectlombok:lombok'
              testImplementation 'org.springframework.boot:spring-boot-starter-test'
              testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
          }
        ```
    - docker
        - `docker-compose up --build`
            - compass remote access
            - 데이터베이스 명: chatdb
            - 컬렉션 명: chatMessages

## TEST
- 채팅방 입장 전(핸드세이크 전)
    - ![image](https://github.com/user-attachments/assets/28067d4e-1869-42fc-971c-e7d516151029)
- 채팅방 입장(http 핸드세이크)
    - ![image](https://github.com/user-attachments/assets/f069f5ff-9d1b-4f96-9216-8413bcaa2f6d)
- 채팅 전송
    - ![image](https://github.com/user-attachments/assets/1c524aa5-cacd-42d0-8b4e-764dc663882a)
    - ![image](https://github.com/user-attachments/assets/bc11e180-3b4c-4e9d-89bf-5b31198ba087)
- 데이터베이스 저장
    - ![image](https://github.com/user-attachments/assets/e732c982-1b7b-403a-9dc3-1e38be3cfb46)
