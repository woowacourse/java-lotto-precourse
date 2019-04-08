# 3주차 미션 - 로또 게임

## 기능 요구사항
  - 로또 게임 기능을 구현해야 한다
  - 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다
  - 로또 1장의 가격은 1000원이다
  - 로또 당첨 금액은 고정되어 있는 것으로 가정한다
  - 수익률을 계산해 출력해야 한다

## 로또 게임 규칙
  - 1~45개의 숫자 중에서 6개를 뽑는다
  - 1등 : 당첨번호 6개
  - 2등 : 당첨번호 5개 (보너스 번호 1개 포함)
  - 3등 : 당첨번호 5개
  - 4등 : 당첨번호 4개
  - 5등 : 당첨번호 3개
  
## 기능 목록
  - 사용자가 입력한 구입금액 입력 받는다
  - 구입금액에 대한 예외처리 (숫자가 아닌 입력 값은 재입력)
  - 사용자가 구입한 금액만큼 로또를 생성한다
  - 만들어진 로또를 출력한다
  - 지난 주 당첨 번호를 입력 받는다
  - 입력 받은 당첨번호를 ","로 짜른다
  - 당첨 여부를 비교한다
  - 총 수익률을 계산한다

## 프로그래밍 요구사항 - 객체1
  - 다음 Lotto 객체를 활용해 구현해야 한다
  - Lotto 기본 생성자를 추가할 수 없다.
  - numbers 변수의 접근 제어자인 private을 변경할 수 없다
  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다
  
## 프로그래밍 요구사항 - 객체2
  - 다음 WinningLotto 객체를 활용해 구현해야 한다
  - match() 메소드의 반환 값인 Rank는 저장소에서 제공한다
  - WinningLotto 기본 생성자를 추가할 수 없다
  - lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다
  - WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다
  
