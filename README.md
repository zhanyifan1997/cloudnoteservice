# cloudnoteservice
## SmartMesh CloudNoteService 基于SmartMesh光谱链的云笔记项目

### 遇到的难题
  1. 之前尝试过用nodejs来完成这个项目，但是一旦交易费大于0时，就会报gas不足的情况，即使你的账户里的钱足够，所以最后不了了之，选择了其他语言来完成这个项目
  2. 在进行用java的web3j进行操作光谱链之前，尝试着用java web3j操作过以太坊节点，发i西安并没有问题，但是在进行操作光谱链时，会一直会报一个无效的交易哈希的错误，最后经过社区的指导和自己的钻研下，发现了时chainId不匹配的问题，经过尝试，最终解决了光谱链无法进行交易的问题。详细的教程在：https://www.jianshu.com/p/e70b50783e8b
  
### 如何运行这个项目
  1.首先，创建cloudnote数据库，运行clounote.sql文件，创建数据库
  2.这个项目有springboot编写，所以你只需要下载之后，用IntelliJ IDEA open这个文件夹，启动maven的自动导包，maven就会自动帮你把所依赖的jar包下载完成，最后，你只需要修改EtherUtil中的响应钱包地址及钱包密码，找到src 下的 CloudnoteserviceApplication这个类，右键run，即可启动这个后台。

### 项目截图

#### 授权登陆
![image](https://github.com/zhanyifan1997/cloudnoteservice/blob/master/images/%E6%8E%88%E6%9D%83%E7%99%BB%E9%99%86.png)


#### 添加笔记
![image](https://github.com/zhanyifan1997/cloudnoteservice/blob/master/images/%E6%B7%BB%E5%8A%A0%E7%AC%94%E8%AE%B0%E9%A1%B5%E9%9D%A2.png)


#### 查询笔记

![image](https://github.com/zhanyifan1997/cloudnoteservice/blob/master/images/%E6%9F%A5%E8%AF%A2%E7%AC%94%E8%AE%B0%E9%A1%B5%E9%9D%A2.png)


#### 查询自己的笔记

![image](https://github.com/zhanyifan1997/cloudnoteservice/blob/master/images/%E6%9F%A5%E8%AF%A2%E8%87%AA%E5%B7%B1%E7%9A%84%E7%AC%94%E8%AE%B0.png)


#### 个人主页

![image](https://github.com/zhanyifan1997/cloudnoteservice/blob/master/images/%E4%B8%AA%E4%BA%BA%E9%A1%B5%E9%9D%A2.png)

