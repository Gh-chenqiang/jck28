# 作业要求
- 登录 Linux 系统：
  - 学员练习系统：账号密码参考入学须知贴。
   ```bash
    ssh -p22 jck282307@shell.ceshiren.com
   ```
- 完成以下操作
  - 创建新目录。
   ```bash
     创建目录:mkdir abb
     创建递归目录:mkdir -p a/b/c
   ```
  - 切换到新目录下。
   ```bash
    cd abb
   ```
  - 创建新文件，在新文件中添加内容。
   ```bash
    touch 1.txt
    vi 2.txt
    :wq+Enter
   ```
     <img width="200" hight="100" alt="image" src="https://github.com/Gh-chenqiang/schoolwork/assets/83536160/b4ac8920-56c4-424c-a77b-a8241bec7884">

  - 查看新文件中的内容。
   ```bash
    查看文件全部内容:cat 2.txt
    分页查看:less 2.txt
    分页查看:more 2.txt
    查看文件前3行:head -n 3 2.txt
    查看文件尾3行:tail -n 3 2.txt
   ```
   <img width="200" hight="100" alt="image" src="https://github.com/Gh-chenqiang/schoolwork/assets/83536160/6460933f-7155-4ae2-b97d-351d0e061fa5">

  - 修改新文件权限为可读、可写、可执行。
   ```bash
    - 修改文件拥有者可读写执行权限: chmod 400 1.txt 
    - 修改文件拥有者及所属组可写权限: chmod 220 1.txt
    - 修改文件拥有者&所属组&其他人可执行权限: chmod 111 1.txt
    - 修改文件拥有者&所属组&其他人可读写权限: chmod 666 1.txt
    - 修改文件拥有者&所属组&其他人可读写执行权限: chmod 777 1.txt
   ```
  - 查看当前目录。
   ```bash
    ls
    ll -a 
   ```
