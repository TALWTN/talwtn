//
//  TalWTNLoggerUtil.m
//

#import "TalWTNLoggerUtil.h"

@interface TalWTNLoggerUtil : NSObject

@property (nonatomic, copy) NSString *logPath;
@property (nonatomic, copy) NSString *logFilePath;
@property (nonatomic, strong) dispatch_queue_t queue;
@property (nonatomic, strong) NSFileHandle *fileHanlder;
@property (nonatomic, strong) NSDateFormatter *formatter;

@end

static TalWTNLoggerUtil *logger = nil;

@implementation TalWTNLoggerUtil

+ (instancetype)sharedInstance
{
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        logger = [[self alloc] init];
    });
    return logger;
}

+ (instancetype)allocWithZone:(struct _NSZone *)zone
{
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        logger = [super allocWithZone:zone];
    });
    return logger;
}

- (instancetype)init
{
    self = [super init];
    if (self) {
        [self createLogFile];
    }
    return self;
}

- (void)createLogFile
{
    BOOL dir = YES;
    NSFileManager *manager = [NSFileManager defaultManager];
    if (![manager fileExistsAtPath:self.logFilePath isDirectory:&dir]) {
        [manager createDirectoryAtPath:self.logPath withIntermediateDirectories:YES attributes:nil error:nil];
        [manager createFileAtPath:self.logFilePath contents:nil attributes:nil];
    } else {
        [self writeLog:@"\n\n--------------------------------------------------------------------------------\n\n"];
    }
}

- (void)writeLog:(NSString *)log
{
    dispatch_async(self.queue, ^{
        NSData *data = [log dataUsingEncoding:NSUTF8StringEncoding];
        if (@available(iOS 13, *)) {
            NSError *error;
            [self.fileHanlder seekToEndReturningOffset:nil error:&error];
            if (error) {
                return;
            }
            [self.fileHanlder writeData:data error: &error];
        } else {
            [self.fileHanlder seekToEndOfFile];
            [self.fileHanlder writeData:data];
        }
    });
}

- (void)destroyLogger
{
    if (@available(iOS 13, *)) {
        [_fileHanlder synchronizeAndReturnError:nil];
        [_fileHanlder closeAndReturnError:nil];
    } else {
        [_fileHanlder synchronizeFile];
        [_fileHanlder closeFile];
    }
    _queue = nil;
    _logPath = nil;
    _formatter = nil;
    _logFilePath = nil;
    _fileHanlder = nil;
}

- (dispatch_queue_t)queue
{
    if (!_queue) {
        _queue = dispatch_queue_create("com.omnimk.logger.queue", DISPATCH_QUEUE_SERIAL);
    }
    return _queue;
}

- (NSString *)logPath
{
    if (!_logPath) {
        NSString *path = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES).lastObject;
        _logPath = [NSString stringWithFormat:@"%@/OmniMarionette", path];
    }
    return _logPath;
}

- (NSString *)logFilePath
{
    if (!_logFilePath) {
        NSDateFormatter *fmt = [[NSDateFormatter alloc] init];
        fmt.dateFormat = @"yyyy-MM-dd";
        NSString *date = [fmt stringFromDate:[NSDate date]];
        _logFilePath = [NSString stringWithFormat:@"%@/%@.log", self.logPath, date];
    }
    return _logFilePath;
}

- (NSDateFormatter *)formatter
{
    if (!_formatter) {
        _formatter = [[NSDateFormatter alloc] init];
        [_formatter setLocale:[[NSLocale alloc] initWithLocaleIdentifier:@"zh_CN"]];
        [_formatter setDateFormat:@"yyyy-MM-dd HH:mm:ss.SSS"];
    }
    return _formatter;
}

- (NSFileHandle *)fileHanlder
{
    if (!_fileHanlder) {
        _fileHanlder =  [NSFileHandle fileHandleForWritingAtPath:self.logFilePath];
    }
    return _fileHanlder;
}

@end



void __TalWTNLog(NSString *fileName, NSString *funcName, NSString *fmt, ...)
{
    @try {
        va_list args;
        va_start(args, fmt);
        NSString *dateTime = [[TalWTNLoggerUtil sharedInstance].formatter stringFromDate:[NSDate date]];
        NSString *message = [[NSString alloc] initWithFormat:fmt arguments:args];
        message = [NSString stringWithFormat:@"[%@] %@ %@", dateTime, funcName, message];
        va_end(args);
#if DEBUG
        NSLog(@"%@", message);
#endif
//        NSString *log = [NSString stringWithFormat:@"%@\n", message];
//        BOOL isHeartbeat = [log containsString:@"\"topic\""] && [log containsString:@"\"ApiCall\""];
//        if (!isHeartbeat) {
//            /// 写入文件
//            [[TalWTNLoggerUtil sharedInstance] writeLog:log];
//        }
    } @catch(NSException *e) {
#if DEBUG
        NSLog(@"exception:%@", e.reason);
#endif
    }
}

void __TalWTNLogKill(void)
{
    [[TalWTNLoggerUtil sharedInstance] destroyLogger];
}
