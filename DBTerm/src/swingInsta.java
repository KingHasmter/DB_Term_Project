
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class swingInsta extends JFrame{

   JPanel basePanel = new JPanel(new BorderLayout());
   JPanel centerPanel = new JPanel(new BorderLayout());
   JPanel westPanel = new JPanel();
   JPanel eastPanel = new JPanel();
   JPanel southPanel = new JPanel();
   JPanel northPanel = new JPanel();

   // TextField 
   JTextField id = new JTextField("ID");
   JPasswordField pw = new JPasswordField("PW");
   
   // Button 
   JButton loginBtn = new JButton("LOGIN");
   
   Operator o = null;
   
   swingInsta(Operator object1){  // GUI 크기, 특징 설정
      o = object1;
      
      //창 이름
      setTitle("instagram");
      
      // Panel 크기
      centerPanel.setPreferredSize(new Dimension(260, 80));
      westPanel.setPreferredSize(new Dimension(210, 75));
      northPanel.setPreferredSize(new Dimension(210, 30));
      // Label 
      JLabel name = new JLabel("instagram");

      
      // TextField 크기(ID, 비번 입력창 크기)
      id.setPreferredSize(new Dimension(200, 30));
      pw.setPreferredSize(new Dimension(200, 30));
      
      // Button 크기
      loginBtn.setPreferredSize(new Dimension(200, 30));
      
      // Panel 추가
      setContentPane(basePanel);   //panel을 기본 컨테이너로 설정
      
      basePanel.add(centerPanel, BorderLayout.CENTER);
      centerPanel.add(westPanel, BorderLayout.CENTER);
      centerPanel.add(northPanel, BorderLayout.NORTH);
      
      westPanel.setLayout(new FlowLayout());
      eastPanel.setLayout(new FlowLayout());
      
      // westPanel 컴포넌트 
      westPanel.add(id);
      westPanel.add(pw);
      westPanel.add(loginBtn);
      
      // northPanel 컴포넌트
      northPanel.add(name);
      
      // Button 이벤트 리스너 추가
      ButtonListener bl = new ButtonListener();
      
      loginBtn.addActionListener(bl);

      setSize(310, 200);
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   private void OpenMainScreen(String user_id, String profile_image) throws MalformedURLException {
	   basePanel.removeAll();
	   
	   JFrame frame = new JFrame("instagram");
       frame.setSize(300, 500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panel = new JPanel(new GridBagLayout());
       frame.setContentPane(panel);

       // 컴포넌트 생성
       JButton button1 = new JButton("");
       JButton button2 = new JButton("Follow");
       JLabel id = new JLabel(user_id);
       JLabel feedLabel = new JLabel("FEED");
       
       String[] FollowingID = o.db.getFollowingID(user_id);
       
       JLabel id1 = new JLabel(FollowingID[0]);
       JLabel id2 = new JLabel(FollowingID[1]);
       JLabel id3 = new JLabel(FollowingID[2]);
       JLabel id4 = new JLabel(FollowingID[3]);
       JLabel id5 = new JLabel(FollowingID[4]);
       JLabel id6 = new JLabel(FollowingID[5]);
       
       // 프로필 이미지를 표시할 JLabel 생성
       ImageIcon profile = new ImageIcon(new URL(profile_image));
       Image profileimage = profile.getImage(); // 이미지 가져오기
       Image newImg = profileimage.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       profile = new ImageIcon(newImg);  // 새로운 이미지로 ImageIcon 만들기
       JLabel profileLabel = new JLabel(profile);
       
       
       
       //첫 번째 피드 사진
       ImageIcon FeedImg1 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[0])));
       Image FeedImg1image = FeedImg1.getImage(); // 이미지 가져오기
       Image newFeedImg1 = FeedImg1image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg1 = new ImageIcon(newFeedImg1);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel1 = new JLabel(FeedImg1);
       
       //두 번째 피드 사진
       ImageIcon FeedImg2 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[1])));
       Image FeedImg2image = FeedImg2.getImage(); // 이미지 가져오기
       Image newFeedImg2 = FeedImg2image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg2 = new ImageIcon(newFeedImg2);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel2 = new JLabel(FeedImg2);

       //세 번째 피드 사진
       ImageIcon FeedImg3 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[2])));
       Image FeedImg3image = FeedImg3.getImage(); // 이미지 가져오기
       Image newFeedImg3 = FeedImg3image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg3 = new ImageIcon(newFeedImg3);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel3 = new JLabel(FeedImg3);
       
       //네 번째 피드 사진
       ImageIcon FeedImg4 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[3])));
       Image FeedImg4image = FeedImg4.getImage(); // 이미지 가져오기
       Image newFeedImg4 = FeedImg4image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg4 = new ImageIcon(newFeedImg4);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel4 = new JLabel(FeedImg4);
       
       //다섯 번째 피드 사진
       ImageIcon FeedImg5 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[4])));
       Image FeedImg5image = FeedImg5.getImage(); // 이미지 가져오기
       Image newFeedImg5 = FeedImg5image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg5 = new ImageIcon(newFeedImg5);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel5 = new JLabel(FeedImg5);
       
       //여섯 번째 피드 사진
       ImageIcon FeedImg6 = new ImageIcon(new URL(o.db.getFeedImg(FollowingID[5])));
       Image FeedImg6image = FeedImg6.getImage(); // 이미지 가져오기
       Image newFeedImg6 = FeedImg6image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // 원하는 크기로 조절
       FeedImg6 = new ImageIcon(newFeedImg6);  // 새로운 이미지로 ImageIcon 만들기
       JLabel FeedLabel6 = new JLabel(FeedImg6);
      
       // GridBagConstraints 생성
       GridBagConstraints constraints = new GridBagConstraints();
       
       constraints.gridx = 1;
       constraints.gridy = 1;
       panel.add(id, constraints);
       Font font = id.getFont();
       id.setFont(new Font(font.getName(), Font.PLAIN, 20)); // 20은 폰트 크기
       
       // 이미지
       constraints.gridx = 1;
       constraints.gridy = 0;
       constraints.weightx = 1;
       panel.add(profileLabel, constraints);
       
       // 첫 번째 버튼(납작하게 만들어 선처럼 보이게 만듦)
       constraints.gridx = 1;
       constraints.gridy = 2;
       Dimension button1Size = new Dimension(90, 1);
       button1.setPreferredSize(button1Size);
       panel.add(button1, constraints);
       
       // 비어있는 열
       constraints.gridx = 1;
       constraints.gridy = 3;
       panel.add(new JPanel(), constraints);
       
       // 두 번째 버튼
       constraints.gridx = 1;
       constraints.gridy = 4;
       Dimension button2Size = new Dimension(90, 30);
       button2.setPreferredSize(button2Size);
       panel.add(button2, constraints);
       
       // 비어있는 열
       constraints.gridx = 1;
       constraints.gridy = 5;
       constraints.weightx = 1.0; // 추가된 열이 빈 공간을 차지하도록 설정
       panel.add(new JPanel(), constraints);
       
       //FEED 레이블
       constraints.gridx = 1;
       constraints.gridy = 6;
       constraints.weightx = 2;
       panel.add(feedLabel, constraints);
       
       //피드 이미지 1
       constraints.gridx = 0;
       constraints.gridy = 7;
       constraints.weightx = 1;
       panel.add(FeedLabel1, constraints);
       
       //id1 레이블
       constraints.gridx = 0;
       constraints.gridy = 8;
       panel.add(id1, constraints);
       
       //피드 이미지 2
       constraints.gridx = 1;
       constraints.gridy = 7;
       constraints.weightx = 1;
       panel.add(FeedLabel2, constraints);
       
       //id2 레이블
       constraints.gridx = 1;
       constraints.gridy = 8;
       panel.add(id2, constraints);
       
       //피드 이미지 3
       constraints.gridx = 2;
       constraints.gridy = 7;
       constraints.weightx = 1;
       panel.add(FeedLabel3, constraints);
       
       //id3 레이블
       constraints.gridx = 2;
       constraints.gridy = 8;
       panel.add(id3, constraints);
       
       //피드 이미지 4
       constraints.gridx = 0;
       constraints.gridy = 9;
       constraints.weightx = 1;
       panel.add(FeedLabel4, constraints);
       
       //id4 레이블
       constraints.gridx = 0;
       constraints.gridy = 10;
       panel.add(id4, constraints);
       
       //피드 이미지 5
       constraints.gridx = 1;
       constraints.gridy = 9;
       constraints.weightx = 1;
       panel.add(FeedLabel5, constraints);
       
       //id5 레이블
       constraints.gridx = 1;
       constraints.gridy = 10;
       panel.add(id5, constraints);
       
       //피드 이미지 6
       constraints.gridx = 2;
       constraints.gridy = 9;
       constraints.weightx = 1;
       panel.add(FeedLabel6, constraints);
       
       //id6 레이블
       constraints.gridx = 2;
       constraints.gridy = 10;
       panel.add(id6, constraints);

       // JFrame을 화면에 표시
       frame.setVisible(true);
	}
   
   /* Button 이벤트 리스너 */
   class ButtonListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         JButton b = (JButton)e.getSource();
         
         /* TextField에 입력된 아이디와 비밀번호를 변수에 초기화 */
         String uid = id.getText();
         String upass = "";
         for(int i=0; i<pw.getPassword().length; i++) {
            upass = upass + pw.getPassword()[i];
         }
         
         
         /* 로그인 버튼 이벤트 */
         if(b.getText().equals("LOGIN")) {
            if(uid.equals("") || upass.equals("")) {
               JOptionPane.showMessageDialog(null, "Enter both ID and PW", "login failed", JOptionPane.ERROR_MESSAGE);
               System.out.println("login failed > not entered");
            }
            
            else if(uid != null && upass != null) {
               if(o.db.logincheck(uid, upass)) {   //이 부분이 데이터베이스에 접속해 로그인 정보를 확인하는 부분이다.
                  System.out.println("login success");
                  JOptionPane.showMessageDialog(null, "success login");
                  
                  //로그인 화면 끄기
                  dispose();
                  
                  //새로운 창 열기
                  try {
					OpenMainScreen(uid, o.db.getProfile(uid));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}       //이 안에 sql 정보 받아와서 적을 예정
                  

               } else {
                  System.out.println("login failed > not matched");
                  JOptionPane.showMessageDialog(null, "failed login");
               }
            }
         }
      }
   }
}
