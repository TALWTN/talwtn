# WTN Popularization (1) WHIP/WHEP Standard Signaling
The “shortcoming” of WebRTC standardization
In today’s Internet applications, audio and video communication has become an essential part. In order to achieve efficient and stable audio and video communication, developers need to use some specialized protocols and technologies. Among them, WebRTC technology is a very popular technology that can help developers build efficient and stable audio and video communication applications.

However, for developers in the streaming media industry, WebRTC is not “complete” and lacks a matching standard signaling protocol. The introduction of WHIP and WHEP completes the last “shortcoming” of webrtc standardization and adds a simple signaling layer on top of WebRTC to connect WebRTC publishers to WebRTC media servers to solve market demand pain points.

## What is WHIP/WHEP?
WHIP (WebRTC-HTTP Ingestion Protocol) and WHEP (WebRTC-HTTP Egress Protocol) define signaling protocols for WebRTC, using HTTP requests and responses to transmit signaling data for audio and video stream transmission and processing.

The WHIP protocol is used to negotiate audio and video capabilities using HTTP POST (using SDP Offer/Answer) before establishing the media “upstream” transmission. After successful negotiation, webRTC captures the media through the media capture device, encodes and packages it through the WebRTC API, and finally transmits the media stream to the server.

The WHEP protocol is used to negotiate audio and video capabilities using HTTP POST (using SDP Offer/Answer) before establishing the media “downstream” transmission. After successful negotiation, the streaming media server actively sends audio and video data streams, which are then decoded and played back through the WebRTC API for display on the client.

![whip](./img/whip.png)


## Advantages of WHIP/WHEP
As a standardized signaling protocol for WebRTC, it has the following advantages:

- Simple and easy-to-use: WHIP and WHEP are based on HTTP protocol for transmission. This means that developers can control them through regular interface requests without building private signaling control processes. Therefore, they are very easy to use and integrate.

- Efficient and reliable: Both use WebRTC technology for audio and video encoding/decoding and transmission. This means that they have efficient and reliable performance. Developers can use standard signaling protocols to implement real-time audio and video communication functions without worrying about latency or packet loss.

- Cross-platform support: They can be used on multiple platforms including desktop applications, mobile applications, web applications, etc., which means that developers can implement cross-platform audio and video communication without developing separately for each platform.

- Safe and reliable: Both WHIP and WHEP protocols support encrypted transmission, which means that they can ensure the security and reliability of audio and video data. Developers can use these protocols to implement secure audio and video communication without worrying about data leakage or attacks.

In summary, WHIP/WHEP protocol is a very promising audio/video communication protocol that can make it easier for developers to implement audio/video communication functions. If you are developing an audio/video communication application, then WHIP/WHEP protocol is definitely worth a try.

## TALWTN Product
[TALWTN Product Introduction](./introduction_en.md)
![whip](./img/flow.png)



