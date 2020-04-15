# Transaction Project
## Overview
I was assigned this particular project to implement a basic transaction formula using React
and any kind of technology that would express my skillset. I used Scala, ReactJS (of course), PostgreSQL and Play Framework. There were two main things that I had to accomplished in order to call it a minimium viable product: correctly implement the transaction formula and calculate the total amount per month (in a 3 month cycle) per customer. In hindsight, I probably shouldn't have done a full-stack but it was pretty cool to do something hands on again.

## Set up
1. Install Scala, ReactJS, and PostgreSQL
   1. Luckily for me, I'm using Linux so alot of the things were updated and were easily applied afterwards.
   2. Intellij basically took care of Scala for me but PostgreSQL and Pgadmin to a degree were a pain to install and set up.
   3. npm install to set up the frontend side of things
2. Setting up the database
   1. `sudo -u postgres psql --command "CREATE USER scalauser WITH SUPERUSER\
PASSWORD 'scalapass';"`
    2. `sudo -u postgres createdb -O scalauser scaladb`
    3. _Warning_ - You might need to change your auth from peer to md5 depending on your set up but that's what I experienced
3. Running the application - at the base of the project directory
   1. In one terminal window, run `sbt run` for the backend service
   2. In another, run `npm run watch` for the frontend service
   3. ideally, if you ran the database set up commands, the server should technically be up but i would double check

## Project
### Transaction View or Raw Data in a way
![Transaction](photos/transaction.png)