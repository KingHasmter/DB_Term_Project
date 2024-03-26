
import java.sql.*;

public class Database {
   Connection con = null;
   Statement stmt = null;
   String url = "jdbc:mysql://localhost/instagram?serverTimezone=Asia/Seoul";   //db연동을 위한 ID, password 
   String user = "root";
   String passwd = "12345";      
   
   Database() {   //데이터베이스에 연결한다.
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection(url, user, passwd);
         stmt = con.createStatement();
         System.out.println("MySQL server connect succcess");
      } catch(Exception e) {
         System.out.println("MySQL server connect failed > " + e.toString());
      }
   }

   // 로그인 정보를 확인한다.
   boolean logincheck(String checkId, String checkPw) {
      boolean flag = false;
      
      String id = checkId;
      String pw = checkPw;
      
      try {
         String checkingStr = "SELECT PW FROM account WHERE ID='" + id + "'";
         ResultSet result = stmt.executeQuery(checkingStr);
         
         int count = 0;
         while(result.next()) {
            if(pw.equals(result.getString("PW"))) {
               flag = true;
               System.out.println("login success");
            }
            
            else {
               flag = false;
               System.out.println("login failed");
            }
            count++;
         }
      } catch(Exception e) {
         flag = false;
         System.out.println("login failed > " + e.toString());
      }
      
      return flag;
   }
   
   String getProfile(String user_id) {
	   try {
	         String checkingStr = "SELECT profile FROM user WHERE ID='" + user_id + "'";
	         ResultSet result = stmt.executeQuery(checkingStr);
	         
	         if (result.next()) {
	             System.out.println(result.getString("profile"));
	             return result.getString("profile");
	         } 
	         else {
	             System.out.println("No profile found for user_id: " + user_id);
	         }
	         
	         System.out.println(result.getString("image"));
	         return result.getString("image");
	         }
	   catch(Exception e){
		   System.out.println("login failed > " + e.toString());
	   }
	   return "";
   }
   
   String getFeedImg(String user_id) {
	   
	   String URL = "https://jikhaeng.kr/assets/common/img/user/default_photo.jpg";
	   
	   if(user_id.equals("no user"))
		   return URL;
	   
	   try {
	         String checkingStr = "SELECT image FROM article WHERE ID='" + user_id + "' ORDER BY article_time desc";
	         ResultSet result = stmt.executeQuery(checkingStr);
	         
	         if (result.next()) {
	        	 URL = result.getString("image");
	             System.out.println(URL);
	             return URL;
	         }
	         else {
	             System.out.println("No image found for user_id: " + user_id);
	         }
	         
	   }
	   catch(Exception e){
		   System.out.println("login failed > " + e.toString());
	   }
	   return URL;
   }
   
   String[] getFollowingID(String user_id) {
	   int i = 0;
	   String[] Followers = {"no user","no user","no user","no user","no user","no user"};
	   try {
		   String checkingStr = "SELECT object_id FROM following WHERE ID='" + user_id + "'";
		    ResultSet result = stmt.executeQuery(checkingStr);

		    while (result.next()) {
		        Followers[i] = result.getString("object_id");
		        System.out.println("Followers : " + Followers[i] + "\n");
		        if (i == 5)
		            break;
		        i++;
		    }

		    return Followers;
	   }
	   
	   catch(Exception e){
		   System.out.println("login failed > " + e.toString());
	   }
	   return Followers;
   }
}