git --version
git config --global user.name "your name"
git config --global user.email "your email"
git config --global --list
# notepad++ as default editor (after adding notepad++ to PATH)
notepad++.exe
alias notepad++="'/c/Program Files/Notepad++/notepad++.exe'"
git config --global core.editor "notepad++.exe -multiInst -notabbar -nosession -noPlugin"
git config --global -e
git init GitDemo
cd GitDemo
ls -la
echo "welcome to git" > welcome.txt
cat welcome.txt
git status
git add welcome.txt
git commit
git status
git remote add origin <gitlab-repo-url>
git pull origin master
git push origin master