# 로또

## 1. 구현목록
- 금액 입력
  - 자연수만 입력 가능
- 금액에 따른 로또 구매 개수 계산
  - 자연수만 입력 가능
  - 1,000원 단위에서 내림
- 무작위 로또 (정렬)
  - 로또가 1개 이상일 경우만 (0개 -> 종료)
- 지난 주 당첨 번호 입력
  - 1~45사이의 중복된 값이 없어야 함
- 보너스 볼 입력
  - 입력한 당첨 번호에 포함되지 않는 숫자여야 함
- 당첨 결과 출력(금액 format 설정)
- 수익률 계산(%)

## 2. 프로그래밍 요구사항
### 2.1. 객체
- Lotto 객체를 활용하여 구현
  - 필드(인스턴스 변수)를 추가할 수 없다.
- WinningLotto 객체를 활용하여 구현
  - 필드(인스턴스 변수)를 추가할 수 없다.
  - match()메소드의 반환 값인 Rank는 저장소에서 제공

### 2.2. 자바 코드 컨벤션
- 참고 : https://google.github.io/styleguide/javaguide.html, https://myeonguni.tistory.com/1596
- indent depth를 3이 넘지 않도록 구현한다. (2까지만 허용)
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게

### 2.3. 추가 사항
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는메소드)가 한 가지 일만 잘 하도록 구현한다.
- indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. (1까지만허용한다.)
  - 최대한 1을 유지하기 위해 노력하고, 정말 힘든 경우 2까지 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는메소드)의 인자수를 3개까지만 허용한다. (4개이상은허용하지않는다.)

## 3. 참고
- 미션 저장소 : https://github.com/woowacourse/java-lotto
