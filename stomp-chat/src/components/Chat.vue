<template>
  <div>
    <!-- WebSocket 연결 버튼 -->
    <div v-if="!isConnected">
      <button @click="connect">Start Chat</button>
    </div>

    <!-- WebSocket 연결 후 채팅 UI -->
    <div v-else>
      <div>
        <input v-model="message" placeholder="Enter message" />
        <button @click="sendChatMessage">Send</button>
      </div>

      <div>
        <h3>Messages</h3>
        <ul>
          <li v-for="(msg, index) in messages" :key="index">{{ msg }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'; // Composition API에서 ref 사용
import { connectToWebSocket, sendMessage } from '../WebSocket'; // WebSocket 모듈 가져오기

// 상태 변수
const isConnected = ref(false);  // WebSocket 연결 상태
const message = ref('');  // 사용자가 입력한 메시지
const messages = ref([]);  // 서버로부터 받은 메시지 저장 배열

// WebSocket 연결 메서드
const connect = () => {
  connectToWebSocket(onMessageReceived);  // WebSocket 연결
  isConnected.value = true;  // 연결 상태 업데이트
};

// 메시지 전송 메서드
const sendChatMessage = () => {
  if (message.value.trim() !== '') {
    sendMessage(message.value);  // 서버에 메시지 전송
    message.value = '';  // 입력 필드 초기화
  }
};

// 서버에서 수신된 메시지 처리
const onMessageReceived = (receivedMessage) => {
  messages.value.push(receivedMessage);  // 메시지 추가
};

</script>