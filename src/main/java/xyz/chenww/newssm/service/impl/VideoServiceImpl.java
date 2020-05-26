package xyz.chenww.newssm.service.impl;

import org.springframework.stereotype.Service;
import xyz.chenww.newssm.domain.Video;
import xyz.chenww.newssm.mapper.VideoMapper;
import xyz.chenww.newssm.service.VideoService;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoMapper videoMapper;

    public VideoServiceImpl(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @Override
    public List<Video> listAll() {
        return videoMapper.listAll();
    }
}
