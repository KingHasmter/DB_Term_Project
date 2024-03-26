
public class Operator { // 메인 메소드를 가지고 있다.
	   Database db = null;
	   swingInsta mf = null;
	   
	   public static void main(String[] args) {
	      Operator opt = new Operator();
	      opt.db = new Database();
	      opt.mf = new swingInsta(opt);
	   }
}