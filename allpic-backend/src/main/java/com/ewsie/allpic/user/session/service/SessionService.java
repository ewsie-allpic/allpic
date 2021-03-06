package com.ewsie.allpic.user.session.service;

import com.ewsie.allpic.user.session.model.Session;

import java.time.LocalDateTime;

public interface SessionService {

    void create(Session session);

    Session findById(Long id);

    Session findByIdentifier(String identifier);

    void remove(Session session);

    void removeOlderThan(LocalDateTime time);

    void removeByIdentifier(String identifier);
}
