# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
```bash
$ Git clone https://github.com/APICe-at-DISI/OOP-git-merge-con
flict-test.git
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 24, done.
remote: Counting objects: 100% (16/16), done.
remote: Compressing objects: 100% (11/11), done.
remote: Total 24 (delta 5), reused 13 (delta 5), pack-reused 8 (from 1)
Receiving objects: 100% (24/24), done.
Resolving deltas: 100% (6/6), done.
$ cd OOP-git-merge-conflict-test
```
2. Ci si assicuri di avere localmente entrambi i branch remoti
```bash
$ git branch -v
* master 2f617a5 switch to Java 25 IO.println
$ git checkout -b feature origin/feature
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'
$ git branch -v
* feature d809d3e switch to Java 25 IO.println
  master  2f617a5 switch to Java 25 IO.println
```
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
```bash
$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.
$ git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
```
4. Si noti che viene generato un **merge conflict**!
```bash
$ git status
On branch master
Your branch is up to date with 'origin/master'.
You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
```
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
```bash
int procNumber() {
	return Runtime.getRuntime().availableProcessors();
}

final String AUTHOR = "Danilo Pianini";

void main() {
	IO.println("This program is running in a PC with " + procNumber() + " logic processors!");
	IO.println("This program has been realised by " + AUTHOR);
}

$ git add HelloWorld.java
$ git commit -m "Resolved merge conflict between master and feature"
[master 4c1a2b3] Resolved merge conflict between master and feature
$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean
```
6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
```bash
$ git remote add myorigin [https://github.com/chunn495/lab06.git](https://github.com/chunn495/lab06.git)
$ git remote -v
myorigin	[https://github.com/chunn495/lab06.git](https://github.com/chunn495/lab06.git) (fetch)
myorigin	[https://github.com/chunn495/lab06.git](https://github.com/chunn495/lab06.git) (push)
origin	[https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git](https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git) (fetch)
origin	[https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git](https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git) (push)
```
8. Si faccia push del branch `master` sul proprio repository
```bash
$ git push myorigin master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 8 threads
Compressing objects: 100% (10/10), done.
Writing objects: 100% (15/15), 2.00 KiB | 2.00 MiB/s, done.
Total 15 (delta 3), reused 15 (delta 3), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (3/3), done.
remote: 
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/chunn495/lab06/pull/new/master
remote: 
To https://github.com/chunn495/lab06.git
 * [new branch]      master -> master
```
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
```bash
$ git branch --set-upstream-to=myorigin/master master
branch 'master' set up to track 'myorigin/master'.
$ git status
On branch master
Your branch is up to date with 'myorigin/master'.
nothing to commit, working tree clean
```
