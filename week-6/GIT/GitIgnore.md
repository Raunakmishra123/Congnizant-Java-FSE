touch app.log
mkdir log
touch log/error.log

echo "*.log" >> .gitignore
echo "log/" >> .gitignore

git status
git add .gitignore
git commit -m "add gitignore"
git status