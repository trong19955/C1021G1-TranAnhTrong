package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.AppMusic;

import java.util.List;

public interface IAppMusicService {
    List<AppMusic> findAll();

    AppMusic findOne(Long id);

    AppMusic save(AppMusic appMusic);

    List<AppMusic> save(List<AppMusic> appMusics);

    boolean exists(Long id);

    List<AppMusic> findAll(List<Long> id);

    long count();

    void delete(Long id);

    void delete(AppMusic appMusic);

    void delete(List<AppMusic> appMusics);

    void deleteAll();
}
