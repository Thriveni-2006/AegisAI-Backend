package com.aegisai.repository;

import com.aegisai.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByIsRead(boolean isRead);

    List<Notification> findByType(String type);

}