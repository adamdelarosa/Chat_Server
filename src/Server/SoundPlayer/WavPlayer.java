package Server.SoundPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

/**
 * Created by ROSA on 3/31/16.
 */

public class WavPlayer {

    public void SoundClipSwitch() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/switch.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipMessageIn() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/getMessage.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipMessageOut() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/sendMessage.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipConnectionStatusStart() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/connectionStatusStart.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipConnectionStatusEnd() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/connectionStatusEnd.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipConnectionOnline() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/connectionStart.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SoundClipConnectionOffline() {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("Server/Sound/connectionEnd.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
