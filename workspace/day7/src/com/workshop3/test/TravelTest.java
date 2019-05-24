package com.workshop3.test;

import com.workshop3.biz.TravelBiz;
import com.workshop3.entity.Travel;
import com.workshop3.util.TravelUtil;

public class TravelTest {
	
	public static void printMenu() {
		System.out.println("======= <메뉴> =======");
		System.out.println("1. 전체 여행 상품 조회");
		System.out.println("2. 개별 자유여행 상품 조회");
		System.out.println("3. 패키기여행 상품 조회");
		System.out.println("4. 여행 상품 예약");
		System.out.println("9. 종료");
		System.out.println("=====================");
	}

	public static void main(String[] args) {
		
		TravelBiz biz = new TravelBiz();
		
		int nMenu = 0;
		String sCode;
		int nReserve;
		Travel travel;
		
		while(true) {
			printMenu();
			System.out.print("## 메뉴 입력 : ");
			nMenu = Integer.parseInt(TravelUtil.getUserInput());
			
			switch(nMenu) {
			case 1:
				biz.printTravelListTitle();
				biz.printAllTravels();
				break;
				
			case 2:
				biz.printTravelListTitle();
				biz.printIndividualTravels();
				break;
				
			case 3:
				biz.printTravelListTitle();
				biz.printPackageTravels();
				break;
				
			case 4:
				System.out.println("여행 상품을 예약합니다.");
				System.out.print("여행 코드 입력 : ");
				sCode = TravelUtil.getUserInput();
				System.out.print("예약 인원 입력 : ");
				nReserve = Integer.parseInt(TravelUtil.getUserInput());
				travel = biz.reserveTravel(sCode, nReserve);
				if(travel != null) {
					System.out.println("예약이 완료 되었습니다.");
					biz.printTravelListTitle();
					travel.printTravelInfo();
					System.out.println("-----------------------------------------------------------------------------------");
				}
				break;
				
			case 9:
				System.out.println("프로그램을 종료합니다. Bye ~ Bye ~");
				System.exit(0);
				break;
				
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
				continue;
			}
		}
		

	}

}
