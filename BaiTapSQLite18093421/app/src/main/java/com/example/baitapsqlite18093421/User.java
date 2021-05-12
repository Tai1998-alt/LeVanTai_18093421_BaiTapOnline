package com.example.baitapsqlite18093421;

public class User {
    private int id;
    private String name;
    private int edit;
    private int delete;

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public User( String name, int edit, int delete) {
        this.name = name;
        this.edit = edit;
        this.delete = delete;
    }

    public User() {
    }
}
