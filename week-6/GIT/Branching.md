git branch GitNewBranch
git branch -a

git checkout GitNewBranch
echo "branch content" > branchfile.txt
git add branchfile.txt
git commit -m "add branchfile on GitNewBranch"
git status

git checkout master
git diff master GitNewBranch

git config --global merge.tool p4merge
git config --global mergetool.p4merge.path "/c/Program Files/Perforce/p4merge.exe"
git difftool master GitNewBranch

git merge GitNewBranch
git log --oneline --graph --decorate

git branch -d GitNewBranch
git status