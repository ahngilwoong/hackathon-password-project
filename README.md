# 보안 거북이 / 안전한 비밀번호 관리 웹 개발 프로젝트 PCW

* ### 팀 소개
  * 인제대학교 안길웅
  * 안동대학교 임수빈
  * 전북대학교 이유정
  * 동명대학교 김재원
  * 안동대학교 천효민




## 프로젝트 배경 및 목표
간혹 비밀번호 변경 안내를 받고 수정을 하면 이전 비밀번호와 유사한 번호,
아이디어와 4자리수 이상 중복, 등 수정을 하기 어려워지는 상황에 
짧은 변경 주기로 각 페이지마다 원하는 조건(대문자, 특수문자, 자리수)이 
있어 모든 페이지에 대해 비밀번호를 기억하고 관리하기 어렵습니다.
따라서 안전한 비밀번호 관리 웹의 필요성을 느껴 프로젝트를 시작하였습니다.
이 프로젝트로 각 도메인 별 필요한 양식에 맞춘 암호문을 만들어 
기억하기 쉽고 안전한 패스워드를 제공하는 것이 프로젝트의 목표입니다.



## 개발 환경
* Spring Boot
* MYSQL AND JPA 방식
* View Template => ThymeLeaf
* 디자인



## 프로젝트 동작 순서
1. 사용자의 정보(이름, 생년월일 등)을 받고 현재 시간등을 조합하여 AES의 input값이 될 평문을 만듭니다.
2. 암호화 과정 중 키는 개발자가 따로 사용자 별 key 관리 서버를 만들어 관리합니다.
3. 사용자 별 KEY를 통해 사용자는 언제든지 평문을 암호화 및 복호화 할 수 있습니다.
4. 사용자는 만들어진 암호문을 통해 도메인별로 생성된 암호를 password로 사용하여 안전하게 비밀번호를 관리합니다.


