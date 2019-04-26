# SpringCloud-hanlp-dependencyParse 依存句法分析服务测试

句法分析实现参照：https://github.com/hankcs/HanLP

步骤：
# 方法一（指定data数据包本地路径）：

在eclipse中导入maven项目后，

先启动注册中心，即运行AppEureka.java（浏览器地址栏测试：http://localhost:8800

再注册服务，即运行AppDependencyParse.java

浏览器地址栏输入：http://localhost:8801/swagger-ui.html 点击Try it out按钮，输入句子即可测试。

Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。

总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。

作用：
    1. 接口的文档在线自动生成。
    2. 功能测试。

由于data数据包大小超过500M，建议自行下载，该项目中data数据包版本为1.7.2。

data数据包下载地址：https://github.com/hankcs/HanLP/releases 注意版本对应，具体查看pom.xml文件；

将data下载好放在本地后，指定路径给HanLP，data的根目录路径配置写在resources文件夹下的hanlp.properties。

# 方法二：

若使用方法一，得在配置文件中指定data数据包的本地路径，若需要更改词典，则不能用maven直接导入仓库里的包。

为了方便的修改词典或模型，避免配置里写了路径也提示找不到词典文件的情况，

参照了https://blog.csdn.net/wolfblood_zzx/article/details/78164868 博客中的做法，重写了IOAdapter类，便于将data数据跟整个项目打包到一起，可以直接用maven导入。（这样只需要下载data数据包放在resources下，不需要指定本地路径。）
