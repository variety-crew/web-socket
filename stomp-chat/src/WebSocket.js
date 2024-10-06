import { Client } from '@stomp/stompjs';

let stompClient = null;

export function connectToWebSocket(onMessageReceived) {
  // 순수 WebSocket 연결
  stompClient = new Client({
    brokerURL: 'ws://localhost:8080/ws',  // WebSocket 엔드포인트 설정
    reconnectDelay: 5000,  // 연결 실패 시 재시도 간격
    debug: (str) => console.log("debug logs: ", str),  // 디버그 로그

    // 연결 성공 시 실행
    onConnect: () => {
      console.log('Connected to WebSocket');

      // 메시지 구독
      stompClient.subscribe('/topic/messages', (message) => {
        onMessageReceived(JSON.parse(message.body));
      });
    },
    onStompError: (frame) => {
      console.error('Broker error: ' + frame.headers['message']);
    }
  });

  // WebSocket 연결 시작
  stompClient.activate();
}

export function sendMessage(content) {
  if (stompClient && stompClient.connected) {
    stompClient.publish({
      destination: '/app/send',
      body: JSON.stringify({ content }),
    });
  } else {
    console.log("WebSocket is not connected yet.");
  }
}