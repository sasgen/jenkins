package salt

def execCmd(cmd){
    def result = sh(script: "salt ${cmd}", returnStdout: true).trim()
    retrun result
}