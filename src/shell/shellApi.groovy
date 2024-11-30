package shell


def command(cmd) {
    def output = sh(script: cmd, returnStdout: true).trim()
    echo "Output: ${output}"
    return output
}