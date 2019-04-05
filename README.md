# 구현할 기능 목록
1. 로또 숫자 난수를 만들어야 한다.
2. 구입 금액 입력에서 1000의 배수인지 체크 해야 한다.
    1. 만약에 8500원이면, 8장 팔고 500원을 남겨야 하나? 아니면 사용자 입력 오류 처리 해야 하나?
    2. 음수일 경우 체크 해야 한다.
    3. 입력이 숫자가 아닐 경우
3. 수익률 계산
    1. 판매량 계산
    2. 당첨금 계산
4. 지난 주 당첨 번호 입력을 받아야 한다.
    1. 입력을 받고 로또 번호 비교를 해야 한다.
    2. 당첨된 경우에는 수익률 계산에 포함되어야 하므로...
    3. 당첨번호 입력이 잘못되었을 경우
        1. 로또 숫자 limit 넘어간 숫자 입력
        2. 음수 입력
        3. "," 이후 미 입력
        4. 숫자가 아닌 입력 (특수문자 등)
    4. 보너스 볼 입력이 잘못 되었을 경우
        1. 위와 동일한 예외 처리
5. 당첨 통계 출력
    1. 최종 결과를 출력한다.

### 2주차 피드백
* 기능 목록 구현을 재검토 해라
* 값을 하드코딩 하지 마라 - 상수를 사용할 것
* 클래스 구현 순서를 지킬 것
* 객체에 메세지를 보내라
* 필드 수를 줄이기 위해 노력해라
* 발생 할 수 있는 예외 케이스에 대해 고민 해라
* UTF-8 인코딩


### 기능 요구 사항
* 로또 게임 기능을 구현해야 한다.규칙을 모르면 검색해 로또 규칙을 찾아본다.
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
* 수익률을 계산해 출력해야 한다.


### 프로그래밍 요구 사항 - 객체1
* 다음 Lotto 객체를 활용해 구현해야 한다.
* Lotto 기본생성자를 추가할 수 없다.
* numbers 변수의 접근 제어자인 private을 변경할 수 없다.
* Lotto 에 필드(인스턴스변수)를 추가할 수 없다.

### 프로그래밍 요구 사항 - 객체2
* 다음 WinningLotto 객체를 활용해 구현해야 한다.
* match() 메소드의 반환 값인 Rank는 저장소에서 제공한다.
* WinningLotto 기본 생성자를 추가할 수 없다.
* lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다.
* WinningLotto 에 필드(인스턴스변수)를 추가할 수 없다.

### 프로그래밍 요구 사항 - 1,2주차와 동일
* 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
* 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* public/protected/private/package 접근제어자를 용도에 적합하게 사용해 구현한다.

### 프로그래밍 요구 사항 - 3주차 변경 및 추가
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
* 함수(또는메소드)가 한 가지 일만 잘 하도록 구현한다.
* indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 최대한 1을 유지하기 위해 노력하고, 정말 힘든 경우 2까지 허용한다.
* 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 함수(또는메소드)의 인자수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.