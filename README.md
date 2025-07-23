# WebSocket Module - VoiceService

This module implements WebSocket configuration and handling for the VoiceService using Spring Boot.

## Features

- WebSocket setup with Spring Boot.
- Custom handler (`LlamadaHandler`) for real-time communication.
- Allows connections from any origin (`*`).

## Structure

- `config/WebSocketConfig.java`: Main WebSocket configuration.
- `websocket/LlamadaHandler.java`: Handler for managing WebSocket messages.

## Installation

1. Clone the repository.
2. Make sure you have Java and Maven installed.
3. Run:

   ```bash
      mvn spring-boot:run  
    ```

## Running

Start the application with:

  ```bash
   mvn clean install
  ```

## Usage
Connect to the WebSocket endpoint from your preferred client to send and receive real-time messages.
