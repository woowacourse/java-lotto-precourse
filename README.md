# 로또 게임


### 설명
  * 1부터 45까지의 숫자 중 6개를 맞추는 게임입니다.

### 게임 진행 방식
  1. 로또를 구입할 금액을 입력한다.
  2. 로또는 1장당 1000원이며, 구입할 금액만큼의 로또를 구매한다.
  3. 당첨번호 6개를 ","를 기준으로 입력한다.
  4. 보너스 숫자를 입력한다.
  5. 구매한 로또들과 당첨번호를 비교하여, 일치한 개수와 금액을 기준으로 당첨 로또의 개수를 출력한다.

### 프로그램 기능 구현 목록

1. 사용자에게 구매금액을 입력한다.
    * 입력받은 숫자가 올바른지 확인한다.
2. 구매금액으로 살 수 있는 로또의 개수를 구한다.
3. 살 수 있는 로또의 개수만큼 로또를 생성한다.
4. 로또 생성시 숫자 중복을 제거한다.
5. 구매한 로또들을 출력한다.
6. 당첨번호를 입력한다.
    * 6개인지 확인한다.
    * 1~45사이의 숫자인지 확인한다.
    * 중복되는 숫자가 있는지 확인한다.
7. 보너스 번호를 입력한다.
    * 1~45 사이의 숫자인지 확인한다.
    * 당첨번호와 중복되는지 확인한다.
8. 구입한 로또에서 맞은 개수를 확인한다.
9. 맞은 개수를 TreeMap에 저장한다.
10. 수익률을 계산한다.
11. 결과를 출력한다.
