# 3주차 미션 - 로또
***
## 전제조건
1. 로또 1장의 가격 1000원
2. 당첨 금액 
	* 3개 일치 (5000원)
	* 4개 일치 (50000원)
	* 5개 일치 (1500000원)
	* 5개 일치, 보너스 볼 일치 (30000000원)
	* 6개 일치 (2000000000원)  
  
  
***
##기능 흐름도
1. 입력] 구입 금액을 입력받기
	* 유호성 검사] 입력 금액이 천 원단위인지 확인
	* 유호성 검사] 입력 금액이 마이너스 값 혹은 0이 아닌지 확인
	* 유호성 검사] 입력 금액이 문자인지 확인  

2. 기능] 입력 금액의 구입 개수 산출  

3. 출력] 구입 개수 출력  

4. 기능] 로또 번호 생성
	* 기능] 1~45 사이의 랜덤 수 6개 생성
	* 유효성 검사] 각 번호에 중복이 있는지 확인
	* 기능] 번호 정렬  

5. 출력] 로또 번호 출력  
	
6. 기능] 구입 개수만큼 4번과 5번 반복  
	  
7. 입력] 당첨 번호 입력받기
	* 기능] (,)로 번호 분리하기
	* 유효성 검사] 입력 번호가 6개인지 확인
	* 유효성 검사] 입력 번호가 1~45 사이인지 확인
	* 유호성 검사] 입력 번호가 마이너스 값 혹은 0이 아닌지 확인
	* 유효성 검사] 입력 번호가 문자인지 확인
	* 유효성 검사] 입력 번호가 서로 중복되는지 확인  

8. 입력] 보너스 번호 입력받기	
	* 유효성 검사] 입력 번호가 1개인지 확인
	* 유효성 검사] 입력 번호가 1~45 사이인지 확인
	* 유호성 검사] 입력 번호가 마이너스 값 혹은 0이 아닌지 확인
	* 유효성 검사] 입력 번호가 문자인지 확인
	* 유효성 검사] 입력 번호가 앞서 지정한 6개의 숫자와 중복되는지 확인  

9. 기능] 구매한 로또 번호와 당첨 번호 비교
	* 기능] 번호 비교 후 일치하는 번호의 개수 세기
	* 기능] 일치하는 번호의 개수가 3개 이상이면 몇 등인지 저장하기
	* 기능] 각 로또 비교 (구매 개수만큼 반복)  

10. 기능] 수익률 계산하기
	* 기능] 각 등수별로 저장된 명수를 곱하여 수익 산출하기
	* 기능] 수익률 계산하기 (수익률 = 당첨 금액/구입금액)  

11. 출력] 수익률 출력하기  
