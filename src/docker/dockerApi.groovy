package docker

/**
* 登录到 Docker 注册表。
* 
* @param credentialsId Jenkins 凭证管理中的凭证 ID
*/
def login(credentialsId){
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
        sh " docker login -u username --password-stdin ${registry}"
    }
}

/**
* 构建 Docker 镜像。
* 
* @param image 镜像名称
* @param tag 镜像标签
* @param dockerFile Dockerfile 的路径，默认为当前目录下的 Dockerfile
*/
def build(image,tag,dockerFile="Dockerfile") {
    dockerImage = image
    dockerTag = tag
    sh "docker build -t ${image}:${tag} -f ${dockerFile} ."
}


/**
* 标记 Docker 镜像。
* 
* @param old_image_tag 原始镜像标签
* @param new_image_tag 新的镜像标签
*/
def tag(old_image_tag,new_image_tag){
    sh "docker tag ${old_image_tag} ${new_image_tag}"
}


/**
* 推送 Docker 镜像到注册表。
* 
* @param image 镜像名称
* @param tag 镜像标签
*/
def push(image,tag) {
    sh "docker push ${image}:${tag}"
}


/**
* 删除 Docker 镜像。
* 
* @param image_id 要删除的镜像 ID
*/
def rmi(image_id){
    sh "docker rmi -f ${image_id}"
}

/**
* 从 Docker 注册表注销。
*/
def logout() {
    sh "docker logout"
}
