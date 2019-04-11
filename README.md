### 3주차 우아한테크코스 로또 과제

### 기능 구현 목록
	- 사용자
		- 로또 구매 금액을 입력한다. ( INPUT ) O
			- 구매금액이 잘 입력되었는지 검증한다.
				- 1. 1000원 이상의 값이 입력된다. ( Vaild ) O 
				- 2. 문자열이 입력되지 않는다. ( Vaild ) O
				- 3. 음수의 숫자가 입력되지 않는다. ( Vaild ) O
		- 당첨번호를 입력한다 ( INPUT ) O
			- 당첨번호가 잘 입력되었는지 검증한다.
				- 1. 당첨번호는 , 로 구분하고 6개의 입력이 필요하다. ( Vaild )O
				- 2. 당첨번호는 서로 다른 6개의 숫자이다. ( Vaild ) O
				- 3. 당첨번호는 1~45 사이의 값을 갖고 있어야 한다. ( Vaild )O
				- 4. 문자열이 입력되지 않는다. ( Vaild )O
		- 보너스 당첨번호를 입력한다 ( INPUT ) o
			- 보너스 번호가 잘 입력 되었는지 검증한다.
				- 1. 보너스볼의 숫자는 1~45 사이의 값을 갖고 있어야한다. ( Vaild )o
				- 2. 당첨번호와 중복되지 않은 숫자이여야 한다. ( Vaild )o
				- 3. 문자열이 입력되지 않는다. ( Vaild )o
	- 로또게임
		- 임의의 수 6개를 생성한다 ( OUTPUT ) o
			- 임의의 수가  잘 생성되었는지 검증한다.
				- 1. 임의의 수는 1~45 사이의 값을 갖고 있어야 한다. ( Vaild )- 랜덤함수 범위 제한으로 해결 o
				- 2. 각 수들간의 중복값은 없어야 한다.( Vaild ) - Set 컬렉션 함수로 중복제거로 해결 o 
		- 로또의 결과를 출력한다 ( OUTPUT )
			- 구입한 로또와 당첨번호를 비교하여 Rank 를 산출한다.
				- 1. 산출된 Rank를 토대로 총 얻은 금액을 계산한다. ( Math )
				- 2. 구매 금액과 당첨금액을 토대로 수익률을 계산한다. ( Math )
				- 3. 최종 결과를 출력한다. ( OUTPUT )
				
	