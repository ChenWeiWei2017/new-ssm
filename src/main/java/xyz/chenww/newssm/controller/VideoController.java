package xyz.chenww.newssm.controller;

import org.springframework.web.bind.annotation.*;
import xyz.chenww.newssm.domain.Video;
import xyz.chenww.newssm.service.VideoService;
import xyz.chenww.newssm.utils.JsonData;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("list")
    public JsonData list() {
        List<Video> videos = videoService.listAll();
        return JsonData.buildSuccess(videos);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {
        System.out.println(video);
        return JsonData.buildSuccess(null);
    }
}
