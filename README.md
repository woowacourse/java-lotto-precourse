# 로또
우아한 테크코스 프리코스 3주차 미션

## 설명
여러장의 로또를 구매하여 당첨 여부와 수익률을 계산하는 프로그램

## 기능 목록
1. 사용자로 부터 구입 금액을 입력 받는다.
2. 구입 금액이 정수인지 검증한다.
3. 구입 금액이 1000원 이상인지 검증한다.
4. 구입 금액으로 구매 할 수 있는 최대 로또 개수를 구한다.
5. 최대 로또 개수만큼 로또를 생성한다.(로또 생성시 1~45사이의 겹치지 않는 랜덤 6개의 정수를 생성한다.)
6. 생성한 수를 출력한다.
7. 당첨 번호를 입력 받는다.
8. 입력 받은 당첨 번호가 1~45 사이의 겹치지 않는 6개의 정수인지 검증한다.
9. 보너스 볼을 입력 받는다.
10. 보너스 볼이 1~45 사이의 정수인지 검증한다.
11. 보너스 볼이 입력 받은 당첨 번호와 겹치지 않는지 검증한다.
12. 각 로또의 당첨 번호, 보너스 볼 일치 여부를 계산하여 등수를 계산한다.
13. 수익률을 계산한다.
14. 당첨 통계를 출력한다.

## 예외 상황
1. 사용자의 구입 금액이 1000원 미만일때 -> 한 장도 구입할 수 없으므로 다시 구입 금액을 입력받는다.
2. 사용자의 구입 금액이 1000원으로 나누어 떨어지지 않는 경우 -> 백의 자리 이하는 버리고 구입 할 수 있는 최대 개수만큼 구입한다.
3. 사용자의 구입 금액이 정수가 아닌 경우 -> 다시 구입 금액을 입력받는다.
4. 로또의 번호가 1~45 사이의 정수가 아닌 경우가 발생하지 않도록 6자리 번호를 생성한다.
5. 로또의 번호가 겹치지 않도록 번호를 생성한다.
6. 당첨번호가 1~45사이의 정수가 아닌 경우 -> 다시 입력받는다.
7. 당첨번호가 겹치는 경우 -> 다시 입력받는다.
8. 보너스 번호가 1~45 사이의 정수가 아닌 경우 -> 다시 입력받는다.
9. 보너스 번호가 당첨번호와 겹치는경우 -> 다시 입력받는다.
