# blog

使用spring创建demo后台

### mysql配置

安裝mysql 5.+

**创建数据库**

`create database blog;`

**创建新用户**

`create user 'blog'@'localhost' identified by 'blog';`

**对数据库授权用户**

`grant all on blog.* to 'blog'@'localhost'`

**刷新数据库权限**

`flush privileges;`

### gradle 更换国内仓库

在 USER_HOME/.gradle/ 下面创建新文件 init.gradle，输入下面的内容并保存。

```
allprojects{
    repositories {
        def REPOSITORY_URL = 'http://maven.aliyun.com/nexus/content/groups/public/'
        all { ArtifactRepository repo ->
            if(repo instanceof MavenArtifactRepository){
                def url = repo.url.toString()
                if (url.startsWith('https://repo1.maven.org/maven2') || url.startsWith('https://jcenter.bintray.com/')) {
                    project.logger.lifecycle "Repository ${repo.url} replaced by $REPOSITORY_URL."
                    remove repo
                }
            }
        }
        maven {
            url REPOSITORY_URL
        }
    }
}
```

### 端口配置

在resources/application.properties 里配置端口号，这里默认配置8100


### 启动


### 测试

**添加用户**

http://localhost:8100/api/add?name=First&email=someemail@someemailprovider.com

curl -d "email=post@163.com&name=postUser" "http://localhost:8100/api/post/add"

**查询所有用户**

http://localhost:8100/api/all
