#!/bin/bash

HOME_DIR=$PWD
DIR=$(basename $PWD)-pages
URL=$(git config --get remote.origin.url)

# Delete local branch gh-pages's directory
cd ..
rm -rf $DIR

# Check out gh-pages branch
git clone $URL $DIR

# Clear pages branch history
cd $DIR
PAGES_DIR=$PWD

git checkout --orphan gh-pages
rm -rf .gitignore
rm -rf .gitmodules
rm -rf *

# Create an aar and place it in the gh-pages branch
cd $HOME_DIR
./gradlew -Dorg.gradle.project.repoDir="$PAGES_DIR" uploadArchives

# Commit to the gh-pages branch
cd $PAGES_DIR
git add --all .
git commit -m "Updated at $(date)"

# Push to the gh-pages branch
git push -f origin gh-pages

# Delete the gh-pages directory we used
cd ..
rm -rf $DIR