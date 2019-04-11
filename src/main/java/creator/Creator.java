/*
 *@(#)Creator.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package creator;

import object.LottoNumber;

/**
 * 로또와 관련 된 번호들을 생성하는 인터페이스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public interface Creator extends LottoNumber {
        public LottoNumber create();
}
