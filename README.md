# UPSTAC

### API Requirements and Goals
- Implement the Lab Results and Consultation Feature in the UPSTAC API application. In order to implement this, follow the instructions given below:

- With respect to the Tester, complete the code in 'LabRequestController' class and 'LabResultService' class to view the open test requests, assign the tests to themselves and finally update the test results.
- With respect to the Doctor, complete the code in ‘ConsultationController’ class and 'ConsultationService' class to view the pending test results, assign consultations to themselves and update the doctor suggestions.

###  Setup locally


#### UPSTAC Backend
The backend code runs simply by running the ‘UpstacApplication.java’ file.

#### UPSTAC-UI 

```sh
$ cd upstac-ui
$ npm install -g yarn
$ yarn install
$ yarn clean cache
$ yarn start
```
https://github.com/sidlinux22/UPSTAC/blob/master/upstac-ui/README.md

#### MYSQL

```sh
$ docker network create dev-network-upstac
$ docker run --restart always --name mysql8.0 --net dev-network-upstac -v /Desktop/UPSTAC/UPSTAC/mysql/mysql_data/8.0:/var/lib/mysql -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=password mysql:8.0
```

--------------------------------
Note: To manually authorisation of the tester on DB please update status to 1
```
UPDATE `upgradpg`.`user` SET `status` = '1' WHERE (`id` = '8');
```
