package com.aegisai.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalThreats;
    private long totalIncidents;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalUsers, long totalThreats, long totalIncidents) {
        this.totalUsers = totalUsers;
        this.totalThreats = totalThreats;
        this.totalIncidents = totalIncidents;
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
}