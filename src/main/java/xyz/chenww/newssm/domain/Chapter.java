package xyz.chenww.newssm.domain;

/**
 * 功能描述：章节
 *
 * @author chenweiwei
 * @since 2020/5/22
 */
public class Chapter {

    private Integer id;

    private String title;

    private Integer videoId;

    public Chapter() {}

    public Chapter(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Chapter(Integer id, String title, Integer videoId) {
        this.id = id;
        this.title = title;
        this.videoId = videoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", videoId=" + videoId +
                '}';
    }
}
