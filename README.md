# 3주차 미션 - 로또

## 기능

### Main -> getTrials() 

구매금액을 입력받아 수행횟수를 얻어내는 메소드.
금액이 모자라거나, 맞지 않을 경우에 대한 예외처리가 필요함.


### WinningLotto -> Match()

입력받은 로또와 우승 번호를 매칭시키는 메소드.
매칭된 수로 적절한 Rank를 반환

### Main -> buyMultipleLotto()

입력된 횟수만큼 로또 구매를 반복하는 메소드.

### Main -> buyLotto()

로또를 구매하는 메소드. Random 번호를 생성하여 Lotto를 생성한다.

### Main -> getWinningLotto()

인자를 입력받아 당첨에 해당하는 Lotto를 생성하는 메소드.

### Main -> printResult()

매칭결과를 계산하여 그것을 출력해주는 메소드.