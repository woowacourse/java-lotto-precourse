# java-lotto
로또 게임을 하기 위해 클래스, 필드, 메소드 등을 조건에 맞게 구현하는 프로젝트

## 기능목록 (이미 작성된 클래스는 추가한 부분 위주로 작성)
**Lotto 클래스**
* 로또 한 장에 담겨진 번호들을 꺼낸다

**Rank 클래스**
* THIRD에 해당하는 조건을 작성한다

**WinningLotto 클래스**
* 존재 여부를 판단하는 상수를 만든다
* 구매한 로또와 당첨 로또와의 매칭 정도를 판단한다
* 당첨 로또의 특정 인덱스와 구매한 로또의 번호가 같은지 판단한다
* 당첨 로또와 구매한 로또의 번호가 얼마나 같은지 판단한다
* 당첨 로또 번호 중 보너스 숫자와의 일치 여부를 판단한다

**Analzer 클래스**: 수익률을 분석하는 객체
* 매칭 결과를 담기에 적합한 컬렉션을 만든다
* 당첨 통계와 총 수익률을 나타낸다
* 출력할 문장을 랭크 오름차순으로 문자열에 담는다
* 당첨 로또와 구매한 로또들의 매칭 결과를 담는다
* 랭크에 따라 출력할 문장을 반환한다
* 총 수익률을 계산하여 반환한다

**Buyer 클래스**: 로또를 구매하는 객체
* 로또 한 장에 포함되는 숫자의 개수를 의마하는 상수를 만든다
* 로또 숫자들의 한계치에 해당하는 숫자를 상수로 만든다
* 구입금액의 최소치에 해당하는 숫자를 상수로 만든다
* 구입금액 입력이 조건에 맞으면 구매를 완료한다
* 구입금액 입력 예외처리한다
* 구입금액 입력 조건이 맞지 않을 시 다시 입력 요청한다
* 1 ~ 45 사이의 수로 중복없이 랜덤으로 6개의 숫자를 만들고 리스트에 담는다
* 번호를 담은 로또들의 리스트를 만들고 반환한다
* 로또를 구매한 개수와 구매한 로또들의 번호를 보여준다

**Game 클래스**: 로또 게임을 진행하는 클래스
* 로또 한 장의 가격을 의미하는 상수를 만든다
* 구입한 로또들이 담길 리스트를 만든다
* 게임을 진행하는데 있어 필요한 객체들을 선언한다
* 게임을 진행한다 (main 메소드)

**LottoMachine 클래스**: 당첨 번호와 보너스 번호를 만드는 객체
* 로또 숫자들의 최소치에 해당하는 숫자를 상수로 만든다
* 입력받을 보너스 숫자를 변수로 선언한다
* 당첨 번호를 입력하고 조건에 맞으면 발급한다
* 당첨번호 입력에서의 문자, 공백 예외 처리한다
* 입력받은 문장을 번호로 변환하여 리스트에 담는다
* 당첨번호의 중복, 입력 개수, 입력 범위를 처리한다
* 보너스 숫자를 입력하고 조건을 만족할 시 발급한다
* 보너스 숫자와 당첨 숫자들간의 중복을 처리한다
* 보너스 숫자의 입력 범위를 처리한다
* 보너스 숫자 입력 예외 처리한다
* 보너스 숫자 입력 조건이 맞지 않을 시 다시 입력 요청한다