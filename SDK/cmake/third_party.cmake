cmake_minimum_required(VERSION 3.10.0)

# add third party
add_subdirectory(${TALWTN_ROOT_DIR}/third_party/boost_1_69_0 boost_1_69_0)

# third party libs dir
if (RTC_PLATFORM_IOS.cache)
    set(THIRD_PARTY_COMMON_PREFIX ${TALWTN_ROOT_DIR}/third_party/webrtc/ios)
    target_include_directories(${TARGET_NAME} PRIVATE
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/sdk/objc
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/sdk/objc/base
            )
    target_link_directories(${TARGET_NAME} PRIVATE ${THIRD_PARTY_COMMON_PREFIX})
elseif (RTC_PLATFORM_ANDROID.cache)
    set(THIRD_PARTY_COMMON_PREFIX ${TALWTN_ROOT_DIR}/third_party/webrtc/android/${ANDROID_ABI})
    target_include_directories(${TARGET_NAME} PRIVATE
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/out/Release/gen
            )
    if (${CMAKE_VERSION} VERSION_GREATER "3.13.0")
        target_link_directories(${TARGET_NAME} PRIVATE ${THIRD_PARTY_COMMON_PREFIX})
    endif()
endif ()

# third party include
target_include_directories(${TARGET_NAME} PRIVATE ${BOOST_INCLUDE_DIRS})
target_include_directories(${TARGET_NAME} PRIVATE
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/third_party/abseil-cpp
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/third_party/boringssl/src/include/
            ${TALWTN_ROOT_DIR}/third_party/webrtc/headers/third_party/libyuv/include/
            )

# link 3rd libs
if (RTC_PLATFORM_IOS.cache)
    target_link_libraries(${TARGET_NAME} PUBLIC ${THIRD_PARTY_COMMON_PREFIX}/libwebrtc.a)
elseif (RTC_PLATFORM_ANDROID.cache)
    target_link_libraries(${TARGET_NAME} PUBLIC -Wl,--whole-archive  ${THIRD_PARTY_COMMON_PREFIX}/libwebrtc.a -Wl,--no-whole-archive)
endif ()