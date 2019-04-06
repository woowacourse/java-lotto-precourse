package com.github.seokhyeonchoi.game.lotto;

import java.util.EnumMap;
import java.util.List;

import com.github.seokhyeonchoi.util.io.IOUtil;

import static com.github.seokhyeonchoi.game.lotto.Constant.*;

/**
 * 결과계산 및 출력 class
 */
public class User {
	
	private EnumMap<Rank, Integer> rankMap;
	private long revenue;
	private double roi;
	
	public User(List<Lotto> lottoTickets, WinningLotto winningLotto) {
		initMap();
		mapRank(lottoTickets, winningLotto);
		calculateRevenue();
		calculateROI(lottoTickets.size());
	}
	
	private void initMap() {
		rankMap = new EnumMap<>(Rank.class);
		
		for(Rank rank : Rank.values()) {
			rankMap.put(rank, 0);
		}
	}
	
	private void mapRank(List<Lotto> lottoTickets, WinningLotto winningLotto) {
		for(Lotto lottoTicket : lottoTickets) {
			Rank rank = winningLotto.match(lottoTicket);
			rankMap.put(rank, rankMap.get(rank) + 1);
		}
	}
	
	private void calculateRevenue() {
		long revenue = 0;
		
		for(Rank rank : Rank.values()) {
			revenue += rankMap.get(rank) * rank.getWinningMoney();
		}
		
		this.revenue = revenue;
	}
	
	private void calculateROI(int ticketSize) {
		this.roi = (double)this.revenue / (ticketSize * ONE_TICKET_AMOUNT);
	}
	
	public void printResult() {
		IOUtil.writeln();
		IOUtil.writeln(WINNING_STATISTICS_MESSAGE);
		IOUtil.writeln(LINE_DIVIDE_MESSAGE);
		for(Rank rank: Rank.values()) {
			printRank(rank);
		}
		printROI();
	}
	
	private void printRank(Rank rank) {
		if(rank == Rank.MISS) {
			return;
		}
		IOUtil.write(rank.getCountOfMatch());
		IOUtil.write(NUMBEROF_MESSAGE);
		IOUtil.write(MATCH_NUMS_MESSAGE);
		if(rank == Rank.SECOND) {
			IOUtil.write(MATCH_BONUS_MESSAGE);
		}
		IOUtil.write(OPEN_BRACKET_MESSAGE);
		IOUtil.write(rank.getWinningMoney());
		IOUtil.write(CLOSE_BRACKET_MESSAGE);
		IOUtil.write(rankMap.get(rank));
		IOUtil.writeln(NUMBEROF_MESSAGE);
	}
	
	private void printROI() {
		IOUtil.write(ROI_MESSAGE_PREFIX);
		IOUtil.writef("%.3f", roi);
		IOUtil.writeln(ROI_MESSAGE_SUFFIX);
	}
}
