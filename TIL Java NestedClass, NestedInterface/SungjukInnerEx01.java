public class SungjukInnerEx01 {
	public static void main(String args[]) {
		SungjukInner sungjuk = new SungjukInner();
		sungjuk.addSungjuk();
		System.out.println();
		sungjuk.addSungjuk();
		System.out.println();
		SungjukInner.Sungjuk obj = sungjuk.new Sungjuk();
		obj.input();
		obj.process();
		sungjuk.list.add(obj);
		System.out.println();
        printCart(sungjuk);
    }
	
    static void printCart(SungjukInner sungjuk) {      
        int num = sungjuk.getSungjukNum();
        System.out.println("             *** 성적표 ***");
		System.out.println("=======================================");
		System.out.println("학번     이름    국어     영어     수학     총점     평균    등급");
		System.out.println("=======================================");        
        for (int cnt = 0; cnt < num; cnt++) {
        	SungjukInner.Sungjuk obj = sungjuk.getSungjuk(cnt);
        	obj.output();
        }
        System.out.println("=======================================");
		System.out.printf("\t 총학생수 : %d, 전체 평균 : %5.2f\n\n",
				sungjuk.getSungjukNum(), 
				sungjuk.getTotalAvg()/sungjuk.getSungjukNum());
    }
}
