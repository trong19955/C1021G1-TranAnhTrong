package cg.wbd.grandemonstration.model;

import javax.persistence.*;

@Entity
@Table
public class AppMusic implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameSinger;
    private String kingOfMusic;
    private String link;

    public AppMusic() {
    }

    public AppMusic(String name, String nameSinger, String kingOfMusic, String link) {
        this.name = name;
        this.nameSinger = nameSinger;
        this.kingOfMusic = kingOfMusic;
        this.link = link;
    }

    public AppMusic(Long id, String name, String nameSinger, String kingOfMusic, String link) {
        this.id = id;
        this.name = name;
        this.nameSinger = nameSinger;
        this.kingOfMusic = kingOfMusic;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getKingOfMusic() {
        return kingOfMusic;
    }

    public void setKingOfMusic(String kingOfMusic) {
        this.kingOfMusic = kingOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public AppMusic clone(){
        AppMusic appMusic = new AppMusic();
        appMusic.setId(id);
        appMusic.setName(name);
        appMusic.setNameSinger(nameSinger);
        appMusic.setKingOfMusic(kingOfMusic);
        appMusic.setLink(link);
        return appMusic;
    }

    @Override
    public String toString() {
        return "AppMusic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameSinger='" + nameSinger + '\'' +
                ", kingOfMusic='" + kingOfMusic + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
