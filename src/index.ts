import { NativeModules } from 'react-native';
const { BackgroundThread } = NativeModules;


export enum BackgroundThreadPriority {
  min = "MIN",
  max = "MAX",
  normal = "NORMAL"
}



const RunInBackgroundW = (callback: () => void | Function, priority?: BackgroundThreadPriority) => {

  if (priority) {
    BackgroundThread.runInBackground_withPriority(priority,()=>{
      callback()
    })
  }  else {
    BackgroundThread.runInBackground(()=>{
      callback()
    })
  }
}



export default RunInBackgroundW;
