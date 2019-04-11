### Lotto
- 로또 1장당 1000원
- 구입 금액 입력
  - 음수 입력시 다시 입력
- Lotto 구입
  - 구입금액 / 1000 만큼 구입
  - 몇개 구매했는지 출력
  - Lotto 번호 출력
    - 중복을 허용하지 않고 1 ~ 45 중 6개의 숫자 생성 및 출력
    - 생성한 번호로 Lotto object 생성 후 myLotto에 저장
- 당첨번호 입력
  - 입력을 콤마(,)로 구분
  - 1 ~ 45 사이의 자연수 확인
  - 6개 숫자 확인
  - 중복 확인
  - 보너스 숫자입력
    - 자연수 하나 입력
    - 1 ~ 45 사이의 자연수 확인
    - 당첨 번호와 중복 여부 확인
- 당첨 규칙
  - 구입한 Lotto 번호와 당첨 번호와 비교
    - 보너스 번호는 당첨 번호와 5개 일치할 때 비교
  - 일치 횟수에 따라 당첨 등급이 달라짐
    - 0 ~ 2개 : 없음
    - 3개 : 5,000원
    - 4개 : 50,000원
    - 5개 : 1,500,000원
    - 5개 + 보너스 번호 1개 : 30,000,000원
    - 6개 : 2,000,000,000원
- 당첨 통계
  - 당첨 결과로 각 등급의 갯수를 구함
  - 등급마다 당첨 갯수와 금액을 출력
  - 마지막에 수익률(= 총 당첨금액 / 구매금액)을 출력

### class 설명
각 class에 대한 성격을 정의하고 그에 맞는 method로 구성
- Lotto.java
  - Lotto
    - 로또 한 장을 의미
    - 1 ~ 45 사이의 자연수, 크기가 6인 List
- PlayLotto.java
  - PlayLotto
    - Lotto game을 구현
    - 구입 금액 입력
    - Lotto 구매
    - 당첨 번호 입력
    - 당첨 결과 출력
  - ValidLottoNumber
    - 당첨 번호 입력 시 규칙을 만족하는 지 검사
  - ValidBonusNumber
    - 보너스 번호 입력 시 규칙을 만족하는 지 검사
- WinningLotto.java
  - WinningLotto
    - 당첨 번호
    - 구매한 Lotto와 당첨 번호를 비교
- Rank.java
  - Rank
    - Lotto 등수
- Utils.java
  - Utils
    - 위 class들과 성격에 맞지 않는 기능을 모아둠
- Main.java
  - Main
    - Lotto game 실행