package xyz.chenww.newssm.mapper;

import org.springframework.stereotype.Repository;
import xyz.chenww.newssm.domain.Chapter;
import xyz.chenww.newssm.domain.Video;

import java.util.*;

/**
 * 功能描述：模拟DAO层从数据库获取数据的过程
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1, "Java基础课程"));
        videoMap.put(2, new Video(2, "SpringBoot2.X零基础到实战"));
        videoMap.put(3, new Video(3, "微服务SpringCloud全家桶"));
        videoMap.put(4, new Video(4, "SpringBoot实战微信支付课程"));
        List<Chapter> chapters = Arrays.asList(new Chapter(1, "第一章 XXX"), new Chapter(2, "第二章 XXX"));
        Video video5 = new Video(5, "面试专题第一季");
        video5.setChapters(chapters);
        videoMap.put(5, video5);
    }

    /**
     * 获取所有视频信息
     */
    public List<Video> listAll() {
        return new ArrayList<>(videoMap.values());
    }
}
