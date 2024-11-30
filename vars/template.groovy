// 可以直接在pipeline中使用: 文件名 helloWorld("hello world") 使用
def call(params) {
    echo "${params}"
}