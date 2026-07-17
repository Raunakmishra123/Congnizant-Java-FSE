git status

git checkout -b GitWork
echo "<root><a>branch value</a></root>" > hello.xml
git add hello.xml
git commit -m "add hello.xml on GitWork"

echo "<root><a>branch updated value</a></root>" > hello.xml
git status
git add hello.xml
git commit -m "update hello.xml on GitWork"

git checkout master
echo "<root><a>master value</a></root>" > hello.xml
git add hello.xml
git commit -m "add hello.xml on master"

git log --oneline --graph --decorate --all
git diff master GitWork
git difftool master GitWork

git merge GitWork
# CONFLICT here — open hello.xml, resolve <<<<<<< ======= >>>>>>> markers
git mergetool

git add hello.xml
git commit -m "resolve merge conflict in hello.xml"

git status
echo "*.bak" >> .gitignore
git add .gitignore
git commit -m "ignore backup files"

git branch -a
git branch -d GitWork
git log --oneline --graph --decorate