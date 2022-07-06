$commitLog = Read-Host "请输入提交日志"
git add *
git status
Pause

git pull origin master
Pause

git commit -m $commitLog
git push origin master
Pause

git branch -M main
git config user.name "Sallee1"
git push origin_hb main
Pause

git branch -M master
git config user.name "Sallee_admin"