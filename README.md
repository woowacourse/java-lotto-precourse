# 로또 

> 우아한 테크 코스 :: 온라인 과제 3주차

&nbsp;

## 기능 요구사항

- 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
- 수익률을 계산해 출력해야 한다.

&nbsp;

## 프로그래밍 요구사항

### Lotto.java

- Lotto 객체를 활용해 구현해야 한다.
    + Lotto 기본 생성자를 추가할 수 없다.
    + numbers 변수의 접근 제어자인 private을 변경할 수 없다.
    + Lotto에 필드를 추가할 수 없다.

### WinningLotto.java

- WinningLotto 객체를 활용해 구현해야 한다.
    + match() 메소드의 반환값인 Rank는 저장소에서 제공한다.
    + WinningLotto 기본 생성자를 추가할 수 없다.
    + lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다.
    + WinningLotto에 필드를 추가할 수 없다.

### 1, 2주차와 동일

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    + 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    + 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    + else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.

### 3주차 변경 및 추가

- 함수(또는 메소드)의 길이가 **10라인**을 넘어가지 않도록 구현한다.
    + 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- indent(인덴트, 들여쓰가) depth를 **2**가 넘어가지 않도록 구현한다. **1**까지만 허용한다.
    + 최대한 1을 유지하기 위해 노력하고, 정말 힘든 경우 2까지 허용한다.
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는 메소드)의 인자 수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.

## 커스텀 요구사항

- 수익률 출력은 4자리에서 반올림하여 3자리 까지만 출력한다. 
    + 예: 2000 / 3000 => 0.667

&nbsp;

## 기능

- 로또 구입 금액 입력하기
- 로또 구매하기
    + 로또 생성하기
- 구매한 로또 출력하기
- 로또 당첨 번호 입력하기
- 로또 당첨 개수 출력하기
    + 로또 당첨 개수 구하기
- 수익률 출력
    + 수익률 구하기
        * 로또 당첨 금액 구하기


