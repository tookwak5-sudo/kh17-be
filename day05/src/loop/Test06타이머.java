package loop;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class Test06타이머 {
	public static void main(String[] args) {
		//입력
		int min = 0;
		int sec = 2;
		//처리
		int time = min* 60 + sec;
		
		//출력
		try {
			for(int i = 0; i<=time; time--) {
				
				min = time/60;
				sec = time % 60;
				System.out.println(min + "분" +sec + "초 후에 알람이 울립니다."); 	
				Thread.sleep(1000);
			}
				System.out.println("시간이 다 되었습니다. 음악 재생!");
				
				// 2. 음악 파일 재생 (wav 파일 권장)
	            playMusic("blackbird.wav");
	            
		}catch (InterruptedException e) {
            e.printStackTrace();
		}					
	}
	public static void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // 음악이 재생되는 동안 프로그램이 바로 종료되지 않도록 대기
            System.out.println("재생 중... 종료하려면 Enter를 누르세요.");
            System.in.read(); 
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("오류: 음악 파일을 찾을 수 없거나 재생할 수 없습니다.");
            e.printStackTrace();
        }
    }
}

