# 3주차 미션 - 로또 게임

> 여러 개의 클래스를 분리한 후 서로 관계를 맺어 하나의 프로그램을 완성하는 것이 목표 !

## 기능 요구사항
* 로또 게임 기능 구현
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
* 로또 1장의 가격은 1000원
* 로또 당첨 금액은 고정
* 수익률을 계산해 출력

## 프로그래밍 요구사항

### 객체 1, Lotto 객체
* ***기본 생성자를 추가할 수 없다.***
* ***numbers 변수의 접근 제어자인 private을 변경할 수 없다.***
* ***Lotto에 필드(인스턴스 변수)를 추가할 수 없다.***

### 객체 2, WinningLotto 객체를 활용해 구현해야 한다.
* ***match() 메소드의 반환 값인 Rank는 저장소에서 제공한다.***
* ***WinningLotto 기본 생성자를 추가할 수 없다.***
* ***lotto, bonusNo 변수의 접근 제어자인 private를 변경할 수 없다.***
* ***WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.***

### 3주차 변경 및 추가
* 함수(또는 메소드)의 길이가 **10라인**을 넘어가지 않도록 구현한다.
* Indent depth 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 함수(또는 메소드)인자 수를 3개까지만 허용한다.

## 기능 구현 목록
1. 구입 금액을 입력받는 함수
2. 구입 금액에 맞게 번호를 생성하는 함수
3. 생성된 각 로또를 프린트하는 함수
4. 지난 주 당첨 번호를 입력받는 함수
5. 보너스 볼을 입력받는 함수
6. 당첨번호와 보너스 볼을 통해 각 게임별 결과를 저장하는 함수
7. 당첨 결과를 출력하는 함수
8. 총 수익률을 계산하는 함수