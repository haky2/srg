# Lunch For You
> **_toy project by srg_**

## Basic Structure
<img width="271" alt="srg_LunchForYou_basicStructure" src="https://user-images.githubusercontent.com/35331310/72358063-5064df00-372f-11ea-8997-c3933ccc4a32.png">

## Tech Stack
- SpringBoot 2.2.2
- Vue 4.1.2 (cli)
- Java 11
- MySql 8.0.18

## About Vue.js
- reference : https://mr-spock.tistory.com/3
- resolve `gyp` error : https://velog.io/@noyo0123/TIL-19.12.26

## Create Common Mysql User
```mysql
# srg 계정 생성
create user 'srg'@'localhost' identified by 'tmfprl5$#@!';

# 권한 부여
grant all privileges on *.* to 'srg'@'localhost';
```
