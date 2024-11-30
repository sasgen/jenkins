package git


def gitCheckout(gitUrl, credentialsId, branch) {
    // 使用 Jenkins 内置的 checkout 步骤从 Git 仓库检出代码
    checkout([
        $class: 'GitSCM',  // 指定使用 Git 作为版本控制系统
        branches: [[name: "${branch}"]],  // 指定要检出的分支名称
        extensions: [],  // 可选参数，用于配置 Git 插件的扩展功能
        userRemoteConfigs: [[
            credentialsId: "${credentialsId}",  // Jenkins 中存储的凭证 ID
            url: "${gitUrl}"  // 仓库的 URL 地址
        ]]
    ])
}

def getGitVersion() {
    // 执行 Git 命令并捕获输出
    def gitVersion = sh(script: 'git log --date=format:"%y%m%d%H%M%S" --pretty=format:"%h-%cd" -1', returnStdout: true).trim()
    return gitVersion
}

def  getShortCommitHash() {
    // 执行 Git 命令并捕获输出
    def shortCommitHash = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
    return shortCommitHash
}
