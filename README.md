# Towers-of-Hanoi
A scala implementation of the famous recursion exercize. More information on the Towers of Hanoi and the recursive problem they impose can be found [here](https://en.wikipedia.org/wiki/Tower_of_Hanoi)

# Synopsis
after cloneing from the repo you'll need to compile:

```scalac  -sourcepath src -d classes src/com/seefurst/towersofhanoi/app/TowersOfHanoi.scala```

which will create a new folder `classes` within the checkout. From there you can run it thusly:

```scala -cp classes com.seefurst.towersofhanoi.app.TowersOfHanoi n``` 

where `n` is the number of disks you can start out with. Usually people use 3 but there is no default ATM.

This project was compiled and run using scala 2.12.3. Please post compilation and runtime issues with other versions in the *issues* section.

### This is currently a work in progress.
