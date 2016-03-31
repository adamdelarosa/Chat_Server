package Server.SoundPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

/**
 * Created by ROSA on 3/31/16.
 */
public class WavPlayer {

    public void SoundClip() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/in.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
