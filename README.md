-class Lotto

    -showNumbers() : 로또 번호 반환

-class LottoGame

    -run() : 전체 게임의 진행을 위한 메서드
    -getRanks() : 총 로또의 순위를 가져옴
    -getThePriceOfLotto() : 구매한 로또 금액을 입력받음
    -initLottoArrayList() : 랜덤으로 생성한 로또를 ArrayList로 구현하기 위해 각각을 초기화하는 메서드
    -initLotto() : 로또 번호 생성
    -showLottoNum() : 로또 번호 출력
    -getWinLotto() : WinningLotto를 초기화
    -setWinLotto() : 당첨 번호를 Lotto 객체에 저장
    -printRanks() : 당첨 개수를 출력
    -countRank() : 몇등 로또가 몇개인지 세는 메서드
    -setMap() : countRank에서 쓰이는 Map 초기화
    -printEarningRate() : 수익률 출력

-class WinningLotto

    -match() : hashset을 이용해 각 번호가 당첨번호와 얼만큼 맞는지 계산