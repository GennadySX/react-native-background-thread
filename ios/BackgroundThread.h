//
//  BackgroundThread.h
//
//  Created by Gennady Sabirovsky on 08.08.2022.
//  Copyright © 2022 Facebook. All rights reserved.
//

#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif
#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface BackgroundThread : NSObject <RCTBridgeModule>

@end

NS_ASSUME_NONNULL_END
