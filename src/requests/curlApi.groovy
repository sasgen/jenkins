package requests

def curl(cmd){
    def out =  sh(script: cmd, returnStdout: true).trim()
    return out
}