package requests


// 需要安装插件 HTTP Request 地址：https://plugins.jenkins.io/http_request/ 文档里面有demo


def get(url,headers){
   def resp = httpRequest httpMode: 'GET',
            contentType: 'APPLICATION_JSON',
            ignoreSslErrors: true,
            url: url,
            customHeaders: headers
      return [status: response.status, content: response.content]
}



def post(url,body,headers){
   def resp = httpRequest httpMode: 'POST',
            contentType: 'APPLICATION_JSON',
            ignoreSslErrors: true,
            url: url,
            customHeaders: headers,
            requestBody: body
      return [status: response.status, content: response.content]
}


def put(url,body,headers){
   def resp = httpRequest httpMode: 'POST',
            contentType: 'APPLICATION_JSON',
            ignoreSslErrors: true,
            url: url,
            customHeaders: headers,
            requestBody: body
      return [status: response.status, content: response.content]
}


def delete(url,body,headers){
   def resp = httpRequest httpMode: 'POST',
            contentType: 'APPLICATION_JSON',
            ignoreSslErrors: true,
            url: url,
            customHeaders: headers,
            requestBody: body
      return [status: response.status, content: response.content]
}







