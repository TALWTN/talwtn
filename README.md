# TalWTN

> For English version, See [TalWTN](README_en.md).

## 概述

[TAL-WTN引擎 WebRTC 传输网络](https://www.magic-school.com/docs/6752/122560)（TAL WebRTC Transmission Network，简写 WTN）构建于可支撑亿级 DAU 的全球实时传输网络之上，可以提供全球范围内高质量、低延时的实时音视频通信能力。

通过接入 WTN，你可以实现丰富多彩的实时音视频应用。

## 服务端 API

WTN 提供了基于 WebRTC 标准信令交互协议的 HTTP 接口。你可以通过这些接口，完成 Offer/Answer SDP 交换，使用 WebRTC JavaScript/Native 原生库完成 WTN 媒体服务建连。建连后，你可以发布/订阅音视频流。

关于这些 API 的详细信息，请与我们联系。

## 社区版 SDK

WTN 提供了基于 [WHIP](https://datatracker.ietf.org/doc/draft-ietf-wish-whip/)/[WHEP](https://datatracker.ietf.org/doc/draft-murillo-whep/) 的 HTTP API 和 WebRTC 开源库封装的社区版 SDK。你可以集成此 SDK，在客户端接入 WTN，实现音视频流发布订阅功能。

社区版 SDK 仅封装了发布订阅流和少量音视频设备功能控制的能力。你也可以参考社区版 SDK 的实现，自行封装 SDK，实现在客户端接入 WTN 的能力。

| 平台 | 项目工程 | 编译 SDK | API 文档 |
| --- | --- | --- | --- |
| Android | [Android](SDK/sdk/android/) | [编译 SDK](SDK/doc/en/Build_Instruction.md) | [API 文档](SDK/doc/en/Android/overview.md) |
| iOS | [iOS](SDK/sdk/ios/) | [编译 SDK](SDK/doc/en/Build_Instruction.md) | [API 文档](SDK/doc/en/iOS/overview.md) |

## 示例 Demo

WTN 也提供了 Android， iOS，和 Web 平台的 Demo 项目和 OBS 插件。
你可以参考 Demo 项目，了解在对应平台的应用中集成社区版 SDK 的方式；也可以使用 OBS 插件，实现直播等功能。参考对应文档进行试用：

| 平台 | 跑通 Demo 文档 |
| --- | --- |
| Android | [跑通 Android Demo 文档](./Demo/Android/README.md) |
| iOS | [跑通 iOS Demo 文档](./Demo/iOS/README.md) |

