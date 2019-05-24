package lab.java.core;

public class MovieTest {
	
	public static void printHeader() {
		System.out.println("================================================================================================================");
		System.out.printf("%-34s%-22s%-23s%-18s%-14s%-12s%-10s\n", "제목", "감독", "장르", "주염", "개봉년도", "런타임", "  등급");
		System.out.println("================================================================================================================");
	}
	
	public static void main(String[] args) {
		
		Movie[] movies = new Movie[4];
		movies[0] = new Movie("반지의 제왕 - 반지 원정대", "피터 잭슨", "판타지, 모험", "일라이저 우드"
				, 2001, 178	, "12세 관람가");
		movies[1] = new Movie("트랜스포머 : 패자의 역습", "마이클 베이", "에스에프, 액션", "샤이아 라보프"
				, 2009, 149);
		movies[2] = new Movie("러브 액츄얼리", "리처드 커티스", "멜로, 드라마", "앨런 릭맨 등"
				,2003, 134, "15세 관람가");
		movies[3] = new Movie("쿵푸 팬더", "마크 오스본", "애니메이션", "잭 블랙", "전체관람가");
		
		
		System.out.println("<< 전체 영화 정보 조회 >>");
		printHeader();
		for(int i = 0; i < movies.length; i++) {
			System.out.println(movies[i].toString());
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------\n");
		
		
		System.out.println("<< 2005년 이전 개봉작 조회 >>");
		printHeader();
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getReleaseYear() <= 2005 && movies[i].getReleaseYear() != 0)
				System.out.println(movies[i].toString());
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------\n");
		
		
		System.out.println("<< 애니메이션 조회 >>");
		printHeader();
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getGenre() != null && movies[i].getGenre().equals("애니메이션"))
				System.out.println(movies[i].toString());
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------\n");
		
		
		System.out.println("<< 런타임 140분 이상 영화 조회>>");
		printHeader();
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].getRunTime() >= 140)
				System.out.println(movies[i].toString());
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------\n");
		
		
	
		

	}

}
