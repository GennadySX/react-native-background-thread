#import "BackgroundThread.h"

@implementation BackgroundThread
RCT_EXPORT_MODULE(BackgroundThread)


RCT_EXPORT_METHOD(runInBackground:(RCTResponseSenderBlock)callback ){

     [self runInBackground_withPriority:@"MAX" secondParameter:callback];
}

RCT_EXPORT_METHOD(runInBackground_withPriority:(NSString*)threadPriority secondParameter:(RCTResponseSenderBlock)callback ){

    NSThread *thread = [[NSThread alloc] initWithTarget:self
                        selector:@selector(runcallback:) object:callback ];

//   MAX for maximum thread priority = 1.0
//   MIN for minimum thread priority = 0.1
//   NORMAL for normal thread priority = 0.5

    if([threadPriority isEqualToString: @"MAX"]){
            [thread setThreadPriority:1.0];
    }
    else if([threadPriority isEqualToString: @"MIN"]){
            [thread setThreadPriority:0.1];
    }
    else if([threadPriority isEqualToString: @"NORMAL"]){
            [thread setThreadPriority:0.5];
    }
    else {
             [thread setThreadPriority:0.5];
    }


    [thread start];
}

-(void) runcallback:(RCTResponseSenderBlock) _callback{
    _callback(@[]);
}
@end



