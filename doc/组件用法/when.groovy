#!groovy
// 相等判断 (expression):
when {
    expression { return env.BRANCH_NAME == 'master' }
}

// 分支匹配 (branch):
when {
    branch 'master'
}

// 环境变量存在 (environment):
when {
    environment name: 'DEBUG', value: 'true'
}

// 变化检测 (changeset):
when {
    changeset 'src/main/java/**/*.java'
}

// 组合条件 (and, or, not):
when {
    allOf {
        branch 'master'
        environment name: 'DEBUG', value: 'true'
    }
}

when {
    anyOf {
        branch 'master'
        branch 'develop'
    }
}

when {
    not {
        branch 'feature/*'
    }
}


// 实例 when 指令应该放在 stage 的内部
pipeline {
    agent any

    stages {
        stage('Initialize') {
            steps {
                script {
                    env.BRANCH_NAME = 'main'
                    env.BUILD_TYPE = 'release'
                }
            }
        }

        stage('Build') {
            when {
                expression { return env.BRANCH_NAME == 'main' }
            }
            steps {
                echo 'Building the project...'
            }
        }

        stage('Test') {
            when {
                expression { return env.BRANCH_NAME == 'main' && env.BUILD_TYPE == 'release' }
            }
            steps {
                echo 'Running tests...'
            }
        }

        stage('Deploy') {
            when {
                expression { return env.BRANCH_NAME == 'main' && env.BUILD_TYPE == 'release' }
            }
            steps {
                echo 'Deploying the application...'
            }
        }

        stage('Notify') {
            when {
                expression { return env.BRANCH_NAME == 'main' }
            }
            steps {
                echo 'Notifying stakeholders...'
            }
        }
    }
}