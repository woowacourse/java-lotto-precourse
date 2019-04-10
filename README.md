# Java-Lotto 구현 기능 목록

사용자로부터 금액을 받아 자동으로 로또를 구입한 후, 당첨 번호와 비교해 수익률을 출력해주는 프로그램입니다. 다음과 같은 방식으로 진행됩니다.  

```markdown
구입금액을 입력해 주세요. 
8000 

8개를 구매했습니다. 
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

지난 주 당첨 번호를 입력해 주세요. 
1,2,3,4,5,6 

보너스 볼을 입력해 주세요. 
7 

당첨 통계 
--------- 
3개 일치 (5000원) - 1개 
4개 일치 (50000원) - 0개 
5개 일치 (1500000원) - 0개 
5개 일치, 보너스 볼 일치(30000000원) - 0개 
6개 일치 (2000000000원) - 0개 
총 수익률은 0.625입니다.  
```
___

### 구입 금액 입력 받기

- 사용자 객체를 생성하면서 구입 금액을 입력 받는다.
- 에러 처리

```markdown
- 정수 입력인지 체크한다.
- 1000원 이상의 수인지 체크한다.
```

### 구입 금액에 따라 로또 구매

- 로또를 판매하는 딜러를 생성한다.
- 사용자 객체에게서 구입 금액을 딜러가 받아 장 수와 잔돈을 구한다.  
- 잔돈이 생긴 경우 잔돈에 대한 안내문을 추가로 출력해준다.  
- 로또를 자동 생성하는 객체에게 장 수 만큼 생성해달라고 요청한다.

### 로또 자동 생성

- 로또 한 장은 1부터 45의 숫자 중 6개의 숫자를 랜덤으로 가진다.
- 로또 숫자는 중복이 생기지 않도록 생성한다.
- 각 로또는 오름차순으로 출력해준다.
- 발권된 로또들을 사용자가 받을 수 있도록 외부로 반환한다.
- 사용자가 받은 로또들을 확인할 때, 한 번에 전부 출력해주기 보다는 한 장 출력할 때마다 약간의 딜레이를 준다.

### 지난주 당첨번호를 입력받기

- 지난주 당첨번호 6개 숫자를 입력받는다.
- 에러 처리

```markdown
- 쉼표(,)로 각 숫자를 구분한다. (쉼표로 각 숫자를 구분한다는 안내문구를 추가한다.)
- 비어있는 입력이 있는지 체크한다. (쉼표가 연속으로 들어왔을 경우)
- 정수 입력인지 체크한다.
- 숫자가 6개인지 체크한다.
- 1부터 45 사이의 숫자들인지 체크한다.
- 중복이 없는지 체크한다.
```

### 보너스볼 입력받기

- 보너스 숫자를 입력받는다. 
- 에러 처리

```markdown
- 정수 입력인지 체크한다.
- 1부터 45 사이의 수인지 체크한다.
- 기존에 입력한 지난주 당첨번호와 중복되지 않는지 체크한다.
```

### 등수 체크

- 각 로또를 당첨번호와 비교해 몇 개의 숫자가 일치하는지 체크한다.
- 보너스볼 일치 여부를 확인한다.
- 맞춘 숫자의 개수와 보너스볼 일치 여부를 가지고 등수를 구한다.

### 당첨 통계

- 구매한 로또들의 등수를 집계해 등수 별로 출력해준다.
- 구입 금액과 총 당첨 금액으로 수익률을 계산해서 출력해준다.
