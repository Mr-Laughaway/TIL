package com.lg.workshop2.lotto.test;

import com.lg.workshop2.lotto.Lotto;

public class TestLotto {

	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		
		int[] lottoNumbers = lotto.getnerateLottoNumbers();
		lotto.sortLottoNumbers(lottoNumbers);
		lotto.displayLottoNumbers(lottoNumbers);
	}

}
