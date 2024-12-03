package s3

// 需要安装插件 Pipeline: AWS Steps 地址 https://plugins.jenkins.io/pipeline-aws/#plugin-content-s3upload

// 上传文件
def upload(endpointUrl,credentials,bucket,file,path){
    withAWS(endpointUrl:endpointUrl,credentials:credentials){
        s3Upload(file:file, bucket:bucket, path:path)
    }
}

// 下载文件
def download(endpointUrl,credentials,bucket,file,path){
    withAWS(endpointUrl:endpointUrl,credentials:credentials){
         s3Download(file:file, bucket:bucket, path:path, force:true)
    }
}
