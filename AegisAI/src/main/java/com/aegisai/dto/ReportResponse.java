package com.aegisai.dto;

public class ReportResponse {

    private long totalUsers;
    private long totalThreats;
    private long totalIncidents;
    private long totalNotifications;

    public ReportResponse() {
    }

    public ReportResponse(long totalUsers,
                          long totalThreats,
                          long totalIncidents,
                          long totalNotifications) {
        this.totalUsers = totalUsers;
        this.totalThreats = totalThreats;
        this.totalIncidents = totalIncidents;
        this.totalNotifications = totalNotifications;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalThreats() {
        return totalThreats;
    }

    public void setTotalThreats(long totalThreats) {
        this.totalThreats = totalThreats;
    }

    public long getTotalIncidents() {
        return totalIncidents;
    }

    public void setTotalIncidents(long totalIncidents) {
        this.totalIncidents = totalIncidents;
    }

    public long getTotalNotifications() {
        return totalNotifications;
    }

    public void setTotalNotifications(long totalNotifications) {
        this.totalNotifications = totalNotifications;
    }
}