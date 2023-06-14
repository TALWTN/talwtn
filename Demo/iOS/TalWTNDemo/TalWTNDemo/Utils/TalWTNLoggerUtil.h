//
//  OmniMKLoggerUtil.h
//  OmniMarionetteKit
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

extern void __TalWTNLogKill(void);
extern void __TalWTNLog(NSString *fileName, NSString *funcName, NSString *fmt, ...);
#define TalWTNFileName [NSString stringWithFormat:@"%s", __FILE__].lastPathComponent
#define TalWTNLog(...) { \
    NSString *funcName = [NSString stringWithUTF8String:__func__]; \
    __TalWTNLog(TalWTNFileName, funcName, ##__VA_ARGS__); \
};
#define TalWTNLogKill  __TalWTNLogKill()

NS_ASSUME_NONNULL_END
