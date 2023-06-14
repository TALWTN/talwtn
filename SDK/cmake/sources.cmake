# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.0)

set(COMMON_SOURCES
        ${TALWTN_ROOT_DIR}/src/wtn_engine.h
        ${TALWTN_ROOT_DIR}/src/wtn_engine.cc
        ${TALWTN_ROOT_DIR}/src/wtn_interface.h
        ${TALWTN_ROOT_DIR}/src/wtn_publisher_impl.h
        ${TALWTN_ROOT_DIR}/src/wtn_publisher_impl.cc
        ${TALWTN_ROOT_DIR}/src/wtn_stats_callback.h
        ${TALWTN_ROOT_DIR}/src/wtn_stats_callback.cc 
        ${TALWTN_ROOT_DIR}/src/wtn_subscriber_impl.h
        ${TALWTN_ROOT_DIR}/src/wtn_subscriber_impl.cc
        ${TALWTN_ROOT_DIR}/src/wtn_webrtc_wrapper.h
        ${TALWTN_ROOT_DIR}/src/wtn_webrtc_wrapper.cc
        ${TALWTN_ROOT_DIR}/src/wtn_event_handler.h
        ${TALWTN_ROOT_DIR}/src/wtn_event_handler.cc

        ${TALWTN_ROOT_DIR}/src/utils/http_client.h
        ${TALWTN_ROOT_DIR}/src/utils/http_client.cc
        ${TALWTN_ROOT_DIR}/src/utils/whip_client.h
        ${TALWTN_ROOT_DIR}/src/utils/whip_client.cc
        
        ${TALWTN_ROOT_DIR}/src/external_module/external_audio_device_module.h
        ${TALWTN_ROOT_DIR}/src/external_module/external_audio_device_module.cc
        ${TALWTN_ROOT_DIR}/src/external_module/external_video_source.h
        ${TALWTN_ROOT_DIR}/src/external_module/external_video_source.cc
        ${TALWTN_ROOT_DIR}/src/external_module/fake_decoder.h
        ${TALWTN_ROOT_DIR}/src/external_module/fake_decoder.cc
        ${TALWTN_ROOT_DIR}/src/external_module/fake_encoder.h
        ${TALWTN_ROOT_DIR}/src/external_module/fake_encoder.cc
        ${TALWTN_ROOT_DIR}/src/external_module/video_sink_proxy.h
        ${TALWTN_ROOT_DIR}/src/external_module/video_sink_proxy.cc
        )
 
if (RTC_PLATFORM_IOS.cache)
    set(SDK_SOURCES_PREFIX ${TALWTN_ROOT_DIR}/sdk/ios)
    set(SDK_SOURCES
        ${SDK_SOURCES_PREFIX}/TALWTNDefines.h
        ${SDK_SOURCES_PREFIX}/TALWTNEngine.h
        ${SDK_SOURCES_PREFIX}/TALWTNEngine.mm
        ${SDK_SOURCES_PREFIX}/TALWTNEventHandler.h
        ${SDK_SOURCES_PREFIX}/TALWTNEventHandler.mm
        ${SDK_SOURCES_PREFIX}/TALWTNPublisher.h
        ${SDK_SOURCES_PREFIX}/TALWTNPublisher.mm
        ${SDK_SOURCES_PREFIX}/TALWTNSubscriber.h
        ${SDK_SOURCES_PREFIX}/TALWTNSubscriber.mm
        ${SDK_SOURCES_PREFIX}/TALWTNPubSubInternal.h

        ${TALWTN_ROOT_DIR}/src/platform/objc_platform_helper.h
        ${TALWTN_ROOT_DIR}/src/platform/objc_platform_helper.mm
        )
elseif (RTC_PLATFORM_ANDROID.cache)
    set(SDK_SOURCES_PREFIX ${TALWTN_ROOT_DIR}/sdk/android/talwtn/src/main/jni)
    set(SDK_SOURCES
        ${SDK_SOURCES_PREFIX}/jni_onload.cc
        ${SDK_SOURCES_PREFIX}/talwtn_jni_common.h
        ${SDK_SOURCES_PREFIX}/native_functions_jni.cc
        ${SDK_SOURCES_PREFIX}/rtc_event_handler_jni.h
        ${SDK_SOURCES_PREFIX}/rtc_event_handler_jni.cc
        ${TALWTN_ROOT_DIR}/src/platform/android_platform_helper.h
        ${TALWTN_ROOT_DIR}/src/platform/android_platform_helper.cc
        )
endif()

set(SOURCES ${COMMON_SOURCES} ${SDK_SOURCES} ${PLATFORM_SOURCES})

# group the source files
foreach (file ${SOURCES})
    file(RELATIVE_PATH relative_file "${TALWTN_ROOT_DIR}" ${file})
    get_filename_component(dir "${relative_file}" PATH)
    if (NOT "${dir}" STREQUAL "")
        string(REPLACE "/" "\\" dir ${dir})
        source_group("${dir}" FILES ${file})
    endif ()
endforeach ()
