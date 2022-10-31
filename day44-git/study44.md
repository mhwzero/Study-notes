# git本地仓库创建
## 基本操作指令

### 查看修改状态
    查看的修改的状态(暂存区，工作区)
    git status
### 添加工作区到暂存区
    添加工作区一个或者多个文件的修改到暂存区
    git add .
    git add 指定文件夹/文件
### 提交暂存区到本地仓库
    添加暂存区内容到本地仓库的当前分支
    git commit -m "注释内容"
### 查看日志
    在c盘用户目录下配置了.bashrc文件(.开头的全是隐藏文件)下配置一下别名,相当于在git中只需要输入键值就可以了，
    git log [option]
- options
    - --all  显示所有分支
    - --pretty=oneline 将提交信息显示为一行
    - --abbrev-commit  使得输出的commitId更简短
    - --graph  以图的形式显示
```markdown
#用于输出git提交日志
alias git-log='git log --pretty=oneline --all --graph --abbrev-commit'
#用于输出当前目录所有文件及基本信息
alias ll='ls -al'
```
### 撤销未提交的已编辑内容
    撤销提交的，已编辑的内容，回退到本地仓库最后一下提交时的状态
    git restore 文件名
### 版本回退
    git reset --hard commitID其中commitID可以使用git-log或者git log或者git reflog来查看
    注意的时这个撤销会将制定ID后面的操作全部撤销掉
### 撤销版本
    git revent
    撤销前一次提交：git revert HEAD
    撤销某一下提交：git revert commitID
## 分支
### 查看所有分支
    git branch
### 创建本地分支
    一定是在当前分支的基础上创建了一个新的分支
    git branch 分支名
### 切换分支
    git checkout 分支名
### 切换分支并创建
    git checkout -b 分支名
### 合并分支(merge)
    git merge 分支名称
### 删除分支
    git branch -d 分支名 删除分支时，需要做各种检查
    git branch -D 分支名 不做任何检查，强制删除
### 解决冲突
    当两个分支对文件的修改可能存在冲突，如同时修改了同一行，这时候需要手动去解决冲突
1. 处理文件冲突的地方
2. 将处理完冲突的文件加入暂存区(add)
3. 提交到仓库(commit)
```markdown
这个过程中,对于同一文件，A和B进行修改，A先提交，那么B提交的时候会发冲突，这时候B要解决这个冲突，解决冲突的方法是在B的冲突文件中会有提示，
只需要将A的修改代码和B的修改代码放一起，将文件中git的提示删除，重新提交即可
```
```markdown
<<<<<< A
count=1        这是A的代码
==========
count=2        这是B的代码
>>>>>> B
```
```markdown
修改后的代码
count=1
count=2
```
## git远程仓库
### 生成秘钥
- ssh-keygen -t rsa  -C "邮箱地址"
- -C 可省略，一般写开发人员的邮箱地址。
- 一直回车
  - 如果公钥已经存在，则自动覆盖
  
### 获取秘钥
    cat ~/.ssh/id_rsa.pub
### 验证是否匹配成功
    ssh -T git地址
### 添加远程仓库
- git remote add <远端名称>  <仓库路径>
  - 远端名称，默认是origin，取决于远端服务器设置
  - 仓库路径，从远端服务器获取此URL
  - 例如: git remote add origin  git远程仓库ssh地址
### 从远程仓库进行克隆
    git clone <仓库地址>[本地目录]
    这里本地目录可以省略，他会自己创建一个目录(这里自动生成的目录就是远程仓库的名字)
### 查看远程仓库
    git remote
### 推送远程仓库
- git push [-f] [--set-upstream][远端名称][本地分支名][远端分支名]
  - 如果远程分支名和本地分支名称相同，则可以只写本地分支
      - git push origin master
    - -f  表示强制覆盖
    - `--set-upstream` 推送到远端的同时并且建立起和远端分支的关联关系。
      - `git push  --set-upstream origin 本地分支名:指定远端分支名`
    - 如果**当前分支已经和远端分支相同的时候**，则可以省略分支名和远端名。
    - git push    将master分支推送到已关联的远端分支。
### 从远程仓库抓取
+ 抓取 命令：git fetch [remote name] [branch name]

  + **抓取指令就是将仓库里的更新都抓取到本地，不会进行合并**

+ 如果不指定远端名称和分支名，则抓取所有分支。

  **注意：如果把远端分支合并到本地，需要使用git merge origin/master**

+ 拉取 命令：git pull [remote name] [branch name]

  + **拉取指令就是将远端仓库的修改拉到本地并自动进行合并，等同于fetch+merge**
  + 如果不指定远端名称和分支名，则抓取所有并更新当前分支。